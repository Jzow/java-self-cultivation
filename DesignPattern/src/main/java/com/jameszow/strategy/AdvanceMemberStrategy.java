package com.jameszow.strategy;

/**
 * 高级会员
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class AdvanceMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double price, int discount) {
        return (price * discount) - price * discount * 0.2;
    }
}
