package com.au.covidgame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static String get(String key) throws IOException {
        File propFilePath = new File("src/main/java/com/au/resources/config.properties");
        FileInputStream inputStream = new FileInputStream(propFilePath);

        Properties prop = new Properties();
        prop.load(inputStream);

        String value = (String) prop.get(key);
        return value;

    }
}
