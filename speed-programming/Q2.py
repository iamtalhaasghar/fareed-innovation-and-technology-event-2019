startingNumber=int(input("Enter Starting Number"))  #Taking StartingPoint
EndingPoint=int(input("Enter Ending point"))              #Taking Ending Point

for i in range(startingNumber,EndingPoint+1):   #Loop From Start Point TO End Point
    isPrime=0
    for j in range(1,i+1):     
        if(i%j==0):                           #Checking If Number Is Divisble by Other Number 
            isPrime+=1
    if(isPrime==2):             #If Number Is Divisvle By  2Numbers it means its prime
        print(i)


