package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        Encoder encoder = Base64.getEncoder();
        if (agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            filename = "=?utf-8?B?" + Arrays.toString(encoder.encode(filename.getBytes(StandardCharsets.UTF_8))) + "?=";
        } else {
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        }
        return filename;
    }
}
