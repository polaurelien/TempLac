package com.example.templac;

import java.sql.Date;

public class Releve
{
    protected int idReleve;
    protected Lac unLac;
    protected Date dateReleve;
    protected String heureReleve;
    protected double tempReleve;

    public Releve(int idReleve, Lac unLac, Date dateReleve, String heureReleve, double tempReleve) {
        this.idReleve = idReleve;
        this.unLac = unLac;
        this.dateReleve = dateReleve;
        this.heureReleve = heureReleve;
        this.tempReleve = tempReleve;
    }

    public int getIdReleve() {
        return idReleve;
    }

    public void setIdReleve(int idReleve) {
        this.idReleve = idReleve;
    }

    public Lac getUnLac() {
        return unLac;
    }

    public void setUnLac(Lac unLac) {
        this.unLac = unLac;
    }

    public Date getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(Date dateReleve) {
        this.dateReleve = dateReleve;
    }

    public String getHeureReleve() {
        return heureReleve;
    }

    public void setHeureReleve(String heureReleve) {
        this.heureReleve = heureReleve;
    }

    public double getTempReleve() {
        return tempReleve;
    }

    public void setTempReleve(double tempReleve) {
        this.tempReleve = tempReleve;
    }
}
