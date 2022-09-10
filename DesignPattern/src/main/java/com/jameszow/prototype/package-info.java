/**
 * package com.jameszow.prototype;
 *
 * 原型模式：
 *
 * 用原型模式创建这个对象的实体，并且通过浅拷贝创建新的对象
 * 原型模式实际上就是实现了Cloneable接口 重写了clone 方法
 *
 * 使用场景：
 *
 * 比如在for循环中大量创建这个对象的时候，原型模式的使用要比new对象的开销低许多，性能更优
 * 一个对象多个修改者的场景，一个对象创建后提供给其他对象访问，各个调用者都会修改这个对象值，可以用原型模式的浅拷贝给多个提供者使用。
 */
package com.jameszow.prototype;