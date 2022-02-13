package com.example.api_practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class loginActivity extends AppCompatActivity {

    private static final String url="http://192.168.100.16/android/login.php";
    EditText susername, spassword;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        susername = findViewById(R.id.lusername);
        spassword = findViewById(R.id.lpassword);
        login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(susername.getText().toString(), spassword.getText().toString());
            }
        });

    }
    public void loginUser(final String username, final String pass){
        if(!username.equals("") && !pass.equals("")) {
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                        Intent i1 = new Intent(loginActivity.this, WelcomeActivity.class);
                        startActivity(i1);
//                        finish();
                    } else if (response.equals("failure")) {
                        Toast.makeText(getApplicationContext(), "Invalid login", Toast.LENGTH_SHORT).show();
                    }else{
                        susername.setText("");
                        spassword.setText("");
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    susername.setText("");
                    spassword.setText("");
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<String, String>();

                    data.put("username", username);
                    data.put("password", pass);

                    return data;
                }
            };
            RequestQueue queue2 = Volley.newRequestQueue(getApplicationContext());
            queue2.add(request);

        }

    }

}