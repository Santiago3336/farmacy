package com.farmacy.laboratory.domain.entity;

public class Laboratory {
    private final int idLab;
    private final String nameLab;
    private final String codeReg;

    public Laboratory(int idLab, String nameLab, String codeReg) {
        this.idLab = idLab;
        this.nameLab = nameLab;
        this.codeReg = codeReg;
    }

    public int getIdLab() {
        return idLab;
    }

    public String getNameLab() {
        return nameLab;
    }

    public String getCodeReg() {
        return codeReg;
    }

    public void setIdLab(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'setIdLab'");
    }
}
