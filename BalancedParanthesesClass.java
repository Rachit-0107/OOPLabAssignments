//A string containing parantheses is said to be balanced if every opening brace has a corresponding closing brace. For example, {{}}, {}{}, {}{{}{}} are balanced, while {, {{}, }{}{ are not balanced strings.
//
//You need to implement a class which checks if an input string of parantheses is balanced or not.
//
//The following algorithm demonstrates the steps required to check if a string is balanced or not:
//
//Maintain a stack of characters, which stores the braces in the input string.
//Whenever an opening brace ('{') is encountered, add it to the stack.
//Whenever a closing brace ('}') is encountered, remove the most immediate opening brace from the stack, if possible. Otherwise, add the closing brace to the stack.
//Test if the string was balanced or not. This depends on a property of the final stack. Can you figure it out?
//NOTE: this challenge has no partial marking. You need to clear all testcases in order to gain marks.
//
//Input Format
//
//Each testcase contains a single line containing a string , denoting the input parantheses string.
//
//Constraints
//
//, where  denotes the length of .
//
//Output Format
//
//For each testcase, output a single line. If the input string was balanced, print "Balanced". Otherwise, print "Not balanced" (be careful as the outputs are case-sensitive!).
//
//


import java.io.*;
import java.util.*;
/* import other libraries (if required) */

/* 	NOTES: 
	
    You are not allowed to do the following:
		- Declare additional instance variables
        - Declare any global variables (global to the entire program)
        - Change the class definition and method signature already given
        - Add additional methods
    
    You are free to do the following:
    	- Declare local variables
*/

class BalancedParantheses{
    private Stack<Character> braces;
      
      BalancedParantheses(){
        /* implement the constructor to initiate the stack of braces */  
        braces = new Stack<>();
    }
  
      public void handleOpeningBrace(){ 
      braces.add('{');
    }
  
      public int handleClosingBrace(){ 
        if(braces.isEmpty()== false)
        {
            braces.pop(); 
            return 0; 
        } 
        else 
        {
            return 1; 
        }
        
    }
  
      public void testForBalance(){ 
        if(braces.isEmpty() == true)
        {
            System.out.println("Balanced"); 
        } 
        else
        {
            System.out.println("Not balanced");
        }
          
    }
}

class BalancedParanthesesClass {

    public static void main(String[] args) { 
        
        String braces; 
        Scanner in = new Scanner(System.in);
        BalancedParantheses obj = new BalancedParantheses();
        braces = in.next(); 
        int a = 0; 
        for(int i =0 ; i<braces.length(); i++)
        {
            if(braces.charAt(i) == '{')
            {
                obj.handleOpeningBrace();
            } 
            else if(braces.charAt(i) == '}')
            {
                a = obj.handleClosingBrace(); 
                if(a == 1)
                {
                    System.out.println("Not balanced"); 
                    break;
                }
            } 
            else
            {
                ;
            }
        } 
        if(a == 0)
        {
            obj.testForBalance();
        }
        
    }
}