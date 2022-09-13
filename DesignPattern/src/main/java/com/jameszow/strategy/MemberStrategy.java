package com.jameszow.strategy;

/**
 * 会员策略接口
 *
 * @author James Zow
 * @create 2022/9/14
 */
public interface MemberStrategy {

    double calcPrice(double price, int discount);
}
