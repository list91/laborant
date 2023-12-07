package com.example.laborant;
import com.google.gson.JsonArray;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private final String DOMAIN = "http://rixem16044.temp.swtest.ru";
    public JsonArray jsonTable = null;
    Table(String name){
        this.name = name;
        initTable();
    }
    public List<Row> getRows(){
        List<Row> rows = new ArrayList<>();
        for (JsonElement jsonElem: jsonTable){
            String name = jsonElem.getAsJsonObject().get("name").toString();
            String section = jsonElem.getAsJsonObject().get("section").toString();
            String quantity = jsonElem.getAsJsonObject().get("quantity").toString();
            String type = jsonElem.getAsJsonObject().get("type").toString();
            String reference = jsonElem.getAsJsonObject().get("reference").toString();
            String time = jsonElem.getAsJsonObject().get("time").toString();
            String repair = jsonElem.getAsJsonObject().get("repair").toString();
            String image = jsonElem.getAsJsonObject().get("image").toString();
            Row row = new Row(name, section, quantity, type, reference, time, repair, image);
            rows.add(row);
        }
        return rows;
    }
    public void initTable() {
        String domain = DOMAIN;
        String loginUrl = domain + "/login.php";
        String secureUrl = domain + "/index.php?table=" + name;

        try {
            Connection.Response loginResponse = Jsoup.connect(loginUrl)
                    .data("login", "admin", "password", "password")
                    .method(Connection.Method.POST)
                    .execute();

            if (loginResponse.statusCode() == 200
                    && loginResponse.url().toString().equals(domain + "/index.php")) {

                Connection.Response secureResponse = Jsoup.connect(secureUrl)
                        .cookies(loginResponse.cookies())
                        .ignoreContentType(true)
                        .execute();

                String jsonResponse = secureResponse.body();

                Gson gson = new Gson();

                jsonTable = gson.fromJson(jsonResponse, JsonArray.class);

            } else {
                jsonTable = null;
            }
        } catch (Exception e) {
            jsonTable = null;
        }
    }

}
