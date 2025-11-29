package co.istad.library.service;

import co.istad.library.model.Member;

import java.util.List;

public interface MemberService {
    void addMember(Member member);
    void updateMember(Member member);
<<<<<<< HEAD
    void deleteMember(int id);
=======
    Boolean deleteMember(int id);
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    List<Member> findAll();
    Member getById(int id);
}
