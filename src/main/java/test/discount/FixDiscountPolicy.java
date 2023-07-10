package test.discount;

import test.member.Grade;
import test.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_PRICE = 1_000;

    @Override
    public int discount(Member member, int price) {
        if (member.grade() == Grade.VIP) {
            return DISCOUNT_PRICE;
        }
        return 0;
    }
}
