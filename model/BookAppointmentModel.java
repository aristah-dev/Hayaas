package com.example.safarirides.model;

public class BookAppointmentModel {

    String booking_ref_no, bk_pickup_date,bk_dropoff_date,bk_status, phone;

    public String getBooking_ref_no() {
        return booking_ref_no;
    }

    public void setBooking_ref_no(String booking_ref_no) {
        this.booking_ref_no = booking_ref_no;
    }

    public String getBk_pickup_date() {
        return bk_pickup_date;
    }

    public void setBk_pickup_date(String bk_pickup_date) {
        this.bk_pickup_date = bk_pickup_date;
    }

    public String getBk_dropoff_date() {
        return bk_dropoff_date;
    }

    public void setBk_dropoff_date(String bk_dropoff_date) {
        this.bk_dropoff_date = bk_dropoff_date;
    }

    public String getBk_status() {
        return bk_status;
    }

    public void setBk_status(String bk_status) {
        this.bk_status = bk_status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BookAppointmentModel(String booking_ref_no, String bk_pickup_date, String bk_dropoff_date, String bk_status, String phone) {
        this.booking_ref_no = booking_ref_no;
        this.bk_pickup_date = bk_pickup_date;
        this.bk_dropoff_date = bk_dropoff_date;
        this.bk_status = bk_status;
        this.phone = phone;


    }
}
