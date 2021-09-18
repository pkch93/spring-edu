package edu.pkch.spring.order;

import edu.pkch.spring.discount.DiscountPolicy;
import edu.pkch.spring.discount.FixDiscountPolicy;
import edu.pkch.spring.member.Member;
import edu.pkch.spring.member.MemberRepository;
import edu.pkch.spring.member.MemoryMemberRepositoryImpl;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepositoryImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order create(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
