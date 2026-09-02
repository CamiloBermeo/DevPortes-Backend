package com.devPortes.fields.model;

import java.util.List;

public class Field {

    private Long id;
    private String urlImg;
    private String name;
    private String capacity;
    private String sport;
    private String surface;
    private String description;
    private List<String> details;
    private String hourlyRate;
    private boolean state;

    public Field() {}

    public Field(Long id, String urlImg, String name, String capacity, String sport,String surface,
                 String description, List<String> details, String hourlyRate, boolean state) {
        this.id = id;
        this.urlImg = urlImg;
        this.name = name;
        this.capacity = capacity;
        this.sport = sport;
        this.surface = surface;
        this.description = description;
        this.details = details;
        this.hourlyRate = hourlyRate;
        this.state = state;
    }

    public static Field create (String urlImg, String name, String capacity, String sport, String surface,
                         String description, List<String> details, String hourlyRate, boolean state){
        return new Field( null ,urlImg,  name,  capacity, sport,surface,
                 description, details, hourlyRate, state);
    }
    public static Field reconstitute (Long id ,String urlImg, String name, String capacity, String sport,String surface,
                         String description, List<String> details, String hourlyRate,  boolean state){
        return new Field( id ,urlImg,  name,  capacity, sport,surface,
                description, details, hourlyRate, state);
    }

    public Long getId() {
        return id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getSport() {
        return sport;
    }

    public String getSurface() {
        return surface;
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
