package com.core.springproxy.trace.callback;

public interface TraceCallback<T> {
    T call();
}
