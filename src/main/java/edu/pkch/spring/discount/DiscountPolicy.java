package edu.pkch.spring.discount;

import edu.pkch.spring.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
