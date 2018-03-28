package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import io.github.vladimirmi.joker.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private EndpointsAsyncTask asyncTask;
    private ProgressBar loadIndicator;
    protected Button tellJokeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadIndicator = findViewById(R.id.loadingPb);

        tellJokeBtn = findViewById(R.id.tell_joke);
        tellJokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (asyncTask != null) asyncTask.setCallback(null);
    }

    protected void tellJoke() {
        loadIndicator.setVisibility(View.VISIBLE);
        asyncTask = new EndpointsAsyncTask();
        asyncTask.setCallback(new EndpointsAsyncTask.Callback() {
            @Override
            public void onJokeLoad(String joke) {
                loadIndicator.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.EXTRA_JOKE, joke);
                startActivity(intent);
            }
        });
        asyncTask.execute();
    }
}
