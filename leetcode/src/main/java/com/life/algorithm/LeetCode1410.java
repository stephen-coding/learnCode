package com.life.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author T596
 * @date 2023/11/23
 */
public class LeetCode1410 {

    public static String entityParser(String text) {

        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&" );
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder stringBuilder = new StringBuilder(text);
        int flag = 0;
        int fromIndex = 0;
        while (flag != -1) {
            flag = stringBuilder.indexOf("&", fromIndex);
            if (flag != -1) {
                int indexOf = stringBuilder.indexOf(";", fromIndex + 1);
                if (indexOf == -1) {
                    break;
                }
                fromIndex = flag + 1;
                String key = stringBuilder.substring(flag, indexOf + 1);
                String value = map.get(key);
                if (value != null) {
                    stringBuilder.replace(flag, indexOf + 1, value);
                }

            }

        }


        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        String test = "and I quote: &quot;...&quot;";
        System.out.println(entityParser(test));
    }
}
