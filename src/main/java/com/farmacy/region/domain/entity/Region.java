package com.farmacy.region.domain.entity;

public class Region {
    private String codeRegion;
    private String nameRegion;
    private String codeCountry;

    public Region(String codeRegion, String nameRegion, String codeCountry) {
        this.codeRegion = codeRegion;
        this.nameRegion = nameRegion;
        this.codeCountry = codeCountry;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }
}
