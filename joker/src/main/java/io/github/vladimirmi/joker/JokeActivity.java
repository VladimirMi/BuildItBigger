package io.github.vladimirmi.joker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke;

        if (getIntent().hasExtra(EXTRA_JOKE)) {
            joke = getIntent().getStringExtra(EXTRA_JOKE);
        } else {
            joke = "You should pass joke via intent extra";
        }

        TextView jokeView = findViewById(R.id.joke);
        jokeView.setText(joke);
    }
}
