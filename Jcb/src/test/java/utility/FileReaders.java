package utility;
import com.alibaba.fastjson2.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaders {

    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            char[] buf = new char[8192];
            int count;
            while ((count = reader.read(buf)) != -1) {
                sb.append(buf, 0, count);
            }
        }

        return sb.toString();
    }

    public static JSONObject readJson(String filePath) throws IOException {
        String jsonString = readFile(filePath);
        return JSONObject.parseObject(jsonString);
    }
}
