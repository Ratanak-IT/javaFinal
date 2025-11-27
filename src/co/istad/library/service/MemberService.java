package co.istad.library.service;

import co.istad.library.model.Member;

import java.util.List;

public interface MemberService {
    void addMember(Member member);
    void updateMember(Member member);
    Boolean deleteMember(int id);
    List<Member> findAll();
    Member getById(int id);
}
