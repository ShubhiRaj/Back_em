package com.example.backem;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TableRow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Vector;

public class Form extends AppCompatActivity {

    public static String name;
    public static String amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = findViewById(R.id.toolbar);
        final MaterialButton search = findViewById(R.id.search_button);
        setSupportActionBar(toolbar);

        final TextInputEditText nameInput = findViewById(R.id.name);
        final TextInputEditText amtInput = findViewById(R.id.amt);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                name = nameInput.getText().toString();
                amt = amtInput.getText().toString();

                System.out.println("name = " + name);
                System.out.println("amt = " + amt);

                Intent intent = new Intent(Form.this, Successfull.class);
                startActivity(intent);
            }
        });

        /*search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setVisibility(View.INVISIBLE);
                new Search().execute();


            }
        });*/
    }


    class Search extends AsyncTask<String, Integer, Boolean> {

        Vector<String> names = new Vector<>();

        @Override
        protected Boolean doInBackground(String... strings) {
            return query();
        }

        public boolean query() {
            //network operations cannot be run on the main thread!
            try {
                URL myurl = new URL("https://back-em.firebaseio.com/.json");
                HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
                con.setRequestMethod("GET");
                //con.setRequestProperty("x-api-key", "NcRCerhihE2lqZ9taSkCt2CM4NaOkAe35gw4mOWU");
                //con.setDoOutput(true);
                con.setDoInput(true);

                BufferedReader streamReader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;


                while ((inputStr = streamReader.readLine()) != null)
                    responseStrBuilder.append(inputStr);
                System.out.println(responseStrBuilder);
                JSONObject object = new JSONObject(responseStrBuilder.toString());
                Iterator<String> iter = object.keys();



                while(iter.hasNext()){
                    String key = iter.next();
                        System.out.println("\nNEW: " + key);
                        names.add(key);
                }
                Log.e("Payment status",object.toString());
                System.out.println(object);
                return object.toString().contains("success");


            } catch (IOException | JSONException e) {
                return false;
            }
        }

       /* private final String[] countries = new String[]{
                "Afg","alb","alg"
        };
        Spinner spinner = findViewById(R.id.spinner);*/

        @Override
        protected void onPostExecute(Boolean result) {


           /* spinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Form.this,
                    android.R.layout.simple_spinner_item, names);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);*/

            /*// Get a reference to the AutoCompleteTextView in the layout
            AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);

// Create the adapter and set it to the AutoCompleteTextView
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(Search.this, android.R.layout.simple_list_item_1, countries);
            textView.showDropDown();
            textView.setAdapter(adapter);*/


    }
    }


}


