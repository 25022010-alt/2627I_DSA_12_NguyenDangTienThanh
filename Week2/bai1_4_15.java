import java.util.Arrays;
import java.util.Scanner;
public class bai1_4_15 {
    /*   public static int twosum(int[] a){
            int count=0;
            int left=0;
            int right=a.length-1;
            while(left<right){
                int sum=a[left]+a[right];
                if (sum==0){
                    count++;
                    left++;
                    right--;
                }
                else if (sum<0){
                    left++;
                }
                else{
                    right--;
                }
                }
            }
            return count;
        }
    */
/*
Ý tưởng
tìm cac cặp thoả mãn a[left]+a[right]=-a[i]
 */
    public static int threeSum(int[] a){
        Arrays.sort(a);
        int count=0;
        int n=a.length;
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            int target=-a[i];
            while(left<right){
                int sum=a[left]+a[right];
                if (sum==target){
                    count++;
                    left++;
                    right--;
                }
                else if (sum>target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Số phần tử chuỗi");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Nhập chuỗi");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int count = threeSum(a);
        System.out.println("Số bộ thoả mãn "+count);
        sc.close();
    }
}
