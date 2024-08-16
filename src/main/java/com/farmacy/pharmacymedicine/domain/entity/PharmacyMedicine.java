package com.farmacy.pharmacymedicine.domain.entity;

public class PharmacyMedicine {
    private int idPharmacy;
    private int idMedicine;
    private double price;

    public PharmacyMedicine(int idPharmacy, int idMedicine, double price) {
        this.idPharmacy = idPharmacy;
        this.idMedicine = idMedicine;
        this.price = price;
    }

    public int getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(int idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
