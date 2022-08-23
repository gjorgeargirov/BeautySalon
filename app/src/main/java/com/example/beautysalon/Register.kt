package com.example.beautysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var register = findViewById<Button>(R.id.create_account)
        var login = findViewById<Button>(R.id.login_button)
        var email = findViewById<EditText>(R.id.email_register)
        var password = findViewById<EditText>(R.id.password_register)

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

        register.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?) {
                is_valid_email(email);
                is_valid_password(password);
                if(emailValidation && passwordValidation) {
                    val i = Intent(this@Register, LogIn::class.java)
                    startActivity(i)
                }
            }})

        login.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?) {
                val i = Intent(this@Register, LogIn::class.java)
                startActivity(i)
            }
        })
    }
}