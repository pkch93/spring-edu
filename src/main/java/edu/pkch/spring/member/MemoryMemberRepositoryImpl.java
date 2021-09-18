package edu.pkch.spring.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepositoryImpl implements MemberRepository {
    private static Map<Long, Member> STORE = new HashMap<>();

    @Override
    public void save(Member member) {
        STORE.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return STORE.get(memberId);
    }
}
