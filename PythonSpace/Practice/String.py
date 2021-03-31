str = "My Name is Dhrubajit"
str1 = "Dhrubajit.das"
# Substring
print(str[0:3])
print(str[3:7])
print(str[8:10])
print(str[11:20])

if str1 in str:
    print("case PASS")
else:
    print("case FAILED")

newStr = str1.split(".")
print(newStr)
