import java.util.Scanner;
public class Palindrome
{
public static void main(String[] args)
 {
        
 Scanner scanner = new Scanner(System.in);       
 System.out.print("Enter an integer to check: ");
 int originalNumber = scanner.nextInt();       
 int tempNumber = originalNumber;
 int reversedNumber = 0;
        
  while (tempNumber != 0)
{
   int remainder = tempNumber % 10; // Extract the last digit
   reversedNumber = (reversedNumber * 10) + remainder; // Append it to the reversed number
   tempNumber = tempNumber / 10; // Remove the last digit from the temp number
 }
        
  if (originalNumber == reversedNumber) 
{
  System.out.println(originalNumber + " is a palindrome number.");
} 
 else 
{
  System.out.println(originalNumber + " is NOT a palindrome number.");
}
        
   scanner.close();
  }
}