package com.core.springproxy.trace.template;

import com.core.springproxy.trace.TraceStatus;
import com.core.springproxy.trace.logTrace.LogTrace;

public abstract class AbstractTemplate<T>{

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String meassge){
        TraceStatus status = null;
        try {
            status = trace.begin(meassge);
            T result = call();
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status,e);
            throw e;
        }
    }

    public  abstract T call();
}
