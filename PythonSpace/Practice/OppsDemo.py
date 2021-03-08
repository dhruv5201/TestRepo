class Calculator:
    num = 100  # Class variable

    # Constructor
    def __init__(self, a, b):
        self.num1 = a
        self.num2 = b
        print("I do called automatically when object is created.")

    def getdata(self):
        print("Inside the getData of a class")

    def summation(self):
        print(" In Summation method.")
        result = self.num1 + self.num2
        print("Summation Result is: {} ".format(result))


obj = Calculator(10, 20)

obj.getdata()
obj.summation()
