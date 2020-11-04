package com.example.templac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOBDD {
    static final int VERSION_BDD =1;
    private static final String NOM_BDD = "TempeoBDD";


    //TABLE LAC -------------------------------------------------------------------------------------

    private static final String TABLE_LAC = "tlac";
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "nomLac";
    static final int NUM_COL_NOM = 1;
    private static final String COL_LONGITUDE = "longitudeLac";
    static final int NUM_COL_LONGITUDE = 2;
    private static final String COL_LATITUDE = "latitudeLac";
    static final int NUM_COL_LATITUDE = 3;

    //TABLE RELEVE ---------------------------------------------------------------------------------

    private static final String TABLE_RELEVE = "treleve";
    private static final String COL_LAC = "idLac";
    static final int NUM_COL_LAC = 0;
    private static final String COL_dateReleve = "dateReleve";
    static final int NUM_COL_dateReleve = 1;
    private static final String COL_heureReleve = "heureReleve";
    static final int NUM_COL_heureReleve = 2;
    private static final String COL_tempReleve = "tempReleve";
    static final int NUM_COL_tempReleve = 3;

    private CreateBDD tableCourante;
    private Context context;
    private SQLiteDatabase db;

    // Le constructeur

    public DAOBDD(Context context){
        this.context = context;
        tableCourante = new CreateBDD(context, NOM_BDD, null, VERSION_BDD);
    }

    // Méthodes d'intance

    public DAOBDD open(){
        db = tableCourante.getWritableDatabase();
        return this;
    }

    public DAOBDD close(){
        db.close();
        return null;
    }

    public long insererLac (Lac unLac){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM, unLac.getNom());
        values.put(COL_LONGITUDE, unLac.getLongitude());
        values.put(COL_LATITUDE, unLac.getLatitude());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_LAC, null, values);
    }

    private Lac cursorToLac(Cursor c){
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        Lac unLac = new Lac(null,null,null); //On créé un lac
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unLac.setNom(c.getString(NUM_COL_NOM));
        unLac.setLongitude(c.getString(NUM_COL_LONGITUDE));
        unLac.setLatitude(c.getString(NUM_COL_LATITUDE));
        c.close(); //On ferme le cursor
        return unLac; //On retourne un lac
    }

    public Lac getLactWithNom(String nom){
        //Récupère dans un Cursor les valeurs correspondant à un article grâce à sa designation
        Cursor c = db.query(TABLE_LAC, new String[]
                        {COL_ID,COL_NOM, COL_LATITUDE, COL_LONGITUDE}, COL_NOM + " =\"" + nom +"\"", null, null, null, null);
        return cursorToLac(c);
    }

    public Cursor getDataLac(){
        return db.rawQuery("SELECT * FROM tlac", null);
    }
    //pour le relevé

    public long insererReleve (Releve unReleve){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_dateReleve, unReleve.getDateReleve());
        values.put(COL_heureReleve, unReleve.getHeureReleve());
        values.put(COL_tempReleve, unReleve.getTempReleve());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_RELEVE, null, values);
    }
    private Releve cursorToReleve(Cursor c){ //Cette méthode permet de convertir un cursor en un relevé
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        Releve unReleve = new Releve(null,null,null,null); //On créé un relevé
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unReleve.setDateReleve(c.getString(NUM_COL_dateReleve));
        unReleve.setHeureReleve(c.getString(NUM_COL_heureReleve));
        unReleve.setTempReleve(c.getString(NUM_COL_tempReleve));
        c.close(); //On ferme le cursor
        return unReleve; //On retourne le relevé
    }
    public Releve getReleveWithNumCpt(String numcpt){
        //Récupère dans un Cursor les valeurs correspondant à un relevé grâce au numéro de compteur
        Cursor c = db.query(TABLE_RELEVE, new String[] {COL_LAC,COL_dateReleve, COL_heureReleve, COL_tempReleve}, COL_dateReleve + " = \"" + numcpt +"\"", null, null, null, null);
        return cursorToReleve(c);
    }
    public Cursor getDataReleve(){
        return db.rawQuery("SELECT * FROM treleve", null);
    }
}
