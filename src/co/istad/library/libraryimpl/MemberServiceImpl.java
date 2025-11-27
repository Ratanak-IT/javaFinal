package co.istad.library.libraryimpl;

import co.istad.library.database.LibraryDatabase;
import co.istad.library.model.Member;
import co.istad.library.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final LibraryDatabase db;

    public MemberServiceImpl(LibraryDatabase db) { this.db = db; }

    @Override
    public void addMember(Member member) { db.addMember(member); }

    @Override
    public void updateMember(Member member) {
        List<Member> members = db.getMembers();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == member.getId()) {
                members.set(i, member);
                return;
            }
        }
    }

    @Override
    public void deleteMember(int id) { db.getMembers().removeIf(m -> m.getId() == id); }

    @Override
    public List<Member> findAll() { return db.getMembers(); }

    @Override
    public Member getById(int id) {
        return db.getMembers().stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }
}
