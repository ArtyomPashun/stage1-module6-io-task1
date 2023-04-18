package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder strBuilder = new StringBuilder();
        Profile profile = new Profile();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                strBuilder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultStr = strBuilder.toString();
        String[] strArray = resultStr.split("\r\n");
        profile.setName(strArray[0].replace("Name: ", ""));
        profile.setAge(Integer.valueOf(strArray[1].replace("Age: ", "")));
        profile.setEmail(strArray[2].replace("Email: ", ""));
        profile.setPhone(Long.valueOf(strArray[3].replace("Phone: ", "")));

        return profile;
    }
}
