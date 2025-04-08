package Operations;

import java.time.LocalDate;

public interface LibrarianOperation extends MemberOperation  {
    void addMember();
    void removeMember(int id);
    void viewMembers();
    void addBook();
    void removeBook(int id);
    void viewMembersSubscription();
    void UpdateMemberSubs(int id,LocalDate d);
}
