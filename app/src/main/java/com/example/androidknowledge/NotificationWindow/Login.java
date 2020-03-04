package com.example.androidknowledge.NotificationWindow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import com.example.androidknowledge.R;

public class Login extends Activity {
    private CheckBox saveLogin;
    private static EditText user,password;
    private static Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        findid();
        TakeUser();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SaveLogin();

                dialog();
            }

        });

    }

    private void TakeUser() {
        SharedPreferences preferences = getSharedPreferences("my_login",MODE_PRIVATE);
        boolean check = preferences.getBoolean("check_save",false);

        if (check == true)
        {
            String userName = preferences.getString("user","");
            String passName = preferences.getString("pass","");
            user.setText(userName);
            password.setText(passName);
            saveLogin.setChecked(check);
        }
        else
        {
            user.setText("");
            password.setText("");
            saveLogin.setChecked(check);
        }
    }

    private void SaveLogin() {
        SharedPreferences preferences = getSharedPreferences("my_login",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",user.getText().toString());
        editor.putString("pass",password.getText().toString());
        editor.putBoolean("check_save",saveLogin.isChecked());
        editor.commit();
    }

    private void findid()
    {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        saveLogin = (CheckBox) findViewById(R.id.save_login);
    }

    private void dialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setTitle("Login");
        builder.setMessage("User="+user.getText().toString()+'\n'
                +"password=" +password.getText().toString() );
        builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
