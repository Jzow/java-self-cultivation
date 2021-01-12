package com.jameszow.factory;

/**
 * ClassName: Main
 * Description: TODD
 * Author: James Zow
 * Date: 2020/11/17 0017 21:19
 * Version:
 **/
public class Main {

    public static void main(String[] args) {
      //  sum();
      //  sum2();
        runExample();
    }

    public static void runExample() {
        BuilderFactory builder = new BuilderFactory.Builder("192.160.20.24", "root")
                .number(1)
                .price(5000.00)
                .Builder();
        System.out.println(builder);

        // 无法实例化 privateUtility a = new privateUtility();
        Enum<AbstractMethod.Type> a = AbstractMethod.Type.beef;
        System.out.println(a);

        // 避免创建不必要的对象

        NotCreateObject.isRomaNumeral("ssssss");
    }

    /**
     * 对比sum和sum2的速度
     * 优先使用long基本类型 而不是Long装箱类型
     * @return
     */
    public static long sum(){
        Long sum = 0L;
        for (long i=0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static long sum2(){
        long sum = 0L;
        for (long i=0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }
}
