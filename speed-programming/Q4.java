
package javaapplication13;
public class JavaApplication13 {

   
    public static void main(String[] args) {
       
        
        JavaApplication13 obj=new JavaApplication13();
        obj.print("Shahzaib Ali");
        obj.print(19);
        obj.print("Abdul Hameed","Kfueit");
                
    }
    
    
    public void print(String Name)
    {
        System.out.println("My Name "+Name);
        
        
    }
    public void print(int Age)
    {
        System.out.println("My Age "+Age);
        
        
    }
     public void print(String  FatherName,String UniName)
    {
        System.out.println("My Uni "+UniName);
         System.out.println("My FatherName "+FatherName);
        
        
    }
}
