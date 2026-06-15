import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Student{
    String name;
    int age;
    int roll_no;
    String branch;
    int year;
    String sec;
    public void printdetails(){
        System.out.println(this.name);
         System.out.println(this.age);
          System.out.println(this.roll_no);
           System.out.println(this.branch);
            System.out.println(this.year);
             System.out.println(this.sec);

    }

}
class StudentManagementSystem{
    public static void loadstudent(ArrayList<Student> l) throws Exception{
            BufferedReader br= new BufferedReader(new FileReader("Student.txt"));
            String line;
            while((line=br.readLine())!=null){
                String data[]=line.split(",");
                Student s=new Student();
                s.name=data[0];
                s.age=Integer.parseInt(data[1]);
                s.roll_no=Integer.parseInt(data[2]);
                s.branch=data[3];
                s.year=Integer.parseInt(data[4]);
                s.sec=data[5];
                l.add(s);
               
            }
             br.close();
        }
     public static void savestudent(ArrayList<Student> l) throws Exception{
            BufferedWriter bw=new BufferedWriter(new FileWriter("Student.txt"));
            for(int i=0;i<l.size();i++){
                Student s=l.get(i);
                bw.write(
                    s.name+","+s.age+","+s.roll_no+","+s.branch+","+s.year+","+s.sec
                );
                bw.newLine();
            }
            bw.close();
            System.out.println("data saved successfully");
        }
        
    public static void main(String arg[]) throws Exception{
       
         Scanner sc=new Scanner(System.in);
        ArrayList<Student> l= new ArrayList<>();
        loadstudent(l);
        int choice;
        
        do{
         System.out.println("enter 1 for add student details");
         System.out.println("enter 2 for print all details");
        System.out.println("enter 3 for searching");
        System.out.println("enter 4 for deleting details");
        System.out.println("enter 5 for updating details");
        System.out.println("enter 6 to save files");
        System.out.println("enter 0 to exit");


         choice=sc.nextInt();
        if(choice==1){
         System.out.println("how many student do you want to enter");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
        Student s=new Student();
        sc.nextLine();
        System.out.println("enter name");
        s.name=sc.nextLine();
         System.out.println("enter age");
        s.age=sc.nextInt();
         System.out.println("enter roll no");
        s.roll_no=sc.nextInt();
        sc.nextLine();
         System.out.println("enter branch");
        s.branch=sc.nextLine();
         System.out.println("enter year");
        s.year=sc.nextInt();
         System.out.println("enter section");
        s.sec=sc.next();
        l.add(s);
        System.out.println("added successfully");
    } 
}
    
   else if(choice==2){
    if(l.isEmpty()){
        System.out.println("no record found");
    }
    else {

        for(int i=0;i<l.size();i++){
        Student s=l.get(i);
        s.printdetails();
    }
    }
    }

else if(choice==3){
    System.out.println("enter roll no for search");
    int r=sc.nextInt();
    boolean found=false;
    for(int i=0;i<l.size();i++){
        Student s=l.get(i);
        if(r==s.roll_no){
            s.printdetails();
            found=true;
            break;
        }
    }
    if(!found){
        System.out.println("not found");
    }
}
else if(choice==4){
    System.out.println("enter roll no to delete");
    int r=sc.nextInt();
    boolean found=false;
    for(int i=0;i<l.size();i++){
        Student s=l.get(i);
        if(r==s.roll_no){
            l.remove(i);
            found=true;
            break;
            
        } 
    }
     if(!found){
         System.out.println("not found");
     }
     else {
        System.out.println("successfully deleted");
     }
    }

    else if(choice==5){
          System.out.println("enter roll no to update");
          int r=sc.nextInt();
          boolean found=false;
          for(int i=0;i<l.size();i++){
            Student s=l.get(i);
            if(r==s.roll_no){
                sc.nextLine();
                System.out.println("enter new name");
                String newname=sc.nextLine();
                s.name=newname;
                 System.out.println("enter new age");
                 int newage=sc.nextInt();
                s.age=newage;
                 System.out.println("enter new year");
                 int newyear=sc.nextInt();
                s.year=newyear;
                s.printdetails();
                found=true;
                break;
            }
          }
          if(!found){
            System.out.println("not found");
          }
          else {
            System.out.println("successfully updated");
          }
        }
        else if(choice==6){
            savestudent(l);
        }
        
    
    else {
        System.out.println("invalid choice");
    }
}while(choice!=0);
        System.out.println("stop");
    

        }


}

