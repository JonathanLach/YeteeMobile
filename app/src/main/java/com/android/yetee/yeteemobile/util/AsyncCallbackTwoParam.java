package com.android.yetee.yeteemobile.util;

@FunctionalInterface
public interface AsyncCallbackTwoParam <A, B> {
    void apply (A a, B b);
}
