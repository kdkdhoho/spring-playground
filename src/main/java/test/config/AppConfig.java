package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.discount.DiscountPolicy;
import test.discount.RateDiscountPolicy;

@Configuration
public class AppConfig {

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

    //    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    @Bean
//    public OrderService orderService() {
//        return new OrderService(memberRepository(), discountPolicy());
//    }
//
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
