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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    /*- Cách 1: Sử dụng bảng băm (Hash Tables) để đếm và tìm; sau đó sắp xếp để in ra.
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    Map<Integer, Integer> freq = new HashMap<>();
        for (int x : brr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : arr) {
            freq.put(x, freq.get(x) - 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
        }
     */
    /*Cách 2: Chỉ sử dụng sắp xếp (Sorting) khi tìm và in ra
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> sortedA = new ArrayList<>(arr);
        List<Integer> sortedB = new ArrayList<>(brr);
        Collections.sort(sortedA);
        Collections.sort(sortedB);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = sortedA.size(), m = sortedB.size();

        while (j < m) {

            if (i < n && sortedA.get(i).equals(sortedB.get(j))) {
                i++;
                j++;
            } else {
                int val = sortedB.get(j);
                if (result.isEmpty() || result.get(result.size() - 1) != val) {
                    result.add(val);
                }
                j++;
            }
        }

        return result;
    }
*/
//Cách 3: Sử dụng cách làm trong bài Sắp xếp đếm (Counting Sort)
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        int minVal = Collections.min(brr);
        int maxVal = Collections.max(brr);

        int range = maxVal - minVal + 1;
        int[] cnt = new int[range];
        for (int x : brr) {
            cnt[x - minVal]++;
        }
        for (int x : arr) {
            cnt[x - minVal]--;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            if (cnt[i] > 0) {
                result.add(i + minVal);
            }
        }

        return result;
    }

}

public class MisingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
