package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {


    ListView listView;
    Button btn;

    private ArrayList<String> arrayList = new ArrayList<String>();

    private void checkbox_selection() {
        arrayList.add("Location");
        arrayList.add("Internet");
        arrayList.add("Camera");
        arrayList.add("Gallery");

    }

    myArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        checkbox_selection();
        listView = (ListView) findViewById(R.id.lv_listview);

        adapter = new myArrayAdapter(
                this,
                R.layout.list_row,
                android.R.id.text1,
                arrayList
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        btn = (Button) findViewById(R.id.btn_show_me);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";

                List<String> resultList = adapter.getCheckedItems();
                for (int i = 0; i < resultList.size(); i++) {
                    result += String.valueOf(resultList.get(i)) + "\n";
                }

                adapter.getCheckedItemPositions().toString();

                if (result.matches("")) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Select some thing from the list",
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent i1 = new Intent(getApplicationContext(),MainActivity4.class);

                    startActivity(i1);

 }
            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        adapter.rkt_toggleChecked(i);
    }

    public class myArrayAdapter extends ArrayAdapter<String> {

        private HashMap<Integer, Boolean> myChecked = new HashMap<Integer, Boolean>();

        public myArrayAdapter(Context context, int resource,
                               int textViewResourceId, List<String> objects) {
            super(context, resource, textViewResourceId, objects);

            for (int i = 0; i < objects.size(); i++) {
                myChecked.put(i, false);
            }
        }

        public void rkt_toggleChecked(int position) {
            if (myChecked.get(position)) {
                myChecked.put(position, false);
            } else {
                myChecked.put(position, true);
            }

            notifyDataSetChanged();
        }

        public List<Integer> getCheckedItemPositions() {
            List<Integer> checkedItemPositions = new ArrayList<Integer>();

            for (int i = 0; i < myChecked.size(); i++) {
                if (myChecked.get(i)) {
                    (checkedItemPositions).add(i);
                }
            }

            return checkedItemPositions;
        }

        public List<String> getCheckedItems() {
            List<String> checkedItems = new ArrayList<String>();

            for (int i = 0; i < myChecked.size(); i++) {
                if (myChecked.get(i)) {
                    (checkedItems).add(arrayList.get(i));
                }
            }

            return checkedItems;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.list_row, parent, false);
            }

            CheckedTextView checked_TextView = (CheckedTextView) row.findViewById(R.id.checked_textview);
            checked_TextView.setText(arrayList.get(position));

            Boolean checked = myChecked.get(position);
            if (checked != null) {
                checked_TextView.setChecked(checked);
            }

            return row;
        }

    }


}