package edu.pkch.spring.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
