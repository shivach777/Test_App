package com.example.test_app;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;




public class Register extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = Register.this;
    private NestedScrollView nestedScrollView;


    private EditText textInputEditTextName;
    private EditText textInputEditTextEmail;
    private EditText textInputEditTextPassword;
    private EditText textInputEditTextConfirmPassword;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;


    

    //private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private user user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        initViews();
        initListeners();
        initObjects();
    }

    @SuppressLint("WrongViewCast")
    private void initViews() {

        textInputEditTextName = (EditText) findViewById(R.id.editTextUserName);
        textInputEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        textInputEditTextPassword = (EditText) findViewById(R.id.editTextPwd);
        textInputEditTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPwd);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.btnRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.lnkLogin);

    }


    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }
    private void initObjects() {
     //   inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(this);
        user = new user();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnRegister:
                postDataToSQLite();
                break;
/*
            case R.id.lnkLogin:
                finish();
                break;*/
        }
    }

    private void postDataToSQLite() {

        if (!databaseHelper.checkUser(textInputEditTextEmail.toString().trim())) {

            user.setName(textInputEditTextName.toString().trim());
            user.setEmail(textInputEditTextEmail.toString().trim());
            user.setPassword(textInputEditTextPassword.toString().trim());
            user.setConfirmpassword(textInputEditTextConfirmPassword.toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
          //  Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
        //     Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }

    }
    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }
}
