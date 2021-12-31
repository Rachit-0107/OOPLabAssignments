//You'll be reading a list of numbers from the console. For each number, you have to find the first element to the right of it that is greater than it. If no such number exists, the answer should be -1. The answer for the last number would always be -1. Make a List of the answers for each integer and later print that list as a string to the console.
//
//You will find that a Stack is a very appropriate datastructure to use for this problem.
//
//Input Format
//
//The first line would contain an integer n, the list of numbers in the list. The next line would contain n space separated integers.
//
//Constraints
//
//0 < n < 10^4
//
//Output Format
//
//A list of integers as a string 


import java.util.*;

class NextGreater1{
    private List<Integer> list = new ArrayList<Integer>();
    private Stack<Integer> st;
    public NextGreater1(List<Integer>list) { 
        
        this.list = list;
    }
    public List<Integer> findAnswers(){ 
        List<Integer> answer = new ArrayList<>(); 
        int length = list.size();
        
        for(int i =0; i<length;i++)
        {
            int a = -1;
            for(int j = i+1; j<length;j++)
            { 
                if(list.get(i) < list.get(j))
                {
                    a = list.get(j);
                    break;
                }
            } 
            answer.add(a);
        }
        return answer;
    }
}

public class NextGreater {

    public static void main(String[] args) {
        List<Integer> list;
        NextGreater1 obj; 
        Scanner in = new Scanner(System.in);
        int n= in.nextInt(); 
        list = new ArrayList<Integer>();
        for(int i =0; i < n; i++)
        {
            int a = in.nextInt(); 
            list.add(a);
        } 
        obj = new NextGreater1(list);
        System.out.println(obj.findAnswers().toString());
    }

}