print("ENTER YOUR CHOICE: \n 1:ADD\n 2:SUBTRACT \n 3:DIVIDE \n 4:MODULUS \n 5:MULTIPLY")
a=int(input())
print("ENTER TWO NUMBERS WITH SPACE")
b=input() #taking string
c=b.split()  #splitting both values
if(a==1):
    print("Result: ")
    print(int(c[0])+int(c[1]))   #add
if(a==2):
    print("Result: ")
    print(int(c[0])-int(c[1]))  #subtract
if (a == 3):
    print("Result: ")
    print(int(c[0])/int(c[1]))     #divide
if (a == 4):
    print("Result: ")
    print(int(c[0])%int(c[1]))    #modulus
if (a == 5):
    print("Result: ")
    print(int(c[0])*int(c[1]))    #multipy