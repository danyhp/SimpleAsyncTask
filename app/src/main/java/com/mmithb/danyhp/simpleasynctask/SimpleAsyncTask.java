package com.mmithb.danyhp.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by ASUS on 27-Mar-18.
 */

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private TextView mTextView;

    public SimpleAsyncTask(TextView tv) {
        mTextView = tv;
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }

    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a string result
        return "Awake at last after sleeping for " + s + " milliseconds!";

    }
}
