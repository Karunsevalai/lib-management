package UserInterface;
import java.util.Scanner;

import LMSDb.Member;
import Operations.MemberOperation;

public class MemberUI extends UI{

    Scanner sc=new Scanner(System.in);
    @Override
    public void myRole() {
         System.out.println("Welcome Member!");
    }
    
    public void myMemberUI(MemberOperation mo,Member cu){
        lMyloop:while(true){
            System.out.println("Display Books -m");
            System.out.println("Get Book -g  Return Book -h  myLotBooks -p");
            System.out.println("Subscription -s");
            System.out.println("exit -e");
            char cl=sc.next().charAt(0);
            switch (cl) {

             case 'm':
                 mo.viewBooks();
                 break;
 
             case 'g':
                 System.out.println("Enter Book Id:");
                 int gbid=sc.nextInt();
                 mo.getBook(gbid, cu);
                 break;
             case 'h':
                 System.out.println("Enter Book Id:");
                 int rbid=sc.nextInt();
                 mo.returnBook(rbid, cu);
                 break;
             case 'p':
                  cu.myLotBooks();
                  break;
             case 'e':
                 
                 break lMyloop;
             case 's':
                 System.out.println("My Subscription Status: ");
                 if(cu.getSubscription()==null){
                 System.out.println(cu.getId()+" "+cu.getName()+" No Subscription Found");
                 }
                 else{
                 System.out.println(cu.getId()+" "+cu.getName()+" Subscription validity From:"+cu.getSubscription()+" to "+cu.getSubscription().plusMonths(6));
                    
                 }
             default:
                 System.out.println("Enter Correct Choice!");
                 break;
            }
           }
    }

}
