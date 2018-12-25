package com.sgrpwr.collegepreditctor.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.sgrpwr.collegepreditctor.R;
import com.sgrpwr.collegepreditctor.activities.savedcollege.adapter.SavedCollegeListAdapter;
import com.sgrpwr.collegepreditctor.common.handler.SavedCollegeDBHandler;

public class SavedCollegeActivity extends AppCompatActivity
    implements SavedCollegeListAdapter.Callback {

        private static final String TAG = "My Tag";
        ListView lvColleges;
        SavedCollegeListAdapter adapter;
        SavedCollegeDBHandler dbHandler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_saved_college);
            init();
            lvColleges.setAdapter(adapter);
            if(adapter.getCount()>0)
                findViewById(R.id.place_holder).setVisibility(View.GONE);
        }

        protected void init(){
            lvColleges = (ListView) findViewById(R.id.listView);
            dbHandler = new SavedCollegeDBHandler(this);
            adapter = new SavedCollegeListAdapter(this, this);
        }

        @Override
        public void onRowItemClicked(String collegeCode) {
            //Start Saved College Activity
            /*requestHandler = new CollegeDetailsRequestHandler(this, this);
            CollegeDetailsRequestDTO requestDTO = new CollegeDetailsRequestDTO();
            requestDTO.setCollegeCode(collegeCode);
            dialog.show();
            requestHandler.execute(requestDTO);*/

            Toast.makeText(this, "Click College Code: "+collegeCode, Toast.LENGTH_SHORT).show();
        }

        /*@Override
        public void onResponseSuccess() {
            dialog.dismiss();
            CollegeDetailsResponseDTO response = null;
            try {
                response = requestHandler.get();
                CollegeDetails details = response.toBean();
                nextActivity(details);
            } catch (InterruptedException| ExecutionException e) {
                e.printStackTrace();
                Toast.makeText(this, "Looks Server is Facing Problem", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onResponseSuccess: Execution Exception"+e.getMessage() );
            }
        }

        private void nextActivity(CollegeDetails details){
            Bundle basket = new Bundle();
            basket.putSerializable(CollegeDetailsActivity.COLLEGE_DETAILS,  details);
            Intent intent = new Intent(this, CollegeDetailsActivity.class);
            intent.putExtras(basket);
            startActivity(intent);
        }

        @Override
        public void onResponseFailure() {
            dialog.dismiss();
            try {
                CollegeDetailsResponseDTO response = requestHandler.get();
                Toast.makeText(this, "Error: "+response.getError().getMessage(), Toast.LENGTH_SHORT).show();

                //Testing data
            *//*response = TestData.collegeDetails();
            nextActivity(response);*//*
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }*/
    }
