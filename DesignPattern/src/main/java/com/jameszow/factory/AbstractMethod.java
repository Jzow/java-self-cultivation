package com.jameszow.factory;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * ClassName: abstractMethod
 * Description: TODD
 * Author: James Zow
 * Date: 2020/11/17 0017 22:06
 * Version:
 **/
public abstract class AbstractMethod {

    public enum Type {
        fruit,
        beef,
        egg
    }

    final Set<Type> types;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Type> types = EnumSet.noneOf(Type.class);
        public T addTypes (Type type){
            types.add(Objects.requireNonNull(type));
            return self();
        }

        protected abstract T self();

        abstract AbstractMethod build();
    }

    AbstractMethod(Builder<?> builder) {
        types = builder.types.clone();
    }
}
