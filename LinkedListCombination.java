//You will be given two sequences of integers  and . You need to create a third linked list  such that  where  is the linked list  in reverse order. In other words,  is a linked list consisting of the elements of  followed by  in reverse order.
//
//You will be given  on the linked list . Each of the query asks for the element in ,  or  at position  from the start. Note that the positions in the query are 1-indexed. If the position in a query is invalid, print "Invalid query".
//
//Input Format
//
//Each test case is of the following form:
//
//The first line contains a single integer , denoting the size of linked list .
//The second line contains  space-separated integers, denoting the elements of linked list  in order.
//The third line contains a single integer , denoting the size of linked list .
//The fourth line contains  space-separated integers, denoting the elements of linked list  in order.
//The fifth line contains a single integer , denoting the number of queries.
//The next  lines contain two space-separated integers  and .  denotes the linked list to query (0 for , 1 for  and 2 for ) and  denotes the position to be queried.
//Constraints
//
//Output Format
//
//For each testcase, output  lines, each containing the response for the queries.
//



import java.io.*;
import java.util.*;  
/* import other necessary libraries if required */

/* 	NOTES: 
	
    You are not allowed to do the following:
		- Declare additional instance variables
        - Declare any global variables (global to the entire program)
        - Change the class definition and method signature already given
        - Add additional methods
    
    You are free to do the following:
    	- Declare local variables
*/

class LinkedListHandler{
  	private LinkedList<Integer> ll;
  
  	LinkedListHandler(){
  		/* implement the constructor to initialize the linked list */	 
        ll = new LinkedList<>();
  	}
	
  	public void populate(int element){
    	/* implement the overloaded method to add an element to the linked list taken from standard input */  
        ll.add(element); 
    }
  
  	public void populate(LinkedList<Integer> r, LinkedList<Integer> s){
    	/* implement the overloaded method to populate elements from two linked lists r and s */ 
        ll.addAll(r); 
        for(int i = s.size()-1; i>-1; i--)
        {
            ll.add(s.get(i));
        }
    }
  
  	public void queryResponse(int pos){
    	/* 
        	implement this method to return the element of the linked list at position "pos"
        	or indicate an invalid query
        */	
        if(pos>0 && pos<ll.size()+1)
        {
            System.out.println(ll.get(pos-1)); 
        } 
        else
        {
            System.out.println("Invalid query");
        }
    }
}

class LinkedListCombination {

    public static void main(String[] args) {  
        LinkedListHandler objr = new LinkedListHandler(); 
        LinkedListHandler objs = new LinkedListHandler(); 
        LinkedListHandler objt = new LinkedListHandler(); 
        LinkedList <Integer> r = new LinkedList<>();
        LinkedList <Integer> s = new LinkedList<>(); 
        Scanner in = new Scanner(System.in);
        int sizer = in.nextInt();
        for(int i =0; i<sizer; i++)
        {
            int a = in.nextInt(); 
            objr.populate(a); 
            r.add(a);
        } 
        int sizes = in.nextInt();  
        for(int i =0; i<sizes; i++)
        {
            int a = in.nextInt(); 
            objs.populate(a); 
            s.add(a); 
        }  
        objt.populate(r,s); 
        
        int q = in.nextInt(); 
        for(int i = 0; i<q; i++)
        {
            int query_type = in.nextInt(); 
            int pos = in.nextInt();
            if(query_type == 0)
            {
                objr.queryResponse(pos);
            } 
            else if(query_type == 1)
            {
                objs.queryResponse(pos);
            } 
            else
            {
                objt.queryResponse(pos);
            }
        }
        
    }
}