//Read a given number of strings from the console and print them again along with their frequency. Note that the order of printing needs to be in reverse lexicographical order, i.e "zz" should be printed along with its frequency before "aa" and its frequency. The pattern of printing has been illustrated in the sample case given below. You will find that a TreeMap is an appropriate datastructure to use for this problem. If you do not have much information about TreeMap and the Comparator Interface, I suggest you read the following webpage carefully:
//
//https://www.geeksforgeeks.org/treemap-in-java/
//
//Input Format
//
//The first line would have an integer n, the number of strings to be read.
//
//The next n lines would contain a string.
//
//Constraints
//
//0<= n <=10^5
//
//The size of each string would be two lettered and would be made of lowercase alphabets only.
//
//Output Format
//
//A string followed by a colon followed by its frequency for each unique string in the input. Look at the sample case to get a better idea.
//


import java.util.*;


public class SortCount {

	public static void main(String[] args) {
		 //use appropriate constructor to initialise 
        TreeMap<String, Integer> mp = new TreeMap<String, Integer>(new Comparator<String>(){
             public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
        String[] arr = new String[n]; 
        for(int i =0; i<n; i++)
        {
            String str = in.next();
            if(mp.containsKey(str)==true)
            {
                int a = mp.get(str); 
                mp.replace(str,a+1);
            } 
            else
            {
                mp.put(str,1);
            }
        } 
         for (Map.Entry mapElement : mp.entrySet()) {
            System.out.println(mapElement.getKey()+ ":"+mapElement.getValue());
        }
		
	}

}