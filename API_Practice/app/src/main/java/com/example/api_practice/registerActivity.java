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

public class registerActivity extends AppCompatActivity {

    private static final String url="http://192.168.100.16/android/register.php";
    EditText susername, spassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        susername = findViewById(R.id.username1);
        spassword = findViewById(R.id.password1);
        register = findViewById(R.id.register1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(susername.getText().toString(), spassword.getText().toString());
            }
        });
    }

    public void registerUser(final String username, final String pass) {
        if (!username.equals("") && !pass.equals("")) {
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    susername.setText("");
                    spassword.setText("");
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
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
                    Map<String, String> map = new HashMap<String, String>();

                    map.put("username", username);
                    map.put("password", pass);

                    return map;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(request);


        } else {
            Toast.makeText(getApplicationContext(), "r", Toast.LENGTH_LONG).show();
        }
    }
}