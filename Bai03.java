import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack();
        Scanner sc =new Scanner(System.in);
        int q=sc.nextInt();
        for (int i=0;i<q;i++){
            int type =sc.nextInt();
            if (type==1){
                int x= sc.nextInt();
                stack1.push(x);
            }
            else{
                if (stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if(type==2){
                    stack2.pop();
                }
                else if (type==3){
                    System.out.println(stack2.peek());
                }
            }
        }    }
}