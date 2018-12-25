package com.sgrpwr.collegepreditctor.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.sgrpwr.collegepreditctor.R;
import com.sgrpwr.collegepreditctor.activities.collegelist.adapter.RVCollegeListAdapter;

public class CollegeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        RVCollegeListAdapter adapter = new RVCollegeListAdapter();
        RecyclerView recyclerView = findViewById(R.id.rv_college_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
