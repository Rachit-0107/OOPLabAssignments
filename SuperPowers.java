//You are given a Parent and Child class definition in the code template. Follow the instructions given in the comments of the class methods to get the desired output.
//
//You should intantiate two objects of the Child class c1 and c2. For the first object you, should instantiate it using the parameterless constructor and for the second object you should initialize it with the parameterized constructor taking arguments as the input parameters from STDIN.
//
//Input Format
//
//Each testcase contains a single line of input, containing 2 integers  and . You should pass the tuple (, ) as arguments to the parameterized constructor of the Child class in the main method.
//
//Constraints
//
// <=  <= 
//
//Output Format
//
//For each testcase, output 6 lines of output. For the first 3 lines, the output should be generated by the print method of object c1 and the next 3 lines should be generated by the print method of object c2.



import java.io.*;
import java.util.*;
import java.util.Scanner; 

class Parent{
	int a;
    int b;
  
    Parent(){
    	a = 5;
        b = 10;
    }
  
    Parent(int a, int b){
         /* implement the parameterized constructor to set the value of a and b. */ 
        this.a = a; 
        this.b = b; 
    }
}

class Child extends Parent{
	int b;
  
    Child(){
    	/*
           implement the parameterless constructor to set the value of b in the child class
           object as 3;   
        */ 
        this.b =3; 
    }
  
    Child(int a, int b){
        /* 
        	implement the parameterized constructor for this class using the values a and b. 
        	The parent class object should have two times the value of b compared to the 
            child class. Do not add any new instance variables!  
        */
        this.a = a; 
        this.b = b; 
        super.b = 2*b; 
    }
  
    void print(){
    	/* 
        	implement the print method to print the value of a in the child class, b in the parent class and b in the 
            child class. Print these three values on three separate lines. 
        */ 
        System.out.println(a); 
        System.out.println(super.b); 
        System.out.println(b); 
    }
}



public class SuperPowers {

    public static void main(String[] args) {
        /* 
        	Complete the class definition given above and use appropriate methods in this 
        	main function to get the desired answer 
        */ 
        Scanner in = new Scanner(System.in); 
        int a, b ; 
        a = in.nextInt(); 
        b = in.nextInt(); 
        Child c1 = new Child(); 
        Child c2 = new Child(a,b); 
        c1.print(); 
        c2.print(); 
    }
}