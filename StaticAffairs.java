//You are given a class definition TestStatic1 in the code template, with a static variable a. Two objects of this class, ts1 and ts2 have also been instantiated for you in the driver class' main method.
//
//You will be provided an input integer  in each testcase. Use this integer to set the value of the static variable a. Your task is to print the initial value of a (before the mutation) using ts1 and final value of a using ts2. Also, make a note of the answer that you get and try to deduce why it should be the expected answer.
//
//Input Format
//
//Each testcase contains a single line as input, containing a single integer .
//
//Constraints
//
//0 <=  <= 
//
//Output Format
//
//For each testcase, output two lines. The first line should contain the value of a and the second line should contain the final value of a.



import java.io.*;
import java.util.Scanner; 

class TestStatic1{
	static int a = 10;
  
  	static void setA(){
    	a = 6;
    }
}

public class StaticAffairs {

    public static void main(String[] args) {
        /* Take input from STDIN for n and set the value of a in the class above to n. Add methods to print the value of a before the mutation and after the mutation. */ 
        int n; 
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); 
        TestStatic1 ts1 = new TestStatic1();
        ts1.setA(); 
        System.out.println(ts1.a); 
        ts1.a = n; 
        System.out.println(ts1.a); 
    }
}

