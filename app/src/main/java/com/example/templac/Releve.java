package com.example.templac;

public class Releve
{
    protected int id;
    protected int idLac;
    protected String dateReleve;
    protected String heureReleve;
    protected String tempReleve;

    public Releve(int unLac, String dateReleve, String heureReleve, String tempReleve)
    {
        this.idLac = unLac;
        this.dateReleve = dateReleve;
        this.heureReleve = heureReleve;
        this.tempReleve = tempReleve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnLac() {
        return idLac;
    }

    public void setUnLac(int unLac) {
        this.idLac = unLac;
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
