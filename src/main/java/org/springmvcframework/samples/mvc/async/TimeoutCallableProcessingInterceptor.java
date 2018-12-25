package org.springmvcframework.samples.mvc.async;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

import java.util.concurrent.Callable;

public class TimeoutCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {

    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task){
        throw new IllegalStateException("[" + task.getClass().getName() + "] time out");
    }
}
