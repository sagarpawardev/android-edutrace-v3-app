package com.sgrpwr.collegepreditctor.common.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ADITYA on 29-03-2017.
 */
@DatabaseTable(tableName = "saved_college")
public class SavedCollege {

    private static final String TAG = "My Tag";

    @DatabaseField(id = true)
    private String collegeCode;

    @DatabaseField
    private String collegeName;

    @DatabaseField
    private String  city;
    //{collegeName:'Shri Ramdeobaba',
    // collegeCode:'1234',
    // city:'Nagpur'}

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }
}
