package com.me.xpf.lib.core;


import com.me.xpf.lib.httpstacks.HttpStack;

public final class SimpleHttp {

    public static RequestQueue newRequestQueue() {
        return newRequestQueue(RequestQueue.DEFAULT_CORE_NUMS);
    }

    public static RequestQueue newRequestQueue(int coreNums) {
        return newRequestQueue(coreNums, null);
    }

    public static RequestQueue newRequestQueue(int coreNums, HttpStack httpStack) {
        RequestQueue queue = new RequestQueue(Math.max(0, coreNums), httpStack);
        queue.start();
        return queue;
    }
}
