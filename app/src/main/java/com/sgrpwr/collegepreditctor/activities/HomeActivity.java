package com.sgrpwr.collegepreditctor.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.sgrpwr.collegepreditctor.R;
import com.sgrpwr.collegepreditctor.utils.TypefaceUtil;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    View iconExplore, iconSaved, iconPredict, iconChat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);

        TextView tv = findViewById(R.id.app_name);
        Typeface typeface = TypefaceUtil.confortaBold(this);
        tv.setTypeface(typeface);

        init();
        addListeners();

    }

    private void init(){
        iconExplore = findViewById(R.id.icon_explore);
        iconSaved =  findViewById(R.id.icon_saved_college);
        iconPredict = findViewById(R.id.icon_predict);
        iconChat = findViewById(R.id.icon_chat);

    }

    private void addListeners(){
        iconExplore.setOnClickListener(this);
        iconSaved.setOnClickListener(this);
        iconPredict.setOnClickListener(this);
        iconChat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.layout_extra:
                Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show();
                //intent = new Intent(this, AdvanceSearchActivity.class);
                return;
            case R.id.icon_saved_college:
                intent = new Intent(this, SavedCollegeActivity.class);
                break;
            case R.id.icon_explore:
                intent = new Intent(this, CollegeListActivity.class);
                break;
        }
        if(intent == null) {
            Toast.makeText(this, "No Intent On This View", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
