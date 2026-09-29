public class Maxof3no{
public static void main(String arg[]){
int a=10;
int b=20;
int c=30;
int result = ((a>b)? (a>c)?  a:c:(b<c) ? b:c);
System.out.println("Max of 3 numbers is = "+result);
}
}