package com.example.safarirides.model;

import android.content.Context;

public class Car {

    String seats_no;
    String manufacturer;
    String year;
    String milleage;
    String image_url;
    String owner_phone;
    String model;
    String status;
    String description;
    String booking_price;

    public Car(String seats_no, String manufacturer, String year, String milleage, String image_url, String owner_phone, String model, String status, String description, String booking_price) {
        this.seats_no = seats_no;
        this.manufacturer = manufacturer;
        this.year = year;
        this.milleage = milleage;
        this.image_url = image_url;
        this.owner_phone = owner_phone;
        this.model = model;
        this.status = status;
        this.description = description;
        this.booking_price = booking_price;
    }

    public String getSeats_no() {
        return seats_no;
    }

    public void setSeats_no(String seats_no) {
        this.seats_no = seats_no;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMilleage() {
        return milleage;
    }

    public void setMilleage(String milleage) {
        this.milleage = milleage;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBooking_price() {
        return booking_price;
    }

    public void setBooking_price(String booking_price) {
        this.booking_price = booking_price;
    }
}
