package com.chrisgaona.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    // Declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout file to the corresponding variables
        final TextView mFactTextView = (TextView) findViewById(R.id.factTextView);
        Button mShowFactButton = (Button) findViewById(R.id.showFactButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the button was clicked so update the fact TextView with a new fact
                String fact = "Ostriches can run faster than horses.";
                mFactTextView.setText(fact);
            }
        };

        mShowFactButton.setOnClickListener(listener);
    }
}
