//Given a list  of  strings, you need to find the longest prefix common in all the strings.
//
//To solve this question, you should use implement and use the class LongestCommmonPrefix. A special augment utility method has to be also implemented in order to modify the strings in the list in order to add some form of uniformity in them. This will help you to find the answer to the question in a more organized and easy manner. See the code template for more information.
//
//If there is no common prefix, print -.
//
//Input Format
//
//The first line of input in each testcase consists of a single integer , denoting the number of strings in the list .  lines follow after this, each containing a single string beloning to .
//
//Constraints
//
//0 <  <= 
//0 <  <= , where  belongs to  for all 1 <=  <= n
//Output Format
//
//For each testcase, output a single string which is the longest prefix common in all strings in .




import java.io.*;

class LongestCommonPrefix{
    int n;
    String[] arr = new String[n];
      /* Declare an instance variable to store the list of strings */
 
    LongestCommonPrefix(String listOfStrings){
       
    }
 
    public void augment(String[] listOfStrings){
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (listOfStrings[i].compareTo(listOfStrings[j])>0){
                    String temp = listOfStrings[i];
                    listOfStrings[i] = listOfStrings[j];
                    listOfStrings[j] = temp;
                }
            }
             
        }
        /*
           Implement the augment method to augment/modify a string in the list of strings in order to
           act as a utility method to solve the given question    
        */
    }
 
    public String longestPrefixString(String[] stringArray){
        String prefix = "";
        int end = stringArray.length - 1;
        for(int i=0; i<stringArray[0].length(); i++){
            if(stringArray[0].charAt(i) == stringArray[end].charAt(i)){
                prefix = prefix + stringArray[0].charAt(i);
            }
            else{
                break;
            }
        }
        /* Complete the method to find longest prefix in all strings of the list of strings */  
        return prefix;
    }
}

class LongestCommonPrefixMain {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LongestCommonPrefix obj = new LongestCommonPrefix("");
        obj.n = Integer.parseInt(br.readLine());
       
        int noOfStrings = obj.n;
        String[] stringArray = new String[noOfStrings];
       
        for(int i=0; i<noOfStrings; i++){
            stringArray[i] = br.readLine();
        }
       
        obj.augment(stringArray);
        String prefix = obj.longestPrefixString(stringArray);
       
        if(prefix == ""){
            System.out.println("-");
        }
        else{
            System.out.println(prefix);
        }
       
       
       
    }
}