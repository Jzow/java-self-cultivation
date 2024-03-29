/**
 * package com.jameszow.adapter;
 *
 * 适配器模式：
 *
 * 将一个类的接口换成客户端所需要的另一种接口，使原本接口不匹配的两个类能够在一起工作
 *
 * 适配器模式主要有三种（类适配，对象适配，接口适配）
 *
 * 类适配：创建新的类，继承原的类，并实现新的接口。
 * 对象适配：创建新的类持有原来类的实例，并实现新的接口。
 * 接口适配：创建新的抽象类实现旧接口的方法。
 *
 * 使用场景：
 *
 * 如果需要修改一个线上的接口，可以使用适配器模式。比如系统扩展 需要创建使用一个新的类，但这个类又不符合系统接口
 */
package com.jameszow.adapter;