/**
 * package com.jameszow.visitor;
 *
 * 访问者模式：
 *
 * 封装一些作用于某种数据结构中的各个元素的操作，它可以在不改变数据结构的情况下来定义这些数据的新操作
 *
 * 基本原理是在被访问的类里面添加一个对外提供访问者的接口
 *
 * 使用场景：
 *
 * 需要对一个对象结构中的对象进行不同操作（这些操作彼此没有关系）
 *
 * example：
 *
 * 举例一个美食，上海人和四川人评价食物 用双分派，即首先在客户端程序中，将具体状态作为参数传递ShangHai中(第一次分派)
 * 然后ShangHai类调用作为参数的 "具体方法" 中方法getShangHaiResult, 同时将自己(this)作为参数传入，完成第二次的分派
 */
package com.jameszow.visitor;