//You'll be reading a string from the console. Your task is to reverse that string word by word (each individual word is not to be reversed) and print that to the console. Each word in the given string would be separated by a single space. However, the string may contain leading or trailing spaces. The answer should not have any such leading or trailing spaces.
//
//Input Format
//
//A string 
//
//Constraints
//
//0 < |s| < 10^4
//
//Output Format
//
//A single string



import java.io.*; 
public class ReverseString {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(isr); 
        String temp; 
        temp = br.readLine(); 
        temp = temp.trim(); 
        String sentence[] = temp.split(" ",-1); 
        for(int j = sentence.length-1;j>=0; j--)
        {
            System.out.print(sentence[j]+" ");
        }
    }
}