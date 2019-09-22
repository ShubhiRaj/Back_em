package com.example.backem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;

public class Successfull extends AppCompatActivity {
    public static String name;
    public static String amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfull);

        name = Form.name;
        amt = Form.amt;
        System.out.println("name = " + name);
        System.out.println("amt = " + amt);
        new SendMoney().execute();
    }
}

class SendMoney extends AsyncTask<String, Integer, Boolean> {

    Vector<String> names = new Vector<>();

    @Override
    protected Boolean doInBackground(String... strings) {
        return query();
    }

    public boolean query() {
        //network operations cannot be run on the main thread!
        try {
            URL myurl = new URL("https://back-em.firebaseio.com/" + Successfull.name + ".json");
            HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
            con.setRequestMethod("PATCH");
            //con.setRequestProperty("x-api-key", "NcRCerhihE2lqZ9taSkCt2CM4NaOkAe35gw4mOWU");
            con.setDoOutput(true);
            con.setDoInput(true);

            JSONObject body = new JSONObject();
            body.put("amount", Successfull.amt);
            Log.e("body",body.toString());
            OutputStreamWriter output = new OutputStreamWriter(con.getOutputStream());
            output.write(body.toString());
            output.flush();
            output.close();

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;


            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            System.out.println(responseStrBuilder);
            JSONObject object = new JSONObject(responseStrBuilder.toString());

            Log.e("Payment status",object.toString());
            System.out.println(object);
            return object.toString().contains("success");


        } catch (IOException | JSONException e) {
            return false;
        }
    }


    @Override
    protected void onPostExecute(Boolean result) {

}


}
