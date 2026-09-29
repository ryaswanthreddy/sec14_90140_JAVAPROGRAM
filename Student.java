import java.util.Scanner;
class Student
{
  public static void main (String[] args)
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter Name : " );
String Name = sc.nextLine();

System.out.print("Enter Roll No. : " );
int Roll_No = sc.nextInt(); 

System.out.print("Enter Age : " );
int Age = sc.nextInt();

System.out.println("\n Marks  ");

System.out.print("Enter Sub1 Marks : " );
int Sub1 = sc.nextInt();

System.out.print("Enter Sub2 Marks : " );
int Sub2 = sc.nextInt();

System.out.print("Enter Sub3 Marks : " );
int Sub3 = sc.nextInt();

double percentage = (Sub1 + Sub2 + Sub3) / 3.0;

System.out.println("\n--- Student Details ---");
System.out.println("Name: " + Name);
System.out.println("Age: " + Age);
System.out.println("Roll_No : " + Roll_No);
System.out.println("Percentage : " + percentage + " % ");

 sc.close();
}
}