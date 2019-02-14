package zesley.sergey.githubusersreader.Presenters;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import zesley.sergey.githubusersreader.App;
import zesley.sergey.githubusersreader.Detailed.OneUser;
import zesley.sergey.githubusersreader.Detailed.WorkWithDB;
import zesley.sergey.githubusersreader.AllUsersView;

@InjectViewState
public class AllUsersPresenter extends MvpPresenter<AllUsersView> {
    private List<OneUser> allUsers;
    private WorkWithDB workWithDB;

    public AllUsersPresenter() {
        workWithDB = new WorkWithDB(App.getInstance());
        allUsers=new ArrayList<>();
        initUsersList();
        getViewState().showAllUsers(allUsers);

    }

    public void addNewUser(String usr){
        SQLiteDatabase db = workWithDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(WorkWithDB.COLUMN_USER_NAME, usr);
        db.insert(WorkWithDB.TABLE_USERS,null,cv);
        db.close();
        initUsersList();
        getViewState().showAllUsers(allUsers);

    }

    private void initUsersList() {
        allUsers.clear();

        SQLiteDatabase db = workWithDB.getWritableDatabase();
        Cursor c = db.query(WorkWithDB.TABLE_USERS,
                new String[]{WorkWithDB.COLUMN_USER_NAME},
                null, null, null, null, WorkWithDB.COLUMN_USER_NAME);

        if (c.moveToFirst()) {
            do {
                allUsers.add(new OneUser(c.getString(0)));

            } while (c.moveToNext());

        }
        c.close();
        db.close();
    }


    public void showUser(int index, String name) {

    }

}
