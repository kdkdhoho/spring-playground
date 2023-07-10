package test.discount;

import test.member.Grade;
import test.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private static final double DISCOUNT_RATE = 0.1;

    @Override
    public int discount(Member member, int price) {
        if (member.grade() == Grade.VIP) {
            return (int) (price * DISCOUNT_RATE);
        }
        return 0;
    }
}
