package api;
import com.alibaba.fastjson2.JSONObject;
import java.io.IOException;

import static utility.FileReaders.readJson;

public abstract class ApiConfig {
    private static final JSONObject jsonApiConfig;

    static {
        try {
            jsonApiConfig = readJson("src/test/ApiBody.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static JSONObject getJsonApiConfig() {
        return jsonApiConfig;
    }
    public static String getApiBody(String apiPath){
        if(apiPath == null){
            throw new IllegalArgumentException("Invalid API path: " + apiPath);
        }
        return jsonApiConfig.getString(apiPath);
    }
}
