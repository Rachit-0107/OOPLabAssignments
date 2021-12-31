//You have to implement two classes.
//
//The first class is called ThreeSum which has an array as a private instance member and supports three queries on it:
//
//Printing the Array (printArr method): Returns the sorted representation of the array as a String. The format followed would be the same as that of Arrays.toString(). Look at the example test case for a better idea.
//
//Replacing a current number in the array with another number (replace method): If you ensure that your data is always kept in a sorted order, you could do this more efficiently than a simple linear scan. Between two replace queries, there would always be atleast one non replace query (either a print querry or a sumExists query).
//
//Finding out if there exist three numbers in the array(without repitition) that sum to a given target (sumExists method) : This method returns a String which is supposed to be the toString() representation of a customReturn object(more details on the class below. The way you're supposed to return from the method has been illustrated in the sample code). If you keep your data in a sorted order, you could implement this method using only two nested loops rather than three. It is guarenteed that there would be a unique tuple of indexes if a valid tuple does indeed exist. Note that you have to find the indexes of the numbers (0 indexed) that add to the given target. The indexes should correspond to the numbers arranged in a sorted order.
//
//The second class to be implemented is called the CustomReturn class. It is this class that the sumExists method of the ThreeSum class will use to return its information. This has two instance variables:
//
//A boolean variable called found. This should be set to true if sumExists is able to find three numbers which sum up to target.
//
//An array of integers called indexes. This shall be used to store the indexes of the answer.
//
//You have to override toString() for CustomReturn. If a valid index is not found, it should return "No Valid Indexes exist!". Otherwise it should return the indexes in sorted order as a String (space separated).
//
//It is recommended that you do the I/O operations (reading and writing with respect to the console) from the main method and not from the methods of either the CustomReturn class or the ThreeSum class.
//
//Input Format
//
//The first line would contain n, the size of the array. The second line would contain n space separated integers (guarenteed to be sorted) which would form the initial array. The third line would contain q, the number of queries. The next q lines would have the details of the queries:
//
//If the first digit is 0, then you're supposed to print the array.
//If the first figit is 1, then this would be followed by two more space separated integers. You're supposed to replace the first number with the second in the array.
//If the first digit is 2, then this would be followed by one more space separated integer. That integer represents the target that you're supposed to find as the sum. Print either "No Valid Indexes exist!" or the indexes of the solution (in sorted order) as the case may be.
//Constraints
//
//3 <= n <= 100
//
//1 <= q <= 10 



import java.io.*;
import java.util.*;

class CustomReturn {
	private boolean found;
	private int[] indexes;
	public CustomReturn(){
		found = false;
	}
	public CustomReturn(int a, int b, int c) {
		found = true; 
        indexes = new int[3];
        indexes[0] = a;
        indexes[1] = b; 
        indexes[2] = c; 
	}
	
	@Override
	public String toString() {
        if(found == false)
        {
           return "No Valid Indexes exist!";
        } 
        else
        {
            String str = indexes[0]+" "+indexes[1]+" "+indexes[2];
            return str;
        } 
    }
}
class ThreeSum {
	
	private int[] arr;
	
	private boolean isSorted;
	
	public ThreeSum(int[] arr) 
    {
        this.arr = arr;  
    }
	
	public void replace(int first, int second) { 
        for(int i = 0; i<arr.length ; i++)
        {
            if(arr[i] == first)
            {
                arr[i] = second; 
            }
        } 
        Arrays.sort(arr); 

	}
	
	public String printArr() { 
        Arrays.sort(arr); 
        System.out.println(Arrays.toString(arr)); 
        return ""; 
	}
	
	public String sumExists(int target) { 
        int found = 0; 
        int a=0,b=0,c=0; 
        for(int i = 0; i<arr.length; i++)
        {
            for(int j =i+1; j<arr.length;j++)
            {
                for(int k = j+1; k<arr.length; k++)
                {
                    if(arr[i]+arr[j]+arr[k]==target)
                    {
                        found = 1;  
                        a = i; 
                        b = j; 
                        c = k; 
                    } 
                }
            }
        }
        
        if(found == 0){
        return (new CustomReturn()).toString();
        } 
        else if(found == 1)
        { 
            return (new CustomReturn(a,b,c)).toString();
        }
        else
        {
         return null;
        }
    }
}

public class SumOfThree {

    public static void main(String args[]) {
        Scanner in  = new Scanner(System.in); 
        int no_of_elements = in.nextInt(); 
        int[] arr; 
        arr = new int[no_of_elements]; 
        for(int i = 0; i<no_of_elements; i++)
        {
            arr[i] = in.nextInt(); 
        }
        int no_of_queries = in.nextInt(); 
		ThreeSum myObj = new ThreeSum(arr); 
        for(int i = 0; i<no_of_queries; i++)
        {
            int code; 
            code = in.nextInt(); 
            if(code == 0)
            {
                myObj.printArr(); 
            } 
            else if(code == 1)
            {
                int first,second; 
                first = in.nextInt();
                second = in.nextInt(); 
                myObj.replace(first,second);
            } 
            else if(code == 2)
            {
                int target = in.nextInt(); 
                System.out.println(myObj.sumExists(target)); 
            } 
            else
            {
                System.out.print(""); 
            }
        }
    }
}
