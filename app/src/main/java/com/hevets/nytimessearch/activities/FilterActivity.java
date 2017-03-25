package com.hevets.nytimessearch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

import com.hevets.nytimessearch.R;
import com.hevets.nytimessearch.models.Filter;

public class FilterActivity extends AppCompatActivity {

    String sortValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupView();
    }

    public void setupView() {
        RadioButton newestButton = (RadioButton)findViewById(R.id.radioNewest);
        newestButton.setChecked(true);
        sortValue = "newest";
    }

    public void onRadioButtonTapped(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioNewest:
                if (checked)
                    sortValue = "newest";
                break;
            case R.id.radioOldest:
                if (checked)
                    sortValue = "oldest";
                break;
        }
    }

    public void onSubmitTapped(View view) {
        Intent data = new Intent();
        // Pass relevant data back as a result

        Filter filter = new Filter();

        filter.setSortby(sortValue);
        data.putExtra("filter", filter);
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

    public void captureValues() {

    }
}
