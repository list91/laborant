package com.example.laborant;

public class Row {
    public String name;
    public String section;
    public String quantity;
    public String type;
    public String reference;
    public String time;
    public String repair;
    public String image;
    Row(String name,
        String section,
        String quantity,
        String type,
        String reference,
        String time,
        String repair,
        String image){
        this.name = name;
        this.section = section;
        this.quantity = quantity;
        this.type = type;
        this.reference = reference;
        this.time = time;
        this.repair = repair;
        this.image = image;
    }
}
