package edu.pkch.spring.beanfind;

import edu.pkch.spring.AppConfig;
import edu.pkch.spring.discount.DiscountPolicy;
import edu.pkch.spring.member.MemberService;
import edu.pkch.spring.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println(memberService);
        assertThat(memberService)
                .isNotNull()
                .isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println(memberService);
        assertThat(memberService)
                .isNotNull()
                .isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 구현 타입으로 조회")
    void findBeanByImplementsType() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        System.out.println(memberService);
        assertThat(memberService)
                .isNotNull()
                .isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("존재하지 않는 빈 이름으로 조회")
    void findBeanByNotExistBeanName() {
        assertThatThrownBy(() -> ac.getBean("noExist", MemberService.class))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }

    @Test
    @DisplayName("같은 타입의 빈을 모두 조회한다.")
    void findAllBeanByType() {
        Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beans).hasSize(2)
                .containsKeys("fixDiscountPolicy", "rateDiscountPolicy");
    }
}
