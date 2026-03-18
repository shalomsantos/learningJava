package com.shalom.learning.util;

import java.util.HashMap;
import java.util.Map;

public class Helper
{
    public static Map<String, Object> bodyResponseConstruct(Object... args) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            map.put(args[i].toString(), args[i + 1]);
        }
        return map;
    }
}
