package UserInterface;

import java.time.LocalDate;
import java.util.Scanner;
import LMSDb.Admin;
import Operations.AdminOperation;

public class AdminUI extends UI{

    Scanner sc=new Scanner(System.in);
    
    public void myRole() {
        System.out.println("Welcome Admin!");
    }
    public void myAdminUI(AdminOperation ao,Admin cu){
        lMyloop:while(true){
            System.out.println("Add Librarian -q        Add Member -a       Add Book -b");
            System.out.println("Remove Librarian -w     Remove Member -r    Remove Book -n");
            System.out.println("Display Librarians -t   Display Members -d  Display Books -m");
            System.out.println("Get Book -g       Return Book -h  myLotBooks -p");
            System.out.println("addMemberSubs -v   addLibrarianSubs -k");
            System.out.println("exit -e Subcriptions -s");
            char cl=sc.next().charAt(0);
            switch (cl) {
             case 'q':
                 ao.addLibrarian();
                 break;
             case 'a':
                 ao.addMember();
                 break;
             case 'b':
                 ao.addBook();
                 break;
             case 'd':
                 ao.viewMembers();
                 break;
             case 'm':
                 ao.viewBooks();;
                 break;
             case 't':
                 ao.viewLibrarians();
                 break;
             case 'w':
                 System.out.println("Enter Librarian Id:");
                 int lid=sc.nextInt();
                 ao.removeLibrarian(lid);
                 break;
             case 'n':
                 System.out.println("Enter Book Id:");
                 int bid=sc.nextInt();
                 ao.removeBook(bid);
                 break;

             case 'r':
                 System.out.println("Enter Member Id:");
                 int mid=sc.nextInt();
                 ao.removeMember(mid);
                 break;
 
             case 'g':
                 System.out.println("Enter Book Id:");
                 int gbid=sc.nextInt();
                 ao.getBook(gbid, cu);
                 break;
             case 'h':
                 System.out.println("Enter Book Id:");
                 int rbid=sc.nextInt();
                 ao.returnBook(rbid, cu);
                 break;
             case 'p':
                  cu.myLotBooks();
                  break;
             case 'e':
                 
                 break lMyloop;
             case 's':

                  System.out.println("My Subscription Status: ");
                  if(cu.getSubscription()==null){
                  System.out.println(cu.getId()+" "+cu.getName()+" No Subscription Found!");
                     
                  }
                  else{
                  System.out.println(cu.getId()+" "+cu.getName()+" Subscription validityFrom:"+cu.getSubscription()+" to "+cu.getSubscription().plusMonths(12));
                      
                  }
                  System.out.println("Librarian Subscription Status: ");
                  ao.viewLibrariansSubscriptions();
                  System.out.println("Member Subscription Status: ");
                  ao.viewMembersSubscription();
                  break;
              case 'v':
                  System.out.println("Enter Member Id:");
                  int msid=sc.nextInt();
                  System.out.println("Enter Subscription Start Date (yyyy-mm-dd):");
                  String s11=sc.next();
                  LocalDate d11=LocalDate.now();
                  try {
                  LocalDate d22=LocalDate.parse(s11);
                  if((d22.isEqual(d11) || d22.isAfter(d11)) && d22.isBefore(d22.plusMonths(6))){
                        ao.UpdateMemberSubs(msid, d22);
                        break;
                  }
                  } catch (Exception e) {
                     System.out.println("Enter Correct Date!");
                  }
                  
                  break;
              case 'k':
                  System.out.println("Enter Librarian Id:");
                  int lsid=sc.nextInt();
                  System.out.println("Enter Subscription Start Date (yyyy-mm-dd):");
                  String s1=sc.next();
                  LocalDate d1=LocalDate.now();
                  try {
                  LocalDate d2=LocalDate.parse(s1);
                  if((d2.isEqual(d1) || d2.isAfter(d1)) && d2.isBefore(d2.plusMonths(6))){
                        ao.updateLibrarianSubs(lsid,d2);
                        break;
                  }
                  } catch (Exception e) {
                     System.out.println("Enter Correct Date!");
                  }
                  break;
             default:
                 System.out.println("Enter Correct Choice!");
                 break;
            }
           }
    }
}
