package LMSDb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Operations.*;
public class LibraryManagementDb implements AdminOperation{

       private Scanner sc=new Scanner(System.in);
       private ArrayList<Admin> adminData =new ArrayList<>();
       private ArrayList<Librarian> librarianData =new ArrayList<>();
       private ArrayList<Member> memberData=new ArrayList<>();
       private ArrayList<Book> bookData=new ArrayList<>(); 
       private int lId=0;
       private int mId=0;
       private int bId=0;

       public void addAdmin(){
              adminData.add(new Admin(1,"admin","1234"));
       }
       
       public Admin AdminLogin(int id,String password){
              for(Admin a:adminData){
                     if(a.getId()==id && a.getPassword().equals(password)){
                            return a;
                     }
              }
              return null;
       }

       public Librarian LibrarianLogin(int id,String password){
              for(Librarian l:librarianData){
                     if(l.getId()==id && l.getPassword().equals(password)){
                            return l;
                     }
              }
              return null;
       }

       public Member MemberLogin(int id,String password){
              for(Member m:memberData){
                     if(m.getId()==id && m.getPassword().equals(password)){
                            return m;
                     }
              }
              return null;
       }


       @Override
       public void addLibrarian() {
              System.out.println("Enter Librarian Name:");
              String lName=sc.next();
              System.out.println("Enter Librarian Password:");
              String lPass=sc.next();
              librarianData.add(new Librarian(++lId, lName, lPass));
       }
       @Override
       public void removeLibrarian(int id) {
              for(Librarian l:librarianData){
                     if(l.getId()==id){
                            librarianData.remove(l);
                            System.out.println("Removed Successfully!");
                            return;
                     }
              }
              System.out.println("Id not found!");
       }
       @Override
       public void viewLibrarians() {
              for(Librarian l:librarianData){
                     System.out.println(l.getId()+" "+l.getName());
              }
       }
       @Override
       public void addMember() {
              System.out.println("Enter Member Name:");
              String mName=sc.next();
              System.out.println("Enter Member Password:");
              String mPass=sc.next();
              memberData.add(new Member(++mId, mName, mPass));
       }
       @Override
       public void removeMember(int id) {
              for(Member m:memberData){
                     if(m.getId()==id){
                            memberData.remove(m);
                            System.out.println("Removed Successfully!");
                            return;
                     }
              }
              System.out.println("Id not found!");
       }
       @Override
       public void viewMembers() {
              for(Member m:memberData){
                     System.out.println(m.getId()+" "+m.getName());
              }
       }
       @Override
       public void addBook() {
              System.out.println("Enter Book Name:");
              String bName=sc.next();
              System.out.println("Enter Author Name:");
              String bAuthor=sc.next();
              System.out.println("Enter Publition Year:");
              int year=sc.nextInt();
              bookData.add(new Book(++bId, bName, bAuthor, year));

       }
       @Override
       public void removeBook(int id) {
              for(Book b:bookData){
                     if(b.getId()==id){
                            bookData.remove(b);
                            System.out.println("Removed Successfully!");
                            return;
                     }
              }
              System.out.println("Id not found!");
       }
       @Override
       public void viewBooks() {
              for(Book b:bookData){
                     System.out.println(b.getId()+" "+b.getBookName()+" "+b.isAvailable());
              }
       }
       @Override
       public void getBook(int id,User u) {
              for(Book b:bookData){
                     if(b.getId()==id){
                            if(b.isAvailable()){
                               if(u.l<4){
                                 u.myLot[u.l++]=id;
                                 b.setAvailable(false);
                                 System.out.println("Book Taken Success!");
                                 return;
                               }
                               else{
                                   System.out.println("Your Lot Is Full!");
                                   return;
                               }
                            }
                            else{
                                   System.out.println("Currently not Available!");
                                   return;
                            }
                     }

                 }
                 System.out.println("Enter Correct Id!");
       }
       @Override
       public void returnBook(int id,User u) {
              for(Book b:bookData){
                     if(b.getId()==id){
                            if(!b.isAvailable()){
                                for(int j=0;j<u.l;j++){
                                   if(u.myLot[j]==id){
                                          for(int k=j;k<u.l-1;k++){
                                            u.myLot[k]=u.myLot[k+1];
                                          }
                                          u.l--;
                                          b.setAvailable(true);
                                          System.out.println("Book Successfully returned!");
                                          return;
                                   }
                                }
                                System.out.println("Your have no books to return!");
                                return;
                            }
                            else{

                                   System.out.println("The Book was already Returned!");
                                   return;
                            }
                     }
                 }
                 System.out.println("Enter Correct Book Id!");
       }

       @Override
       public void viewLibrariansSubscriptions() {
              for(Librarian l:librarianData){
                     if(l.getSubscription()==null){
                     System.out.println(l.getId()+" "+l.getName()+" No Subscription Found!");

                     }
                     else{
                     System.out.println(l.getId()+" "+l.getName()+" Subscription validity From:"+l.getSubscription()+" to "+l.getSubscription().plusMonths(6));
                        
                     }
              }
       }

       @Override
       public void viewMembersSubscription() {
              for(Member m:memberData){
                     if(m.getSubscription()==null){
                     System.out.println(m.getId()+" "+m.getName()+" "+"No Subscription Found!");
                     }
                     else{
                     System.out.println(m.getId()+" "+m.getName()+" Subscription validity:"+m.getSubscription()+" to "+m.getSubscription().plusMonths(3));
                     }
              }
       }

       @Override
       public void updateLibrarianSubs(int id,LocalDate d) {
              for(Librarian l:librarianData){
                     if(l.getId()==id){
                            l.setSubscriptiion(d);
                            System.out.println("Update Successfully!");
                            return;
                     }
              }
              System.out.println("Id not found!");
       }

       @Override
       public void UpdateMemberSubs(int id,LocalDate d) {
              for(Member m:memberData){
                     if(m.getId()==id){
                            m.setSubscriptiion(d);
                            System.out.println("Update Successfully!");
                            return;
                     }
              }
              System.out.println("Id not found!");
       }
   
}
