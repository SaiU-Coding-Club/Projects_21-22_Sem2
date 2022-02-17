#Inspired from Sarang- 25 Java version
#Author - KaushikS-25

# Function to create matrix
def creatematrix(n,m):

    for i in range(0,n):
        row = []
        for j in range(0,n):
            row.append(int(input(f"Enter the number to enter into the position ({i+1},{j+1}):")))
        m.append(row)

    a = input("Type A to print the matrix or B to directly get the determinant:")
    if a =="A" or "a":
        printmatrix(n,m)
    elif a =="B" or "b":
        det(m)
    else:
        print("False value")

#Function to print the matrix in a structured form
def printmatrix(n,m):
    print('\n')
    for i in range(n):
        for j in range(n):
            print(m[i][j], end="")
            if j== n-1:
                print("| \n")
    a =input(("Want to calculate the det:(y/n):"))
    if a == 'y':
        det(m)
    else:
        pass


#function to calculate the minor matrix eliminating ith row and jth column    
def matrixminor(m,i,j):
    #this return statement removes ith row and jth column from the matrix and provides the matrix of remaining terms
    return [row[:j] + row[j+1:] for row in (m[:i]+m[i+1:])]

def det(m):
    #if matrix is 2x2, then det is ac-bd
    if len(m) == 2:
        d = m[0][0]*m[1][1] - m[0][1]*m[1][0]
        print(d)

    s = 0

    for i in range(len(m)): # take that i here represents the columns of the matrix
        sign = (-1) ** (i) #assigning the sign 
        cofact = det(matrixminor(m,0,i)) # Det of minor matrix
        s += sign* m[0][i] * cofact #calculating the det

    print(s)


n = int(input("enter the order of the nxn matrix  you want to create:"))
m = []
creatematrix(n,m)
