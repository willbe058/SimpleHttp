package com.me.xpf.lib.cache;

import android.support.v4.util.LruCache;

import com.me.xpf.lib.base.Response;


public class LruMemCache implements Cache<String, Response> {

    private LruCache<String, Response> mResponseCache;

    public LruMemCache() {
        // 计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // 取八分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 8;
        mResponseCache = new LruCache<String, Response>(cacheSize) {

            @Override
            protected int sizeOf(String key, Response response) {
                return response.rawData.length / 1024;
            }
        };

    }

    @Override
    public Response get(String key) {
        return mResponseCache.get(key);
    }

    @Override
    public void put(String key, Response value) {
        this.mResponseCache.put(key, value);
    }

    @Override
    public void remove(String key) {
        this.mResponseCache.remove(key);
    }
}
