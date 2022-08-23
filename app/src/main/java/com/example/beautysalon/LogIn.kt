package com.example.beautysalon

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        var register = findViewById<Button>(R.id.register)
        var login = findViewById<Button>(R.id.login)
        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.password)

        var emailValidation=false;
        var passwordValidation=false;

        fun isEmailValid(eMail: CharSequence): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(eMail)
                .matches();
        }

        fun is_valid_email(email: EditText) {
            if (email.text.toString().trim() == "") {
                email.error = "Enter e-mail";
                emailValidation=false;}
            else if (!isEmailValid(email.text.toString())) {
                email.error = "Invalid Email Address";
                emailValidation=false;}
            else if (isEmailValid(email.text.toString())) {
                emailValidation=true;}
        }

        fun is_valid_password(password: EditText) {
            if (password.text.toString().trim() == "") {
                password.error = "Enter password";
                passwordValidation=false;}
            else if (password.text.toString().length<6) {
                password.error = "Your password must contains 6 characters";
                passwordValidation=false;}
            else {
                passwordValidation=true;}
        }

        login.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?) {
                is_valid_email(email);
                is_valid_password(password);
                if(emailValidation && passwordValidation) {
                    val i = Intent(this@LogIn, FirstPage::class.java)
                    startActivity(i)
                }
            }})

        register.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?) {
                    val i = Intent(this@LogIn, Register::class.java)
                    startActivity(i)
                }
            })
    }
}