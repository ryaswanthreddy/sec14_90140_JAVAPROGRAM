public class FahrenheitToCelsius{
public static void main(String arg[])
{
 scanner sc = new scanner(System.in);
 System.out.print("Enter temperature in Fahrenheit:");
 double Fahrenheit = sc.nextDouble();
 double Celsius = {Fahrenheit - 32)*5/9;
 System.out.println("Temperature in Celsius:"+Celsius);
 sc.close();
  }
 }
 