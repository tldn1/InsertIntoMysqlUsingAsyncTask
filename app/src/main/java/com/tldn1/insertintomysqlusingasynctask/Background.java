package com.tldn1.insertintomysqlusingasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by X on 12/28/2016.
 */

public class Background extends AsyncTask<String,String,String>{
    Context context;

    public Background(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String name = strings[0];
        String number = strings[1];
        String server_url = "http://10.0.3.2/Contacts/addContact.php";
        String data = "";
        String urlParams = "name="+name+"&number="+number;

        try {
            URL url = new URL(server_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(urlParams.getBytes());
            os.flush();
            os.close();
            int tmp;
            InputStream is = httpURLConnection.getInputStream();
            while((tmp=is.read())!=-1){
                data+=(char)tmp;
            }
            httpURLConnection.disconnect();
            is.close();
            return data;


        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "Contact is successfully added!", Toast.LENGTH_SHORT).show();
    }
}
