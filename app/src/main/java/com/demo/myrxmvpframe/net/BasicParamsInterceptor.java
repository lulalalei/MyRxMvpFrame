package com.demo.myrxmvpframe.net;

import android.text.TextUtils;
import android.util.Log;

import com.demo.myrxmvpframe.bases.MyApplication;
import com.demo.myrxmvpframe.constants.CommonConstants;
import com.demo.myrxmvpframe.utils.MD5Utils;
import com.demo.myrxmvpframe.utils.SPUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;


/**
 * Created by zzr on 2017/9/4.
 */

public class BasicParamsInterceptor implements Interceptor {

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        HttpUrl url = request.url();
        String params = url.encodedQuery();
//        requestBuilder.addHeader("channelCode", CommonConstants.OSNAME);
//        requestBuilder.addHeader("signType", "MD5");
//        requestBuilder.addHeader("sign", "5be4eadb6a2d58e0449fc57868bbaefe");
//        requestBuilder.addHeader("timestamp", "20170706131313111");
//        requestBuilder.addHeader("format", "json");
//        requestBuilder.addHeader("charset", "UTF-8");
//        requestBuilder.addHeader("version", "1.0.0");

        JSONObject jsonObject = new JSONObject();
        if (request.body() instanceof FormBody) {
            FormBody oldFormBody = (FormBody) request.body();
            for (int i = 0; i < oldFormBody.size(); i++) {
                try {
                    if (TextUtils.equals("header", oldFormBody.name(i))) {
                        JSONObject headerJsonObj = new JSONObject(oldFormBody.value(i));
                        jsonObject.put(oldFormBody.name(i), headerJsonObj);
                    } else {
                        jsonObject.put(oldFormBody.name(i), oldFormBody.value(i));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                jsonObject = new JSONObject(bodyToString(request.body()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String sign = MD5Utils.MD5(jsonObject.toString() + GenApiHashUrl.md5_key);
        String sessionId = (String) SPUtils.get(MyApplication.getInstance(), "sessionId", "");
        JSONObject js = new JSONObject();
        try {
            js.put("input", jsonObject.toString());
            js.put("sign", sign);
            js.put("channelCode", CommonConstants.OSNAME);
            js.put("signType", "MD5");
            js.put("timestamp", "");
            js.put("format", "json");
            js.put("charset", "UTF-8");
            js.put("version", "1.0.0");
            js.put("sessionId", sessionId);
            js.put("method", params.substring(7, params.indexOf('&')));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, js.toString().getBytes());
        Log.i("OkHttp_body", js.toString());
        // RequestBody body = generateMultipartRequestBody(MEDIA_TYPE_JSON, treeMap);
        requestBuilder.method(request.method(), body);
        request = requestBuilder.build();
        Log.i("OkHttp", request.headers().toString());

        return chain.proceed(request);
    }

    /**
     * 生成类是表单的请求体
     */
    protected RequestBody generateMultipartRequestBody(MediaType type, Map<String, String> map) {
        StringBuilder builder = new StringBuilder();
        Iterator<String> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            String key = it2.next();
            builder.append(key);
            builder.append("=");
            builder.append(map.get(key));
            builder.append("&");
        }

        builder.deleteCharAt(builder.length() - 1);
        Log.d("info", builder.toString());
        RequestBody body = RequestBody.create(type, builder.toString().getBytes());

        return body;
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
