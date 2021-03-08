from Practice.OppsDemo import Calculator


class ChildImplementation(Calculator):
    num3 = 400

    def getalldata(self):
        print(self.num3)


obj = ChildImplementation()
obj.getalldata()
