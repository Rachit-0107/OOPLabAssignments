//You'll be reading two lists of unique integers from the console. If the smaller of the two lists is a subset of the bigger list, print "Subset" to the console. Otherwise, print the integer with the smallest index from the smaller list that is not a part of the bigger list. It is guaranteed that the sizes of both the lists would not be the same. You are encouraged to use an appropriate datastructure that has been discussed in the lectures to solve this problem optimally (Hint: Think of hashing). Do all I/O operations from the main method, and use the FindSub class to solve the problem. In particular, use the isSubset method to return the output string which would then be printed in the main method.
//
//Input Format
//
//Input would consist of four lines. The first line would have a single integer n1 which is the size of the first list. The second line would have n1 space separated integers. The third line would have a single integer n2 which is the size of the second list. The fourth line would have n2 space separated integers.
//
//Constraints
//
//0 < n1 <= 10^5
//
//0 < n2 <= 10^5
//
//n1 != n2
//
//Members of both lists would fit inside a 32 bit signed integer.
//
//Output Format
//
//A single string, which would either be "Subset" or the first invalid number as the case may be. 


import java.util.*;

class FindSub{
	private List<Integer> list1;
	private List<Integer> list2;
	public FindSub(List<Integer>bigList, List<Integer>smallList) { 
        this.list1 = bigList; 
        this.list2 = smallList; 
	}
	public String isSubset() { 
        if(list1.containsAll(list2) == true)
        {
            return "Subset";
        } 
        else
        {   
            String str = ""; 
            for(int i =0; i<list2.size(); i++)
            {
                if(list1.contains(list2.get(i)) == false)
                {
                    str = String.valueOf(list2.get(i));
                    break;  
                } 
            }  
            return str; 
        }
	}
	
}

public class SubSetArr {

	public static void main(String[] args) { 
        Scanner in = new Scanner(System.in); 
		Integer n1 = in.nextInt();
		List<Integer> list1; 
        list1 = new ArrayList<>(); 
        for(int i =0; i<n1; i++)
        {
            int a = in.nextInt(); 
            list1.add(a); 
        }
		Integer n2 = in.nextInt();
		List<Integer> list2;
        list2 = new ArrayList<>(); 
        for(int i =0; i<n2; i++)
        {
            int a = in.nextInt(); 
            list2.add(a); 
        }
		//read input
		FindSub obj; //instantiate the object properly 
        if(n1>n2)
        {
            obj = new FindSub(list1 , list2);
        } 
        else
        {
            obj = new FindSub(list2 , list1);
        }
		System.out.println(obj.isSubset());
	}

}