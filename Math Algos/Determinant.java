//Java program to find Determinant of any square matrix using recursion (OOP style)
//Author: Sarang-25

import java.util.Scanner;

public class Determinant {  //Every java program is created as a class with the name of the file
    
    //Creates Scanner obj to receive user input
    Scanner input=new Scanner(System.in);
    
    double a[][];int n; //2d array to store the input square matrix
    
    Determinant(){} //Creates class Determinant so that obj can be created and fns call be called
    
    //Fn to input user defined matrix
    void getMat(){
        System.out.print("Enter the order of the Determinant: ");
        n=input.nextInt();
        a=new double[n][n];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print("Enter element "+(j+1)+" of row "+(i+1)+": ");
                a[i][j] = input.nextDouble();
            }
        }        
    }
    
    //Fn to cofactor of a specific element of a matrix
    double[][] cofactor(double[][] mat, int r, int c){  //r=row, c=col
        int l=mat.length;
        double[][] x=new double[l-1][l-1];
        int ii=0;
        for(int i=0;i<l;i++){
            if(i==r) continue;      //skips current row         
            int jj=0;
            for(int j=0;j<l;j++){
                if(j==c) continue;  //skips current col
                x[ii][jj]=mat[i][j];
                jj++;
            }
            ii++;
        }
        return x;
    }
    
    //Recursive fn to calculate determinant for matrix of any order
    double det(double M[][],int n){
        double result;
        if(n==2) result=M[0][0]*M[1][1]-M[1][0]*M[0][1];    //Base case
        else{                                               //Recursive case
            result=0;
            for(int j=0;j<n;j++){
                double[][] m=cofactor(M,0,j);   //Calls cofactor fn
                result+=(Math.pow(-1.0, 2+j)*M[0][j]*det(m, n-1));  //Recursive step
            }
        }
        return result;
    }
    
    //Displays any determinant given as input
    void display(){
        System.out.println("Determinant");
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print("|");
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+"  ");}
            System.out.println("|");
        }
    }
    
    //Main fn
    public static void main(String[] args) {          
        Determinant d=new Determinant();    //Creates an obj to call fns
        d.getMat();     //calls det input fn
        d.display();    //calls det display fn
        System.out.println("= "+d.det(d.a,d.n));    //Calls det fn and prints value
    }    
}
