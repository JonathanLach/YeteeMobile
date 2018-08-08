package com.android.yetee.yeteemobile.util;

@FunctionalInterface
public interface AsyncCallbackOneParam<A> {
    void apply (A a);
}