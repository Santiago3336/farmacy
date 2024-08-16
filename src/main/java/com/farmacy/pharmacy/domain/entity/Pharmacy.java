package com.farmacy.pharmacy.domain.entity;

public class Pharmacy {
    private int idPharmacy;
    private String namePharmacy;
    private String addressPharmacy;
    private double latPharmacy;
    private double longPharmacy;
    private String codeCityPharmacy;
    private String logoPharmacy;

    public Pharmacy(int idPharmacy, String namePharmacy, String addressPharmacy, double latPharmacy, double longPharmacy, String codeCityPharmacy, String logoPharmacy) {
        this.idPharmacy = idPharmacy;
        this.namePharmacy = namePharmacy;
        this.addressPharmacy = addressPharmacy;
        this.latPharmacy = latPharmacy;
        this.longPharmacy = longPharmacy;
        this.codeCityPharmacy = codeCityPharmacy;
        this.logoPharmacy = logoPharmacy;
    }

    public int getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(int idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public String getNamePharmacy() {
        return namePharmacy;
    }

    public void setNamePharmacy(String namePharmacy) {
        this.namePharmacy = namePharmacy;
    }

    public String getAddressPharmacy() {
        return addressPharmacy;
    }

    public void setAddressPharmacy(String addressPharmacy) {
        this.addressPharmacy = addressPharmacy;
    }

    public double getLatPharmacy() {
        return latPharmacy;
    }

    public void setLatPharmacy(double latPharmacy) {
        this.latPharmacy = latPharmacy;
    }

    public double getLongPharmacy() {
        return longPharmacy;
    }

    public void setLongPharmacy(double longPharmacy) {
        this.longPharmacy = longPharmacy;
    }

    public String getCodeCityPharmacy() {
        return codeCityPharmacy;
    }

    public void setCodeCityPharmacy(String codeCityPharmacy) {
        this.codeCityPharmacy = codeCityPharmacy;
    }

    public String getLogoPharmacy() {
        return logoPharmacy;
    }

    public void setLogoPharmacy(String logoPharmacy) {
        this.logoPharmacy = logoPharmacy;
    }
}
