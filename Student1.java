class Student
{
    int Rollno;
    String name;
    int age;
    char gender;
    Student()
    {
        Rollno = 100;
        name = "Ravi";
        age = 17;
        gender = 'M';
    }
    Student(Student s)
    {
        Rollno = s.Rollno;
        name = s.name;
        age = s.age;
        gender = s.gender;
    }
    void display()
    {
        System.out.println("Roll No: " = " + Rollno);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println();
    }
}   
public class ConstructorsEx
{
   public ststic void main(String args[])
   {
   Student s2 = new student();
   constructor
Student s1 = new student(101, "Mohith",20,'M');
Student s3 = new student (s2);
     s1.display();
     s2.display();
     s3.display();
    }
    }