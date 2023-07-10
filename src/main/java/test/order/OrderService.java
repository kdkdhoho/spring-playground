package test.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.discount.DiscountPolicy;
import test.member.Member;
import test.member.MemberRepository;

@Getter
@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
