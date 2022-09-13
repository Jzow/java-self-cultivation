package com.jameszow.strategy;

/**
 * 上下文类
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class MemberContext {

    private MemberStrategy memberStrategy;

    public MemberContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double calculationPrice(double goodsPrice, int discount) {
        return memberStrategy.calcPrice(goodsPrice, discount);
    }
}
