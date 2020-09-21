package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;


public class RequestFactory {
    static Map<String, String> urls = new HashMap<>();

    public RequestFactory() {
        urls.put("/joke", "http://rzhunemogu.ru/RandJSON.aspx?CType=1");
        urls.put("/aphorisms", "http://rzhunemogu.ru/RandJSON.aspx?CType=4");
        urls.put("/quote", "http://rzhunemogu.ru/RandJSON.aspx?CType=5");

    }


    public String getJoke(String id) {
        if (!urls.containsKey(id)) {
            id = "/joke";
        }
        String url = urls.get(id);
        try {


            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "Cp1251"));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            return jsonObject.get("content").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
