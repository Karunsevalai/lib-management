package LMSDb;
public class Book {
    private int id;
    private String bookName;
    private boolean available;

    private int  pYear;
    private String author;

   Book(int id,String bookName,String author,int year){
          this.id=id;
          this.bookName=bookName;
          this.author=author;
          this.available=true;
          this.pYear=year;
   }

   public int getId() {
    return id;
    }
    public String getBookName() {
        return bookName;
    }

    public boolean isAvailable() {
        return available;
    }
    public String getAuthor() {
        return author;
    }
    public int getpYear() {
        return pYear;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
