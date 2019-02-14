package zesley.sergey.githubusersreader.Detailed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WorkWithDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_USERS = "github_users";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String DATABASE_NAME = "users.db";


    public WorkWithDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (" + COLUMN_USER_NAME + " TEXT PRIMARY KEY)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
