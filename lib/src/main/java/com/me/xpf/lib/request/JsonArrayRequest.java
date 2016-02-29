package com.me.xpf.lib.request;


import com.me.xpf.lib.base.Request;
import com.me.xpf.lib.base.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonArrayRequest extends Request<JSONArray> {

    public JsonArrayRequest(HttpMethod method, String url, RequestListener<JSONArray> requestListener) {
        super(method, url, requestListener);
    }

    @Override
    public JSONArray parseResponse(Response response) {
        String jsonString = new String(response.getRawData());
        try {
            return new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
