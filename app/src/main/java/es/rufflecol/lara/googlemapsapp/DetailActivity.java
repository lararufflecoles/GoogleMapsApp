package es.rufflecol.lara.googlemapsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

//      String activityDetailString = intent.getStringExtra("activityDetail");
//      TextView textView = (TextView) findViewById(R.id.tutorial_screen_text);
//      textView.setText(activityDetailString);

        int activityDetailTitle = intent.getIntExtra("activityDetailTitle", -1);
        if (activityDetailTitle != -1) {
            setTitle(activityDetailTitle);
        } else {
            Toast.makeText(this, "Error, no title available", Toast.LENGTH_SHORT).show();
        }

        int activityDetailImage = intent.getIntExtra("activityDetailImage", -1);
        if (activityDetailImage != -1) {
            ImageView imageView = (ImageView) findViewById(R.id.bmImageView);
            imageView.setImageResource(activityDetailImage);
        } else {
            Toast.makeText(this, "Error, no image available", Toast.LENGTH_SHORT).show();
        }

        int activityDetailText = intent.getIntExtra("activityDetailText", -1);
        if (activityDetailText != -1) {
            TextView textView = (TextView) findViewById(R.id.tutorial_screen_text);
            textView.setText(activityDetailText);
        } else {
            Toast.makeText(this, "Error, no detail available", Toast.LENGTH_SHORT).show();
        }
    }











    // Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.activity_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_share:
                openShare();
                return true;
//            case R.id.action_search:
//                openSearch();
//                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Methods with no return type - void ones
    private void openShare() {
    }

    private void openSearch() {
    }

    private void openSettings() {
    }
}