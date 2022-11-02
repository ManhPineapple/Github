                    #Introduction
print("Hello, World!")
#This is a comment

                    #Variable/Datatype
x = 5
y = "John"
print(float(x))
print(y)

z = 1 + 2j
print(z)

                    #String
a = "Hello, World!"
for x in a:
    print(x, end="")
print()
print("World" in a)

                    #Function
def func(a, b):
    return a + b
(a, b) = (1, 2) #Tuple
print(func(a, b))

                    #Collection - List
list = ["apple", "banana", "coconut"]
list.append("apple")
list.append("donut")
list.insert(2, "elephant")
list.sort()
print(list)

                    #Collection - Tuple
tuple = (1, 3, 5, 7)
(a, b, c, d) = tuple
print(tuple)
print(a, b, c, d)


                    #Collection - Set
set1 = set(tuple)
set2 = {1, 1, 3, 4}
set2.add(6)
print(set2)
print(set1.intersection(set2))

                    #Collection - Dictionary
dict = {
    "name": "Manh",
    "yOb": 2002,
    "country": "Hung Yen"
}

dict["key"] = "value"

print(dict)
print("name" in dict)
print("Manh" in dict)
x = dict.values()
y = dict.items()
print(x)
print(y)

                    #Python class
class Person:
    def __init__(self, fname, lname):
        self.firstname = fname
        self.lastname = lname

    def __init__(self):
        self.firstname = "Nghia"
        self.lastname = "ngu"  
    
    def printname(self):
        print(self.firstname, self.lastname)

x = Person()
x.printname()