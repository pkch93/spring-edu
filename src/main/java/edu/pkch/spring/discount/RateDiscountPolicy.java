package edu.pkch.spring.discount;

import edu.pkch.spring.member.Grade;
import edu.pkch.spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private static final int DISCOUNT_RATE = 20;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price / DISCOUNT_RATE * 100;
        }

        return 0;
    }
}
