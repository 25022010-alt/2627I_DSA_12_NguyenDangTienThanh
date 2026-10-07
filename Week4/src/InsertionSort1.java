import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    public static void printArray(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + (i == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int val = arr.get(n - 1);
        int i = n - 2;
        while (i >= 0 && arr.get(i) > val) {
            arr.set(i + 1, arr.get(i));
            printArray(arr);
            i--;
        }
        arr.set(i + 1, val);
        printArray(arr);
    }
}


public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result1.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
