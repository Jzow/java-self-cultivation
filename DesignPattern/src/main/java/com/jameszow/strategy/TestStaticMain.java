package com.jameszow.strategy;

/**
 * 静态测试方法
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class TestStaticMain {

    public static void main(String[] args) {

        MemberStrategy primaryMember = new PrimaryMemberStrategy();
        MemberStrategy advanceMember = new AdvanceMemberStrategy();
        MemberStrategy diamondMemberStrategy = new DiamondMemberStrategy();

        // 用户选择不同策略
        MemberContext primaryContext = new MemberContext(primaryMember);
        MemberContext advanceContext = new MemberContext(advanceMember);
        MemberContext diamondContext = new MemberContext(diamondMemberStrategy);

        System.out.println("普通会员价格：" + primaryContext.calculationPrice(576, 1));
        System.out.println("高级会员价格：" + advanceContext.calculationPrice(576, 1));
        System.out.println("钻石会员价格：" + diamondContext.calculationPrice(576, 1));
    }
}
