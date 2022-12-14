package com.example.kulagin_max;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reg extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText name;
    private Button login;
    private Button gotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        username = (EditText) findViewById(R.id.edit_email);
        name = (EditText) findViewById(R.id.edit_name);
        password = (EditText) findViewById(R.id.edit_password);
        login = (Button) findViewById(R.id.Register);
        gotologin = (Button) findViewById(R.id.GoToLogin);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reg.this, login.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(reg.this);
                if (isValidEmail(username.getText().toString()) &&
                        name.getText().toString().length() > 0 &&
                        password.getText().toString().length() > 0) {
                    Toast.makeText(getApplicationContext(), "Регистрация выполнена. Используйте свой аккаунт для входа.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(reg.this, login.class);
                    startActivity(intent);
                } else {
                    builder1.setTitle("Error");
                    builder1.setMessage("Неправильно введены почта или пароль.");
                    builder1.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
                    builder1.create().show();
                }
            }
        });
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}