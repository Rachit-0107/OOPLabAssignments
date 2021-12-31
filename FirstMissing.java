//Given a list of numbers, find the smallest positive number that is absent from the list. A positive number is defined as any integer greater than or equal to 1. Since lookups (searching) queries are on average constant time operations in HashSets, it is an appropriate datastructure to use for this problem.
//
//Input Format
//
//The first line would contain an integer n, the count of numbers in the list. The next line would contain n space separated integers.
//
//Constraints
//
//0 < n < 10^4
//
//Output Format
//
//A single integer


import java.util.*;

class MissPositive{
	private HashSet<Integer> set;
	public MissPositive(List<Integer>list){ 
        set = new HashSet<Integer>(); 
        set.addAll(list); 
	}
	public int firstMiss(){ 
        int a = 1; 
            while(true)
            {
                if(set.contains(a) == true)
                {
                    a++;
                } 
                else
                {
                    break; 
                }
            } 
        return a; 
	}
}

public class FirstMissing {

	public static void main(String[] args) {
		List<Integer> list;
		MissPositive obj; 
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
        list = new ArrayList<Integer>();
        for(int i = 0; i<n;i++)
        {
            int a = in.nextInt(); 
            list.add(a);
        } 
        obj = new MissPositive(new ArrayList<Integer>(list));
		System.out.println(obj.firstMiss());
	}

}

