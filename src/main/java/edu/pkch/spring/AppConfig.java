package edu.pkch.spring;

import edu.pkch.spring.discount.FixDiscountPolicy;
import edu.pkch.spring.discount.RateDiscountPolicy;
import edu.pkch.spring.member.MemberService;
import edu.pkch.spring.member.MemberServiceImpl;
import edu.pkch.spring.member.MemoryMemberRepositoryImpl;
import edu.pkch.spring.order.OrderService;
import edu.pkch.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memoryMemberRepository(),
                fixDiscountPolicy()
        );
    }

    @Bean
    public MemoryMemberRepositoryImpl memoryMemberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    @Bean
    public FixDiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public RateDiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
