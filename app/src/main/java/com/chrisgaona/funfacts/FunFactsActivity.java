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
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    // these are constant variables
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";

    // Declare our view variables
    private NetworkReceiver mNetworkReceiver = new NetworkReceiver();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    // declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private ConstraintLayout mConstraintLayout;
    private static final String TAG = FunFactsActivity.class.getSimpleName();
    // assign mFact initially
    private String mFact = mFactBook.mFacts[0];
    // need to parse color to convert the string to an int
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

//    public boolean isOnline() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        return (networkInfo != null && networkInfo.isConnected());
//    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // used to access saved instance state bundle
        super.onRestoreInstanceState(savedInstanceState);

        // retrieve by using the same key to save
        mFact = savedInstanceState.getString(KEY_FACT);
        mFactTextView.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        mConstraintLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // this method is used to save state during orientation change of app
        // save instance state bundle
        super.onSaveInstanceState(outState);

        // save certain items to be retrieved after orientation change of app on same activity
        // use constants as the key
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

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
                mFact = mFactBook.getFact();

                // update the screen with our dynamic fact
                mFactTextView.setText(mFact);
                // update the screen with dynamic background color
                mColor = mColorWheel.getColor();
                mConstraintLayout.setBackgroundColor(mColor);

                mShowFactButton.setTextColor(mColor);
            }
        };

        mShowFactButton.setOnClickListener(listener);

//        Toast.makeText(this, "Yay! Our Activity was created.", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the onCreate() method");
    }
}
