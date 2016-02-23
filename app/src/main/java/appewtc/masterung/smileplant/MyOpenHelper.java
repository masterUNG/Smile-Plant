package appewtc.masterung.smileplant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 2/21/16 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name = "plant.db";
    private static final int database_version = 1;
    private static final String create_plantTABLE = "create table plantTABLE (" +
            "_id integer primary key, " +
            "Nameth text," +
            "Nameeng text," +
            "HProduc text," +
            "HAge text," +
            "HSeason text," +
            "HPlant text," +
            "Data text," +
            "ground text," +
            "plant text," +
            "water text," +
            "compost text," +
            "protect text," +
            "Harvest text );";


    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(create_plantTABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
