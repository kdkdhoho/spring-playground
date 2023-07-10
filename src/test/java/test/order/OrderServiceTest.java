package test.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.config.AppConfig;
import test.discount.DiscountPolicy;
import test.member.Grade;
import test.member.Member;
import test.member.MemberRepository;

@DisplayName("OrderService 은(는)")
@SuppressWarnings("NonAsciiCharacters")
//@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderServiceTest {

    private final AppConfig appConfig = new AppConfig();
    private final MemberRepository memberRepository = appConfig.memberRepository();
    private final DiscountPolicy discountPolicy = appConfig.discountPolicy();
    private final OrderService orderService = appConfig.orderService();

    @Test
    void 주문을_생성한다() {
        // given
        Member member = new Member(1L, "name", Grade.VIP);
        memberRepository.save(member);
        String itemName = "itemName";
        int itemPrice = 10_000;
        int expectDiscountPrice = discountPolicy.discount(member, itemPrice);
        Order expectOrder = new Order(member.id(), itemName, itemPrice, expectDiscountPrice);

        // when
        Order result = orderService.createOrder(member.id(), itemName, itemPrice);

        // then
        assertThat(result).usingRecursiveComparison()
                .isEqualTo(expectOrder);
    }

    @Test
    void 일반_회원은_할인_금액이_0원이다() {
        // given
        Member member = new Member(1L, "member", Grade.BASIC);
        memberRepository.save(member);
        String itemName = "itemName";
        int itemPrice = 10_000;
        int expectDiscountPrice = 0;
        Order expect = new Order(member.id(), itemName, itemPrice, expectDiscountPrice);

        // when
        Order result = orderService.createOrder(member.id(), itemName, itemPrice);

        // then
        assertThat(result).usingRecursiveComparison()
                .isEqualTo(expect);
    }
}
