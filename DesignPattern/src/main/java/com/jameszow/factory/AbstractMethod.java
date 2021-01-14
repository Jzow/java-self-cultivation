/*
 * Copyright 2021 Apache All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
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
