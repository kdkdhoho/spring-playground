package test.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import test.member.Grade;
import test.member.Member;

@DisplayName("RateDiscountPolicy 은(는)")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class RateDiscountPolicyTest {

    private final RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void 상품_가격의_일정_비율을_할인한다() {
        // given
        Member member = new Member(1L, "name", Grade.VIP);
        int price = 10_000;

        // when
        int result = discountPolicy.discount(member, price);

        // then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    void 일반_회원은_할인하지_않는다() {
        // given
        Member member = new Member(1L, "name", Grade.BASIC);
        int price = 10_000;

        // when
        int result = discountPolicy.discount(member, price);

        // then
        assertThat(result).isEqualTo(0);
    }
}
