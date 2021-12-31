//HackerLand University has the following grading policy:
//
//Every student receives a  in the inclusive range from  to .
//Any  less than  is a failing grade.
//Sam is a professor at the university and likes to round each student's  according to these rules:
//
//If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
//If the value of  is less than , no rounding occurs as the result will still be a failing grade.
//Examples
//
// round to  (85 - 84 is less than 3)
// do not round (result is less than 40)
// do not round (60 - 57 is 3 or higher)
//Given the initial value of  for each of Sam's  students, write code to automate the rounding process.
//
//Function Description
//
//Complete the function gradingStudents in the editor below.
//
//gradingStudents has the following parameter(s):
//
//int grades[n]: the grades before rounding
//Returns
//
//int[n]: the grades after rounding as appropriate
//Input Format
//
//The first line contains a single integer, , the number of students.
//Each line  of the  subsequent lines contains a single integer, .



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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here 
        int[] edited_grade = new int[grades.size()];
        LinkedList<Integer> final_grades = new LinkedList<>(); 
        for(int i =0 ; i<grades.size();i++)
        {
            int a = grades.get(i);
            if(a%5 == 0)
            {
                edited_grade[i] = grades.get(i);
            }
            else
            {
                int next_multiple = ((grades.get(i)/5)+1)*5;
                if(next_multiple-grades.get(i) < 3)
                {
                    if(next_multiple >= 40)
                    {
                        edited_grade[i] = next_multiple;
                    } 
                    else
                    {
                        edited_grade[i] = grades.get(i);
                    }
                }
                else
                {
                    edited_grade[i] = grades.get(i);
                }
            }
        } 
        for(int i=0; i<edited_grade.length ; i++)
        {
            final_grades.add(edited_grade[i]);
        }
        
        return final_grades;

    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

