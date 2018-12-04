package com.khai.khailqph05639_mob201_assignment.news;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.khai.khailqph05639_mob201_assignment.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewActivity extends AppCompatActivity {
    private ListView listView;
    CustomAdapter cursorAdapter;
    ArrayList<Read> listRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        listView = findViewById(R.id.lvListView);
        listRead = new ArrayList<Read>();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifi = networkInfo.isConnected();
        // boolean isMobile = networkInfo.isConnected();
        if(isWifi){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new ReadData().execute("http://vietnamnet.vn/rss/home.rss");
                }
            });
        }else{
           // Toast.makeText(this, "Wifi is not connected", Toast.LENGTH_SHORT).show();
        }

        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobile = networkInfo.isConnected();
        if(isMobile){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new ReadData().execute("http://vietnamnet.vn/rss/home.rss");
                }
            });
        }else{
           //Toast.makeText(this, "3G is not connected", Toast.LENGTH_SHORT).show();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewActivity.this,Main2Activity.class);
                intent.putExtra("link",listRead.get(position).link);
                startActivity(intent);
            }
        });
    }
    private class ReadData extends AsyncTask<String,Integer,String> {

        @Override
        protected String doInBackground(String... params) {
            return readnoidungURL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDomParser parser = new XMLDomParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeListdescription = document.getElementsByTagName("description");
            String title = "";
            String link ="";
            String hinhanh ="";
            for(int i=0;i<nodeList.getLength();i++){
                String cdata = nodeListdescription.item(i + 1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cdata);
                if(matcher.find()){
                    hinhanh = matcher.group(1);
                }
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element,"title");
                link = parser.getValue(element,"link");

                listRead.add(new Read(title,link,hinhanh));
            }
            cursorAdapter=new CustomAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listRead);
            listView.setAdapter(cursorAdapter);
            super.onPostExecute(s);
        }
    }
    private static String readnoidungURL(String theUrl){
        StringBuilder content =  new StringBuilder();
        try{
            // create a url object
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlConnection in a bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }
}
