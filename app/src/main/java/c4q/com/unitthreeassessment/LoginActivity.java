package c4q.com.unitthreeassessment;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String SHARED_PREF_KEY = "Something";
    private EditText username;
    private EditText password;
    private CheckBox checkBox;
    private Button button;
    private SharedPreferences login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.edit1);
        password= (EditText) findViewById(R.id.edit2);
        checkBox= (CheckBox) findViewById(R.id.checkbox);
        button= (Button) findViewById(R.id.button);

        login = getApplicationContext().getSharedPreferences(SHARED_PREF_KEY,MODE_PRIVATE);

        if (login.getBoolean("isCHecked", false)){
            username.setText(login.getString("username", null);
            password.setText(login.getString("password",null));
            checkBox.setChecked(login.getBoolean("isChecked",false));
        }

        button.setOnClickListener(
                SharedPreferences.Editor editor =login.edit();
                if (checkBox.isChecked()){
                    editor.putstring("username", username.getText().toString());
                    editor.putstring("password",password.getText().toString());
                    editor.putBoolean("isChecked",checkBox.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked",checkBox.isChecked());
                    editor.commit();
                }

                String checkUser = "user" + username.getText().toString();
                String checkPassword ="password" + username.getText().toString();

        if (username.getText().toString().equalsIgnoreCase(login.getString(checkUser, null))
                && password.getText().toString().equals(login.getString(checkPassword, null))){
            Intent intent = new Intent(LoginActivity.this, ListActivity.class);
            intent.putExtra("current",username.getText().toString());
            startActivity(intent);
        }
            ;
        }

    }
}
