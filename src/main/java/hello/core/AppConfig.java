package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.discount.order.OrderService;
import hello.core.discount.order.OrderServiceImpl;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService()
    {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    public MemberRepository getMemberRepository() {
        System.out.println("call AppConfig.getMemberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService()
    {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }
    @Bean
    public DiscountPolicy getDiscountPolicy() {
        System.out.println("call AppConfig.getDiscountPolicy");
        return new FixDiscountPolicy();
    }

}
