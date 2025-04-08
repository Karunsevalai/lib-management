package UserInterface;

import java.time.LocalDate;
import java.util.Scanner;

import LMSDb.Librarian;
import Operations.LibrarianOperation;

public class LibrarianUI extends UI{

    Scanner sc=new Scanner(System.in);
    @Override
    public void myRole() {
        System.out.println("Welcome Librarian!");
    }
    public void myLibrarianUI(LibrarianOperation lo,Librarian cu){
        lMyloop:while(true){
            System.out.println("Add Member -a       Add Book -b");
            System.out.println("Remove Member -r    Remove Book -n");
            System.out.println("Display Members -d  Display Books -m");
            System.out.println("Get Book -g       Return Book -h  myLotBooks -p");
            System.out.println("addMemberSubs -v   Subscriptiion -s");

            System.out.println("exit -e");
            char cl=sc.next().charAt(0);
            switch (cl) {
             case 'a':
                 lo.addMember();
                 break;
             case 'b':
                 lo.addBook();
                 break;
             case 'd':
                 lo.viewMembers();
                 break;
             case 'm':
                 lo.viewBooks();;
                 break;

             case 'n':
                 System.out.println("Enter Book Id:");
                 int bid=sc.nextInt();
                 lo.removeBook(bid);
                 break;

             case 'r':
                 System.out.println("Enter Member Id:");
                 int mid=sc.nextInt();
                 lo.removeMember(mid);
                 break;
 
             case 'g':
                 System.out.println("Enter Book Id:");
                 int gbid=sc.nextInt();
                 lo.getBook(gbid, cu);
                 break;
             case 'h':
                 System.out.println("Enter Book Id:");
                 int rbid=sc.nextInt();
                 lo.returnBook(rbid, cu);
                 break;
             case 'p':
                  cu.myLotBooks();
                  break;
             case 'e':
                 
                 break lMyloop;
             case 'v':
                  System.out.println("Enter Member Id:");
                  int msid=sc.nextInt();
                  System.out.println("Enter Subscription Start Date (yyyy-mm-dd):");
                  String s11=sc.next();
                  LocalDate d11=LocalDate.now();
                  try {
                  LocalDate d22=LocalDate.parse(s11);
                  if((d22.isEqual(d11) || d22.isAfter(d11)) && d22.isBefore(d22.plusMonths(6))){
                        lo.UpdateMemberSubs(msid, d22);
                        break;
                  }
                  } catch (Exception e) {
                     System.out.println("Enter Correct Date!");
                  }
            case 's':
                  System.out.println("My Subscription Status: ");
                  if (cu.getSubscription()==null) {
                     System.out.println(cu.getId()+" "+cu.getName()+" No Subscription Found!");         
                  }
                  else{
                  System.out.println(cu.getId()+" "+cu.getName()+" Subscription validity From:"+cu.getSubscription()+" to "+cu.getSubscription().plusMonths(6));
                  }
                  System.out.println("Member Subscription Status: ");
                  lo.viewMembersSubscription();
             default:
                 System.out.println("Enter Correct Choice!");
                 break;
            }
           }
    }
    
}
