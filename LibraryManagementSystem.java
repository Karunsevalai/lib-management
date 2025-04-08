import java.util.Scanner;

import LMSDb.Admin;
import LMSDb.Librarian;
import LMSDb.Member;
import LMSDb.LibraryManagementDb;
import UserInterface.*;
import Operations.*;
class LibraryManagementSystem{

    Scanner sc=new Scanner(System.in);
    LibraryManagementDb ldb=new LibraryManagementDb();
    AdminUI ua=new AdminUI();
    LibrarianUI ul=new LibrarianUI();
    MemberUI um=new MemberUI();
     AdminOperation ao=ldb;
     LibrarianOperation lo=ldb;
     MemberOperation mo=ldb;
  



     public void LibraryManagement(){
        ldb.addAdmin();
        
        myLoop:while(true){
            System.out.println("Enter the Choice!");
            System.out.println("Admin Login -a");
            System.out.println("Librarian Login -l");
            System.out.println("Member Login -m");
            System.out.println("exit -e");
            
            
            char c=sc.next().charAt(0);
    
            switch (c) {
                case 'a':
                    System.out.println("Enter admin Id:");
                
                    int aId=sc.nextInt();
                    System.out.println("Enter admin PassWord:");
                    String aPassword=sc.next();
                    Admin ta=ldb.AdminLogin(aId, aPassword);
                    if(ta !=null){
                        ua.myRole();
                        ua.myAdminUI(ao,ta);
                    }
                    else{
                        System.out.println("Enter Correct Admin Id or Password!");
                    }

                    break;
                case 'l':
                    System.out.println("Enter Librarian Id:");
                    int lId=sc.nextInt();
                    System.out.println("Enter Librarian PassWord:");
                    String lPassword=sc.next();
                    Librarian tl=ldb.LibrarianLogin(lId, lPassword);
                    if(tl != null){
                        ul.myRole();
                        ul.myLibrarianUI(lo, tl);
                    }
                    else{
                        System.out.println("Enter Correct Librarian Id  or Password!");
                    }
                    break;
                case 'm':
                    System.out.println("Enter Member Id:");
                    int mId=sc.nextInt();
                    System.out.println("Enter Member PassWord:");
                    String mPassword=sc.next();
                    Member tm=ldb.MemberLogin(mId, mPassword);
                    if(tm != null){
                        um.myRole();
                        um.myMemberUI(mo, tm);
                    }
                    else{
                        System.out.println("Enter Member Id or Password!");
                    }
                    break;
                case 'e':
                    break myLoop;
                default:
                    System.out.println("Enter Correct Choice!");
                    break;
            }
        }

    }

    public static void main(String args[]){
        LibraryManagementSystem lms=new LibraryManagementSystem();
        lms.LibraryManagement();;
    }


}