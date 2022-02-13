package com.example.api_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    private static final String url="http://192.168.100.16/android/fetch.php";
    List<fetch> fetchs;
    RecyclerView RV;
    myAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        RV = findViewById(R.id.rc1);
        fetchs = new ArrayList<>();
        extractFetch();




//        String arr[] = {"as","asd","fdf"};
//        RV.setAdapter(new myAdapter(arr));


    }

    private void extractFetch() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        fetch f = new fetch();
                        f.setData(jsonObject.getString("data").toString());
                        f.setSomething(jsonObject.getString("something").toString());
                        fetchs.add(f);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                RV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new myAdapter(getApplicationContext(), fetchs);
                RV.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "err "+error.getMessage());

            }
        });
        queue.add(jsonArrayRequest);
    }
}