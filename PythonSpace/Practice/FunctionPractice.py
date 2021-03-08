from selenium import webdriver
def GreetMe(name):
    print("Good Morning {}".format(name))

def AddIntegers(num1, num2):
    result = num1 + num2
    return result
GreetMe("Dhrubajit")
print("Addition of 2 number is : {}".format(AddIntegers(4, 10)))
