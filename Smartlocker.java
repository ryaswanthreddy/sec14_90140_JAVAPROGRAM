import java.util.*;
 
public class Smartlocker              

{
 
public static void main(String args[])
{

      Scanner sc= new Scanner (System.in);
      char size = sc.nextChar();
      if (size==small){
System.out.print("Small locker"); 
}
else if (size==medium) 
{  System.out.print("Medium locker");

}


else System.out.print("Large locker");



 sc.close();
}
     }



