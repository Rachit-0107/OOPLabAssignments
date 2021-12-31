//While we typically write arithmetic expressions in the infix notation, i.e with the operator written between the two operands, expressions can also be written in the postfix notation, i.e with the operator written after the two operands. (5/3 in infix would be written as 53/ in postfix). This form of notation has one significant advantage over the infix form as it eliminates the need for brackets to enforce the order of operation. You can read more about the postfix notation here: https://en.wikipedia.org/wiki/Reverse_Polish_notation
//
//You'll be reading a bunch of strings from the console. These strings would either be a number or an operator ("+", "-", "*", "/"). Your task is to evaluate the result of the postfix expression made by these strings and print the result to the console.
//
//Input Format
//
//The first line would be an integer n. The next n lines would either contain an integer or an operator symbol
//
//Constraints
//
//3 <= n <= 10^4
//
//Output Format
//
//A single integer

import java.util.*;

class RPN{
    private List<String> myList;
    public RPN(List<String> list) {  
        myList = new ArrayList<String>(); 
        myList.addAll(list);
    }
    public int evaluate() { 
        Stack<String> str = new Stack<String>();
        int solution = 0;  
        for(int i = 0; i<myList.size(); i++)
        {   
            if(myList.get(i).equals("/")==true)
            {
                int b = Integer.parseInt(str.pop());
                int a = Integer.parseInt(str.pop());
                solution = a/b; 
                String ans =Integer.toString(solution);
                str.push(ans);
            }
            else if(myList.get(i).equals("*")==true)
            {
                int b = Integer.parseInt(str.pop());
                int a = Integer.parseInt(str.pop());
                solution = a*b; 
                String ans =Integer.toString(solution);
                str.push(ans);
            } 
            else if(myList.get(i).equals("+")==true)
            {
                int b = Integer.parseInt(str.pop());
                int a = Integer.parseInt(str.pop());
                solution = a+b;
                String ans =Integer.toString(solution);
                str.push(ans);
            } 
            else if(myList.get(i).equals("-")==true)
            {
                int b = Integer.parseInt(str.pop());
                int a = Integer.parseInt(str.pop());
                solution = a-b;
                String ans =Integer.toString(solution);
                str.push(ans);
            } 
            else
            {
                str.push(myList.get(i));
            }
        } 
        solution = Integer.parseInt(str.peek());
        return solution; 
    }
}

public class EvaluateRPN {

    public static void main(String[] args) {
        List<String> arr; 
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt(); 
        arr = new ArrayList<String>(); 
        for(int i =0; i<n; i++)
        {
            String a = in.next(); 
            arr.add(a); 
        }
        RPN obj = new RPN(arr);  
        System.out.println(obj.evaluate());
    }

}
