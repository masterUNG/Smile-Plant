package appewtc.masterung.smileplant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 2/22/16 AD.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String plant_table = "plantTABLE";
    public static final String column_id = "_id";
    public static final String column_Nameth = "Nameth";
    public static final String column_Nameeng = "Nameeng";
    public static final String column_HProduc = "HProduc";
    public static final String column_HAge = "HAge";
    public static final String column_HSeason = "HSeason";
    public static final String column_HPlant = "HPlant";
    public static final String column_Data = "Data";
    public static final String column_ground = "ground";
    public static final String column_plant = "plant";
    public static final String column_water = "water";
    public static final String column_compost = "compost";
    public static final String column_protect = "protect";
    public static final String column_Harvest = "Harvest";


    public ManageTABLE(Context context) {

        //Create & Connected
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();

    }   // Constructor

    public long addPlant(String strNameth,
                         String strNameeng,
                         String strHProduc,
                         String strHAge,
                         String strHSeason,
                         String strHPlant,
                         String strData,
                         String strground,
                         String strplant,
                         String strwater,
                         String strcompost,
                         String strprotect,
                         String strHarvest) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Nameth, strNameth);
        contentValues.put(column_Nameeng, strNameeng);
        contentValues.put(column_HProduc, strHProduc);
        contentValues.put(column_HAge, strHAge);
        contentValues.put(column_HSeason, strHSeason);
        contentValues.put(column_HPlant, strHPlant);
        contentValues.put(column_Data, strData);
        contentValues.put(column_ground, strground);
        contentValues.put(column_plant, strplant);
        contentValues.put(column_water, strwater);
        contentValues.put(column_compost, strcompost);
        contentValues.put(column_protect, strprotect);
        contentValues.put(column_Harvest, strHarvest);

        return writeSqLiteDatabase.insert(plant_table, null, contentValues);
    }


}   // Main Class
