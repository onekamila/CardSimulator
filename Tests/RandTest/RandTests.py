import threading
import timeit


class TimeThread(threading.Thread):
    def __init__(self, threadID, randFunction, runStr, runs=52):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.randFunction = randFunction
        self.runStr = runStr
        self.count = 0
        self.runs = runs

        self.outFileName = "rand" + str(self.threadID) + "Out.txt"
        outFile = open(self.outFileName, 'w')
        outFile.close()
        self.setupStr = "from random import " + self.randFunction
        self.runStr = "outFile = open(\"" + self.outFileName + "\", 'a') ; outFile.write(str(" + self.runStr + ") + \"\\n\"); outFile.close()"
    
    def __getCount__(self):
        outFile = open(self.outFileName, 'r')
        contents = outFile.read().split('\n')
        outFile.close()
        self.count = contents.count("True")
        self.bias = self.count / self.runs

    def run(self):
        timer = timeit.Timer(self.runStr, self.setupStr)
        self.delta = (timer.timeit(self.runs) / self.runs)
        
        self.__getCount__()

    def __getBiasStr__(self):
        outStr = str(self.bias) + " ("
        if(self.bias < 0.49):
            outStr += "biased to False)"
        elif(self.bias > 0.51):
            outStr += "biased to True)"
        else:
            outStr += "unbiased)"
        return outStr

    def __str__(self):
        outStr = "function: random." + self.randFunction + "()"
        outStr += "\n\tavg. time: " + str(self.delta) + " sec"
        outStr += "\n\tbias: " + self.__getBiasStr__()
        outStr += "\n\truns: " + str(self.runs)
        
        return outStr


def main():
    thread1 = TimeThread(1, "choice", "choice([True, False])")
    thread2 = TimeThread(2, "randint", "(not randint(0, 1))")
    thread3 = TimeThread(3, "getrandbits", "(not getrandbits(1))")
    thread4 = TimeThread(4, "random", "(random() >= 0.5)")

    threads = [thread1, thread2, thread3, thread4]

    for thread in threads:
        thread.start()

    for thread in threads:
        thread.join()
    
    for thread in threads:
        print(thread)


if __name__ == "__main__":
    main()