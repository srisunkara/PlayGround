package com.srisun.pg.utils;

import tech.tablesaw.api.Table;

public class JSONTableHandler {
    public static void main(String[] args) {

        Table table = Table.read().file("/Users/srini/Documents/Workspaces/Java_Projects/PlayGround/src/main/resources/sample.json");

        // Access specific column
        String name = (String) table.column("name").get(0);
        System.out.println(name);
        System.out.println(table.column("location.city").getUnformattedString(1));

        // Filter and select data
//        Table filteredTable = table.where(table.column("age").get(30));

        // Perform aggregations
//        int total = table.column("price").sum();



    }
}
