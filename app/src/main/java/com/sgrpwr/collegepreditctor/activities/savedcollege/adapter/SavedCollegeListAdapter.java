package com.sgrpwr.collegepreditctor.activities.savedcollege.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sgrpwr.collegepreditctor.R;
import com.sgrpwr.collegepreditctor.common.handler.SavedCollegeDBHandler;
import com.sgrpwr.collegepreditctor.common.model.SavedCollege;
import com.sgrpwr.collegepreditctor.utils.TypefaceUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ADITYA on 29-03-2017.
 */

/*
* 1. Extend BaseAdapter
* 2. Override BaseAdapter methods
* 3. Create Constructor
* 4. LayoutInflator(This inflates layout i.e. create a new instance of a layout)
* */
public class SavedCollegeListAdapter extends BaseAdapter implements View.OnClickListener{
    private List<SavedCollege> savedColleges;
    private LayoutInflater inflater;
    private Callback callback;
    private SavedCollegeDBHandler dbHandler;
    private Context context;
    private Typeface robotoCondensed;

    public static final int COLLEGE_CODE = 0;
    public static final int POSITION = 1;
    public SavedCollegeListAdapter(Context context, Callback callback){
        this.context = context;
        dbHandler = new SavedCollegeDBHandler(context);
        this.savedColleges = dbHandler.getSavedColleges();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.callback = callback;
        robotoCondensed = TypefaceUtil.robotoCondensed(context);
    }

    //Number of Rows in ListView
    @Override
    public int getCount() {
        return savedColleges.size();
    }

    //Time pass ke liye hai
    @Override
    public Object getItem(int position) {
        return null;
    }

    //Gives identity to rows
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Gives view to item
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null)
            view  = inflater.inflate(R.layout.row_saved_college, null);

        SavedCollege savedCollege = savedColleges.get(position);
        TextView tvCollegeName = (TextView) view.findViewById(R.id.college_name);
        ImageView btnStar = (ImageView) view.findViewById(R.id.btnStar);
        tvCollegeName.setText(savedCollege.getCollegeName());
        tvCollegeName.setTypeface(robotoCondensed);

        view.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnStar.setTag(savedCollege);
        view.setTag(savedCollege);
        String str = savedCollege.getCollegeCode();
        try {
            boolean exists = dbHandler.exists(str);
            activeStar(btnStar, exists);
        } catch (SQLException e) {
            Toast.makeText(context, "DB Exception: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStar: toggleSave(view); break;
            default: startNextActivity(view); break;
        }
    }

    private void toggleSave(View view){
        SavedCollege savedCollege = (SavedCollege) view.getTag();

        boolean inserted = dbHandler.toggleSave(savedCollege);
        activeStar(view, inserted);
    }

    private void activeStar(View view, boolean result) {
        ImageView imgView = (ImageView) view;
        int drawable, color;

        if (result){
            drawable = R.drawable.ic_star_black_24dp;
            color = R.color.amber;
        }
        else{
            drawable = R.drawable.ic_star_border_black_24dp;
            color = R.color.grey;
        }
        imgView.setImageResource(drawable);
        imgView.setColorFilter(ContextCompat.getColor(context, color));
    }

    private void startNextActivity(View view){
        SavedCollege college = (SavedCollege) view.getTag();
        String collegeCode = college.getCollegeCode();
        callback.onRowItemClicked(collegeCode);
    }

    public interface Callback{
        void onRowItemClicked(String collegeCode);
    }
}
