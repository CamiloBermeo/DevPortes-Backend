package com.devPortes.location.model;

public class Location {

    private Long id;
    private String name;
    private String headquarters;
    private String address;
    private String urlQrAddress;
    private String description;
    private boolean state;

    public Location() {
    }

    public Location(Long id, String name,String headquarters, String address, String urlQrAddress, String description, boolean state) {
        this.id = id;
        this.name = name;
        this.headquarters = headquarters;
        this.address = address;
        this.urlQrAddress = urlQrAddress;
        this.description = description;
        this.state = state;
    }

    public static Location create(String name, String headquarters, String address, String urlQrAddress, String description){
        String nameEdit = name.toLowerCase().trim();

        return new Location(null ,nameEdit,headquarters, address, urlQrAddress, description,  true);
    }
    public static Location reconstitute(Long id,String name ,String headquarters, String address, String urlQrAddress, String description, boolean state){
        return new Location(id ,name,headquarters, address, urlQrAddress, description,  state);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public String getAddress() {
        return address;
    }

    public String getUrlQrAddress() {
        return urlQrAddress;
    }

    public String getDescription() {
        return description;
    }

    public boolean isState() {
        return state;
    }
}
