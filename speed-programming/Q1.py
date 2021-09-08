print("Enter 5 Numbers : ")
inputArray=list()        #Decalring A Variable of Type List
for j in range(0,5):
    inputArray.append(int(input()))   #Taking 5 Inputs From User And Adding In List
for j in inputArray:
    print(2*j," ",end ='')       #Printing Double of That input