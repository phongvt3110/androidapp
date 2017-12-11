package vn.eas.app1;

/**
 * Created by phongvt on 5/22/17.
 */
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataController extends SQLiteOpenHelper {
    public String DB_PATH = "//data//data//%s//databases";
    private static String dbname = "qlsv";
    public SQLiteDatabase database;
    public final Context mcontext;
    public SQLiteDataController(Context con) {
        super(con, dbname, null, 1);
        this.mcontext = con;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
