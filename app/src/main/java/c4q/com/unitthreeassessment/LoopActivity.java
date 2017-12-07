package c4q.com.unitthreeassessment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class LoopActivity extends AppCompatActivity {

    private int numInput;
    public EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

    }

    private class Async extends AsyncTask<Integer,Integer,Integer> {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.clear();

        @Override
        protected void onPreExecute(){

        }

        protected void doInBackground(Integer[]value){
            for(int i = 0; i< 100000;i++){
                publishProgress(i);
            }

        }

        protected void onProgressUpdate(Integer ... progress){
            display.setText("");

        }

        protected void onPostExcecute(Integer result){
            numInput.setText("Loopd completed : " + result);
            Intent intent new Intent(LoopActivity.this, LoginActivity.class);
        }
    };
}
