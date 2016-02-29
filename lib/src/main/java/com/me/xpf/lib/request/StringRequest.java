package com.me.xpf.lib.request;


import com.me.xpf.lib.base.Request;
import com.me.xpf.lib.base.Response;

public class StringRequest extends Request<String> {

    public StringRequest(HttpMethod method, String url, Request.RequestListener<String> listener) {
        super(method, url, listener);
    }

    @Override
    public String parseResponse(Response response) {
        return new String(response.getRawData());
    }

}
