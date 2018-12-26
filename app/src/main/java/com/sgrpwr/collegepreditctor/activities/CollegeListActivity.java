package com.sgrpwr.collegepreditctor.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.sgrpwr.collegepreditctor.R;
import com.sgrpwr.collegepreditctor.activities.collegelist.adapter.RVCollegeListAdapter;
import com.sgrpwr.collegepreditctor.common.api.API;
import com.sgrpwr.collegepreditctor.common.api.APIBuilder;
import com.sgrpwr.collegepreditctor.activities.collegelist.api.model.CollegeListAPIModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

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

        callAPI(adapter);
    }

    public void callAPI(RVCollegeListAdapter adapter){
        API api = APIBuilder.getAPI();
        Call<CollegeListAPIModel> call = api.getCollegeList();
        call.enqueue(new Callback <CollegeListAPIModel>(){

            @Override
            public void onResponse(Call<CollegeListAPIModel> call, Response<CollegeListAPIModel> response) {

                CollegeListAPIModel model = response.body();
                List<CollegeListAPIModel.CollegeListItem> collegeList = model.getResults();
                Toast.makeText(CollegeListActivity.this, "GotList Size: "+collegeList.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<CollegeListAPIModel> call, Throwable t) {
                Toast.makeText(CollegeListActivity.this, "API Calling Failed...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
