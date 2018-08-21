package com.android.yetee.yeteemobile.util;

import java.io.IOException;

@FunctionalInterface
public interface AsyncCallbackOneParam<A> {
    void apply (A a) throws IOException;
}