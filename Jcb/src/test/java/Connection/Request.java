package Connection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.alibaba.fastjson2.JSONObject;

public abstract class Request {
    private static final String baseUrl;
    private static final HttpClient Client;
    private static final HttpRequest.Builder requestBuilder;

    static {
        baseUrl = Config.getEnvConfig().getString("baseUrl");
        Client = HttpClient.newHttpClient();
        requestBuilder = HttpRequest.newBuilder();
    }

    private static JSONObject callApi(HttpRequest request) throws Exception {
        HttpResponse<String> response = Client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("responseBody");
        System.out.println(responseBody);
        return JSONObject.parseObject(responseBody);
    }

    public static JSONObject Get(String api) throws Exception {
        System.out.printf("GET : %s\n", api);
        HttpRequest request = requestBuilder.uri(URI.create(baseUrl + api))
                .GET()
                .build();
        return callApi(request);
    }

    public static JSONObject Post(String api, String payload) throws Exception {
        System.out.printf("POST : %s\n", api);
        HttpRequest request = requestBuilder.uri(URI.create(baseUrl + api))
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();
        return callApi(request);
    }

    public static JSONObject Put(String api, String payload) throws Exception {
        System.out.printf("PUT : %s\n", api);
        HttpRequest request = requestBuilder.uri(URI.create(baseUrl + api))
                .PUT(HttpRequest.BodyPublishers.ofString(payload))
                .build();
        return callApi(request);
    }

    public static JSONObject Delete(String api) throws Exception {
        System.out.printf("DELETE : %s\n", api);
        HttpRequest request = requestBuilder.uri(URI.create(baseUrl + api))
                .DELETE()
                .build();
        return callApi(request);
    }

    public static void setHeaders(JSONObject jsonHeaders) {
        requestBuilder.headers(null);
        for (Map.Entry<String, Object> item : jsonHeaders.entrySet()) {
            String key = item.getKey();
            Object value = item.getValue();
            requestBuilder.header(key, (String) value);
        }
    }

    @Override
    public String toString() {
        try {
            return Get("/healthcheck").getString("status");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}