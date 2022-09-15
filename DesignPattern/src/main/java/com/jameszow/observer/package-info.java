/**
 * package com.jameszow.observer;
 *
 * 观察者模式：
 *
 * 定义对象间一种一对多的依赖关系，使得每一个对象改变状态，就会通知依赖于它的对象并自动更新
 *
 * 使用场景：
 *
 * 关联行为场景，关联行为是可以拆分的，而不是组合关系
 * 事件多级触发
 * 垮系统的消息交换场景，比如消息队列的处理机制。
 *
 * 注意：
 * 由于Observable不能被序列化也不是线程安全的，所以用jdk9 就弃用了Observable方法
 */
package com.jameszow.observer;