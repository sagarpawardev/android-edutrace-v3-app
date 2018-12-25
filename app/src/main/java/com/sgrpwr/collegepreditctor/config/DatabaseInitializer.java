package com.sgrpwr.collegepreditctor.config;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import com.sgrpwr.collegepreditctor.common.helper.DatabaseHelper;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Created by sagar on 22/4/17.
 */

public class DatabaseInitializer {

    private static final String TAG = "MY TAG";
    private Context context;
    private DatabaseHelper helper;

    public DatabaseInitializer(Context context, DatabaseHelper helper) {
        this.context = context;
        this.helper = helper;
    }

    //TODO Uncomment this
    /*public void initExam() throws IOException, JSONException, SQLException {
        Dao<Exam,Integer> dao = helper.getExamDao();
        JSONArray main = readFile(R.raw.exam);
        for(int i=0; i<main.length(); i++ ){
            JSONArray current = main.getJSONArray(i);
            Exam exam = new Exam();

            String name = current.getString(0);
            int maxMarks = current.getInt(1);
            exam.setName(name);
            exam.setMaxMarks(maxMarks);
            dao.create(exam);
        }
    }

    public void initCollege() throws IOException, JSONException, SQLException {
        JSONArray main = readFile(R.raw.college);
        Dao<College, Integer> dao = helper.getCollegeDao();
        for(int i=0; i<main.length(); i++ ){
            JSONArray current = main.getJSONArray(i);
            College college = new College();
            int code = current.getInt(0);
            String name = current.getString(1);
            String city = current.getString(2);
            college.setName(name);
            college.setCity(city);
            college.setCode(code);
            dao.create(college);
        }
    }

    public void initCity() throws IOException, JSONException, SQLException {
        JSONArray main = readFile(R.raw.city);
        Dao<City, Integer> dao = helper.getCityDao();
        for(int i=0; i<main.length(); i++ ){
            JSONArray current = main.getJSONArray(i);
            City city = new City();
            String name = current.getString(0);
            int count = current.getInt(1);
            city.setName(name);
            city.setCollegeCount(count);
            dao.create(city);
        }
    }

    public void initBranch() throws IOException, JSONException, SQLException {
        JSONArray main = readFile(R.raw.branch);
        Dao<Branch, Integer> dao = helper.getBranchDao();
        for(int i=0; i<main.length(); i++ ){
            JSONArray current = main.getJSONArray(i);
            Branch branch = new Branch();

            String name = current.getString(0);
            int count = current.getInt(1);
            branch.setName(name);
            branch.setCollegeCount(count);
            dao.create(branch);
        }
    }*/

    private JSONArray readFile(int file) throws IOException, JSONException  {
        InputStream is = context.getResources().openRawResource(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String temp;
        StringBuilder builder = new StringBuilder();
        while((temp=reader.readLine())!=null){
            builder.append(temp);
        }
        JSONArray main = new JSONArray(builder.toString());
        return  main;
    }
}
