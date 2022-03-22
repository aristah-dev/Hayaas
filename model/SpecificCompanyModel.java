package com.example.safarirides.model;

public class SpecificCompanyModel {

    String image;
    String route;
    String departure;
    String arrival;
    String price;
    String pickup_office;

    public SpecificCompanyModel(String image, String route, String departure, String arrival, String price, String pickup_office) {
        this.image = image;
        this.route = route;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.pickup_office = pickup_office;
    }

    public String getImage() {
        return image;
    }

    public String getRoute() {
        return route;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getPrice() {
        return price;
    }

    public String getPickup_office() {
        return pickup_office;
    }
}
