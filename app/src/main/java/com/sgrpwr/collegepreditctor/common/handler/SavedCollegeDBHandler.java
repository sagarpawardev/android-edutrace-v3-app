package com.sgrpwr.collegepreditctor.common.handler;

import android.content.Context;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.sgrpwr.collegepreditctor.common.helper.DatabaseHelper;
import com.sgrpwr.collegepreditctor.common.model.SavedCollege;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagar on 15/4/17.
 */

public class SavedCollegeDBHandler {
    Dao<SavedCollege, String> dao;
    Context context;
    public SavedCollegeDBHandler(Context context){
        DatabaseHelper helper = new DatabaseHelper(context);
        dao = helper.getSavedCollegeDao();
        this.context = context;
    }

    public boolean toggleSave(SavedCollege college){
        boolean result = false;
        String collegeId = college.getCollegeCode();
        try {
            boolean idExists = dao.idExists(collegeId);
            if(idExists) {
                dao.deleteById(collegeId);
            }
            else {
                dao.create(college);
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(context, "DB Exception: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    public boolean exists(String collegeCode) throws SQLException {
        return  dao.idExists(collegeCode);
    }

    public List<SavedCollege> getSavedColleges(){
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            Toast.makeText(context, "DB Exception: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void remove(String collegeCode){
        try {
            dao.deleteById(collegeCode);
        } catch (SQLException e) {
            Toast.makeText(context, "DB Exception: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


}
