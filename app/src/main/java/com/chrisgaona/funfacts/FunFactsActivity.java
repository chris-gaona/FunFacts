package com.chrisgaona.funfacts;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    // Declare our view variables
    private NetworkReceiver mNetworkReceiver = new NetworkReceiver();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    // declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private ConstraintLayout mConstraintLayout;
    private static final String TAG = "FunFactsActivity";

//    public boolean isOnline() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        return (networkInfo != null && networkInfo.isConnected());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

//        mNetworkReceiver.onReceive(context, intent);

        // Assign the Views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fact = mFactBook.getFact();

                // update the screen with our dynamic fact
                mFactTextView.setText(fact);
                // update the screen with dynamic background color
                int color = mColorWheel.getColor();
                mConstraintLayout.setBackgroundColor(color);

                mShowFactButton.setTextColor(color);
            }
        };

        mShowFactButton.setOnClickListener(listener);
    }
}
