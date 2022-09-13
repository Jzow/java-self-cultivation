package com.jameszow.strategy;

/**
 * 普通会员
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class PrimaryMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double price, int discount) {
        return (price * discount) - price * discount * 0.1;
    }
}
