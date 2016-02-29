package com.me.xpf.lib.httpstacks;


import com.me.xpf.lib.base.Request;
import com.me.xpf.lib.base.Response;

public interface HttpStack {

    Response performRequest(Request<?> request);
}
