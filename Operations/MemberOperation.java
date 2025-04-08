package Operations;
import LMSDb.User;
public interface MemberOperation {
    void viewBooks();
    void getBook(int id,User u);
    void returnBook(int id,User U);
}
