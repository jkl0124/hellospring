package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("성공성공")
    void vip_sus()
    {
        Member member=new Member(1L,"김현수", Grade.VIP);
        int discountant = rateDiscountPolicy.discount(member,10000);
        Assertions.assertThat(discountant).isEqualTo(1000);
    }

    @Test
    @DisplayName("실패실패")
    void vip_fail()
    {
        Member member=new Member(1L,"김현수2", Grade.BASIC);
        int discountant = rateDiscountPolicy.discount(member,10000);
        Assertions.assertThat(discountant).isEqualTo(1000);
    }

}