//Each ice cream flavored is identified by either a upper case or a lower case character. You'll be given two strings. The first string would have all the flavours present in the shop, and the second string would have all the chocolate flavours. Find the count of the number of chocolate flavoured icecreams for sale in the shop. Because of constant time lookups, you'll find that using a HashSet is a very efficient way of solving this problem
//
//Input Format
//
//Two strings. First would have all the flavors, and the second would have the chocolate flavors.
//
//Constraints
//
//Lengths of both strings would be less than 50
//
//Output Format
//
//An integer


import java.util.*;  
import java.io.*;

class FindChoc{
    private String allFlav;
    private String chocFlav;
    private HashSet<Character> set;
    public FindChoc(String allFlav, String chocFlav) { 
        this.allFlav = allFlav; 
        this.chocFlav = chocFlav; 
        set = new HashSet<Character>();
        this.populateSet();
    }
    private void populateSet() { 
        List<Character> temp = new ArrayList<Character>();
        for(int i=0; i<allFlav.length(); i++)
        {
            temp.add(allFlav.charAt(i));
        }
        set.addAll(temp);
    }
    public int countChoc() { 
        int a =0; 
        List<Character> temp = new ArrayList<Character>();
        for(int i=0; i<chocFlav.length(); i++)
        {
            temp.add(chocFlav.charAt(i));
        } 
        HashSet<Character> temp_set = new HashSet<Character>();
        temp_set.addAll(temp);
        for(int i=0; i<allFlav.length();i++)
        {
            if(temp_set.contains(allFlav.charAt(i)))
            {
                a++;
            }
        }
        return a;
    }
}

public class ChocolateIcecreams {

    public static void main(String[] args) throws IOException{ 
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader br= new BufferedReader(isr) ;
        String allFlav = br.readLine(); 
        String chocFlav = br.readLine();
        FindChoc obj; 
        obj = new FindChoc(allFlav,chocFlav);
        System.out.println(obj.countChoc());
    }

}