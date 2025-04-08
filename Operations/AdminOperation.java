package Operations;

import java.time.LocalDate;

public interface AdminOperation extends LibrarianOperation{
    void addLibrarian();
    void removeLibrarian(int id);
    void viewLibrarians();
    void viewLibrariansSubscriptions();
    void updateLibrarianSubs(int id,LocalDate d);
}
