import java.util.*;
public class Armstrongnumber
{
public static void main(String arg[])
{
int no,temp,x,rev=0;
Scanner sc = new Scanner(System.in);
System.out.println("pls enter any number");
no=sc.nextInt();
temp=no;
while(no>0)
{
	x=no%10;
	rev=rev+(x*x*x);
	no=no/10;
}
if(rev==temp)
System.out.println("the enterd number "+temp+" is armstrong");
else
System.out.println("the entered number "+temp+" is not armstrong");
}
}
 