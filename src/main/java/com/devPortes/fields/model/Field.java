package com.devPortes.fields.model;

import java.util.List;

public class Field {

    private Long id;
    private String url_img;
    private String name;
    private String capacity;
    private String category;
    private String description;
    private List<String> details;
    private String hourlyRate;
    private boolean state;

    public Field() {}

    public Field(Long id, String url_img, String name, String capacity, String category,
                 String description, List<String> details, String hourlyRate, boolean state) {
        this.id = id;
        this.url_img = url_img;
        this.name = name;
        this.capacity = capacity;
        this.category = category;
        this.description = description;
        this.details = details;
        this.hourlyRate = hourlyRate;
        this.state = state;
    }

    public static Field create (String url_img, String name, String capacity, String category,
                         String description, List<String> details, String hourlyRate, boolean state){
        return new Field( null ,url_img,  name,  capacity, category,
                 description, details, hourlyRate, state);
    }
    public static Field reconstitute (Long id ,String url_img, String name, String capacity, String category,
                         String description, List<String> details, String hourlyRate,  boolean state){
        return new Field( id ,url_img,  name,  capacity, category,
                description, details, hourlyRate, state);
    }

    public Long getId() {
        return id;
    }

    public String getUrl_img() {
        return url_img;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDetails() {
        return details;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public boolean isState() {
        return state;
    }
}
