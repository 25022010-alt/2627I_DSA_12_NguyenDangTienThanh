 import java.io.*;
 import java.util.*;
 import java.util.stream.*;
 import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'insertionSort2' function below.
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
    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            int temp = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);
            printArray(arr);
        }
    }

}

public class InsertionSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
