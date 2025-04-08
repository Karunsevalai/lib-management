package LMSDb;


import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String password;
    int[] myLot=new int[5];
    int l=0;
    private LocalDate Subscription;




public LocalDate getSubscription() {
      return Subscription;
    }


    public void setSubscriptiion(LocalDate subscription) {
      Subscription = subscription;
    }


User(int id,String name,String password){
       this.id =id;
       this.name=name;
       this.password=password;
       //this.d=LocalDate.now();
 }


 public int getId() {
    return id;
  }
  public String getPassword() {
    return password;
  }
  public String getName() {
    return name;
}
   public void myLotBooks(){
    if(l==0){
      System.out.println("Your Lot is Empty!");
    }
    else{
      for(int j=0;j<l;j++){
     System.out.print(myLot[j]+" ");
       
      }
      System.out.println();
    }
   }

}
