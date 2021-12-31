//You will be given a positive integer  in the input. You need to print the following pattern corresponding to :
//
//Print  lines of output, each containing  space-separated integers, where  is the line number.
//The first line contains the single integer 1.
//Each of the next  lines contain  space-separated integers starting from  (inclusive), where  is the last integer in the previous line.
//Input Format
//
//Each testcase contains a single line of input, containing a single integer .
//
//Constraints
//
// <=  <= 
//
//Output Format
//
//Each testcase should contain  lines of output, as described in the problem statement.



import java.io.*;

public class PatternPrinting {

    public static void main(String[] args) throws IOException { 
        int no_of_lines, k=2; 
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(isr); 
        String temp = br.readLine(); 
        no_of_lines = Integer.parseInt(temp); 
        
        for(int i =0; i<no_of_lines; i++)
        {
            k--; 
            for(int j = 0; j<i+1; j++)
            {
                System.out.print(k+" "); 
                k++; 
            } 
            System.out.print("\n"); 
        }
        
    }
}

  