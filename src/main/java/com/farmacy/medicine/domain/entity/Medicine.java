package com.farmacy.medicine.domain.entity;

public class Medicine {
    private int id;
    private String proceedings;
    private String nameMedic;
    private String healthRegister;
    private String description;
    private String codeComposition;
    private int idAP;
    private int idLab;
    private int codeUM;
    private String nameRole;

    
    public Medicine(String proceedings, String nameMedic, String healthRegister, String description, String codeComposition, int idAP, int idLab, int codeUM, String nameRole) {
        this.proceedings = proceedings;
        this.nameMedic = nameMedic;
        this.healthRegister = healthRegister;
        this.description = description;
        this.codeComposition = codeComposition;
        this.idAP = idAP;
        this.idLab = idLab;
        this.codeUM = codeUM;
        this.nameRole = nameRole;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getProceedings() {
        return proceedings;
    }

    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }

    public String getNameMedic() {
        return nameMedic;
    }

    public void setNameMedic(String nameMedic) {
        this.nameMedic = nameMedic;
    }

    public String getHealthRegister() {
        return healthRegister;
    }

    public void setHealthRegister(String healthRegister) {
        this.healthRegister = healthRegister;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeComposition() {
        return codeComposition;
    }

    public void setCodeComposition(String codeComposition) {
        this.codeComposition = codeComposition;
    }

    public int getIdAP() {
        return idAP;
    }

    public void setIdAP(int idAP) {
        this.idAP = idAP;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public int getCodeUM() {
        return codeUM;
    }

    public void setCodeUM(int codeUM) {
        this.codeUM = codeUM;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
