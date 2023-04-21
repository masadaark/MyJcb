package Connection;
import com.alibaba.fastjson2.JSONObject;
import utility.FileReaders;
import java.io.IOException;
public class Config {
    private static JSONObject envConfig ;
    private static String envName ;
    static {
        try {
            envName = System.getProperty("envConfig");
            envConfig = FileReaders.readJson("src/test/ConfigEnv.json").getJSONObject("envName");
        } catch (IOException e) {
            envName = null;
            envConfig = null;
        }
    }

    public static JSONObject getEnvConfig() {
        return envConfig;
    }

    public static String getEnvName() {
        return envName;
    }

    public static JSONObject toJSONobject(){
        JSONObject resultJSONObject = new JSONObject();
        resultJSONObject.put("envName", envName);
        resultJSONObject.put("envConfig", envConfig);
        return resultJSONObject;
    }
}