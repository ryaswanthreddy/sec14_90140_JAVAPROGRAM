import java.util.Scanner;
 public class ArrayRead {
 public static void main(String args[]) {
 int[] arr = new int[5];
 Scanner scanner = new Scanner(System.in (http://System.in/)); 
System.out.println(" Enter the Array values : "); 
for (int i = 0; i < arr.length; i++) {
 arr[i] = scanner.nextInt(); 
}
 System.out.println("Array values are :"); 
for (int i = 0; i < arr.length; i++) 
{
 System.out.println(arr[i]);
 }
 scanner.close();
 }
 }