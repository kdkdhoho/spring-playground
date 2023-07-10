package test.discount;

import org.springframework.stereotype.Component;
import test.member.Member;

@Component
public interface DiscountPolicy {

    int discount(Member member, int price);
}
