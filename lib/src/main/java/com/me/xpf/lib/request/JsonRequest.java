package com.me.xpf.lib.request;


import com.me.xpf.lib.base.Request;
import com.me.xpf.lib.base.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonRequest extends Request<JSONObject> {

    public JsonRequest(HttpMethod method, String url, RequestListener<JSONObject> requestListener) {
        super(method, url, requestListener);
    }

    @Override
    public JSONObject parseResponse(Response response) {
        String jsonString = new String(response.getRawData());
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
