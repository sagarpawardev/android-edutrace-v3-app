package com.sgrpwr.collegepreditctor.common.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import com.sgrpwr.collegepreditctor.common.model.SavedCollege;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sagar on 23/3/17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "edutrace.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TAG = "My Tag";
    private Context context;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, SavedCollege.class);

            //TODO Uncomment This
            /*TableUtils.createTableIfNotExists(connectionSource, Exam.class);
            TableUtils.createTableIfNotExists(connectionSource, College.class);
            TableUtils.createTableIfNotExists(connectionSource, Branch.class);
            TableUtils.createTableIfNotExists(connectionSource, City.class);

            DatabaseInitializer initializer = new DatabaseInitializer(context, this);
            initializer.initBranch();
            initializer.initCity();
            initializer.initCollege();
            initializer.initExam();*/

        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, "DatabaseHelper.onCreate(): "+e.getMessage());
            Toast.makeText(context, "Some Internal Problem. Please Reinstall App", Toast.LENGTH_SHORT).show();
        }
        //TODO Uncomment This
        /*catch (JSONException | IOException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, SavedCollege.class, true);

            //TODO Uncomment This
            /*TableUtils.dropTable(connectionSource, Exam.class, true);
            TableUtils.dropTable(connectionSource, College.class, true);
            TableUtils.dropTable(connectionSource, Branch.class, true);
            TableUtils.dropTable(connectionSource, City.class, true);*/

            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, SavedCollege.class, true);
            //TODO Uncomment This
            /*TableUtils.dropTable(connectionSource, Exam.class, true);
            TableUtils.dropTable(connectionSource, College.class, true);
            TableUtils.dropTable(connectionSource, Branch.class, true);
            TableUtils.dropTable(connectionSource, City.class, true);*/

            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO Uncomment This
    /*public Dao<Exam, Integer>  getExamDao(){
        try {
            examDao = getDao(Exam.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, "DatabaseHelper.getExamDao(): "+e.getMessage());
        }
        return  examDao;
    }*/

    public Dao<SavedCollege, String> getSavedCollegeDao(){
        Dao<SavedCollege, String> dao = null;
        try {
            dao = getDao(SavedCollege.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, this.getClass().getName()+"getSavedCollegeDao: "+e.getMessage());
        }
        return dao;
    }

    //TODO Uncomment This
    /*public Dao<College,Integer> getCollegeDao(){
        Dao<College, Integer> dao = null;
        try {
            dao = getDao(College.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, this.getClass().getName()+".getCollegeDao: "+e.getMessage());
        }
        return dao;
    }

    public Dao<Branch, Integer> getBranchDao(){
        Dao<Branch, Integer> dao = null;
        try {
            dao = getDao(Branch.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, this.getClass().getName()+".getBranchDao: "+e.getMessage());
        }
        return dao;
    }

    public Dao<City, Integer> getCityDao(){
        Dao<City, Integer> dao = null;
        try {
            dao = getDao(City.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(TAG, this.getClass().getName()+".getCityDao: "+e.getMessage());
        }
        return dao;
    }*/
}
