package com.example.templac;

import java.sql.Date;

public class Releve
{
    protected Lac unLac;
    protected String dateReleve;
    protected String heureReleve;
    protected String tempReleve;

    public Releve(Lac unLac, String dateReleve, String heureReleve, String tempReleve) {

        this.unLac = unLac;
        this.dateReleve = dateReleve;
        this.heureReleve = heureReleve;
        this.tempReleve = tempReleve;
    }


    public Lac getUnLac() {
        return unLac;
    }

    public void setUnLac(Lac unLac) {
        this.unLac = unLac;
    }

    public String getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(String dateReleve) {
        this.dateReleve = dateReleve;
    }

    public String getHeureReleve() {
        return heureReleve;
    }

    public void setHeureReleve(String heureReleve) {
        this.heureReleve = heureReleve;
    }

    public String getTempReleve() {
        return tempReleve;
    }

    public void setTempReleve(String tempReleve) {
        this.tempReleve = tempReleve;
    }
}
