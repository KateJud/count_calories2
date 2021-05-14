package com.example.dietstram;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dietstram.database.DBAdapter;
import com.example.dietstram.ui.signup.SignUp;

public class RegistrationActivity extends AppCompatActivity {
    private Button buttonSignIn;

    private TextView textViewRegister;
    private TextView textViewError;

    private EditText editTextPassword;
    private EditText editTextNickName;

    private void setAllWidgets() {
        buttonSignIn = findViewById(R.id.buttonSignIn);

        textViewRegister = findViewById(R.id.textViewRegister);

        textViewError = findViewById(R.id.textViewError);

        editTextPassword = findViewById(R.id.editTextPassword);
        editTextNickName = findViewById(R.id.editTextNickName);

    buttonSignIn.setEnabled(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setAllWidgets();


        //Имя должно быть уникальным (но при входе лбое не пустое)
        editTextNickName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                String currentPassword = editTextNickName.getText().toString();
                if (currentPassword.isEmpty()) {
                    buttonSignIn.setEnabled(false);
                } else {
                    if (!editTextPassword.getText().toString().isEmpty()) {
                        buttonSignIn.setEnabled(true);
                    }
                }
            }
        });

        //Пароль мб каким угодно но не пустым
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String currentPassword = editTextPassword.getText().toString();
                if (currentPassword.isEmpty()) {
                    buttonSignIn.setEnabled(false);
                } else {
                    if (!editTextNickName.getText().toString().isEmpty()) {
                        buttonSignIn.setEnabled(true);
                    }
                }
            }
        });

        final Context context = this;

        //Вход (проверяем в таблице users и пишем в users_in)
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DBAdapter db = new DBAdapter(context);
                db.open();


                String nickNameSQL = db.quoteSmart(editTextNickName.getText().toString());
                String passwordSQL = db.quoteSmart(editTextPassword.getText().toString());
                String[] fields = {"_id"};
                String[] fieldsWhere = {
                    "user_nickname",
                    "user_password"
                };

                String[] valuesWhere = {
                    nickNameSQL,
                    passwordSQL
                };
                String[] andOr = {
                    "AND"
                };
                Cursor cursorUser = db.select("users", fields, fieldsWhere, valuesWhere, andOr);
                if (cursorUser.getCount() == 0) {
                    textViewError.setText(R.string.error_nickname_or_password);
                    db.close();
                    return;
                }

                //Current user (in global table 'users') id
                String id=cursorUser.getString(0);
                MainActivity.USER_ID =id;
                String idSQL=db.quoteSmart(id);
                String values =idSQL+","+ nickNameSQL + "," + passwordSQL;

                db.insert("users_in", "users_i_id,users_i_nickname, users_i_password", values);

                db.close();
            }
        });


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, SignUp.class);
                startActivity(intent);
            }
        });


    }
}