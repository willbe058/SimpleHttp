package com.me.xpf.lib.core;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;


import com.me.xpf.lib.base.Request;
import com.me.xpf.lib.base.Response;

import java.util.concurrent.Executor;

class ResponseDelivery implements Executor {

    /**
     * 主线程的handler
     */
    Handler mResponseHandler = new Handler(Looper.getMainLooper());

    /**
     * 处理请求结果,将其执行在UI线程
     *
     * @param request
     * @param response
     */
    public void deliveryResponse(final Request<?> request, final Response response) {
        Runnable respRunnable = new Runnable() {

            @Override
            public void run() {
                request.deliveryResponse(response);
            }
        };

        execute(respRunnable);
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mResponseHandler.post(command);
    }

}