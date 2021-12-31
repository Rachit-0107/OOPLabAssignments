//Function description
//
//Complete the  function in the editor below.
//
//diagonalDifference takes the following parameter:
//
//int arr[n][m]: an array of integers
//Return
//
//int: the absolute diagonal difference
//Input Format
//
//The first line contains a single integer, , the number of rows and columns in the square matrix .
//Each of the next  lines describes a row, , and consists of  space-separated integers .
//
//Constraints
//
//Output Format
//
//Return the absolute difference between the sums of the matrix's two diagonals as a single integer.



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here 
        int primary_diagonal = 0 , secondary_diagonal = 0; 
        for(int i =0; i<arr.size() ; i++)
        {
            primary_diagonal+= arr.get(i).get(i); 
            secondary_diagonal+= arr.get(i).get(arr.size()-i-1);
        } 
        return Math.abs(primary_diagonal - secondary_diagonal);

    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
