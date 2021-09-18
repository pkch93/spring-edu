package edu.pkch.spring.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
