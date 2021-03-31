from Practice.OppsDemo import Calculator , Animal


class ChildImplementation(Calculator, Animal):
    num3 = 400
    def __init__(self):
        Calculator.__init__(self,5,10)

    def getalldata(self):
        print(self.num3)


obj = ChildImplementation()
obj.summation()
print("Parent Class Variable: {}".format(obj.num))
print("Parent Class Variable: {}".format(obj.num1))
print("Parent Class Variable: {}".format(obj.num2))
print("Child Class Variable: {}".format(obj.num3))
print("Animal Class method Access: ".format(obj.move()))
print("Animal Class method Access: ".format(obj.eat()))




