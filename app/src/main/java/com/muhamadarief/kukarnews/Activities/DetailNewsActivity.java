package com.muhamadarief.kukarnews.Activities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.muhamadarief.kukarnews.Model.BeritaItem;
import com.muhamadarief.tenggarongcity3.R;
import com.muhamadarief.kukarnews.Singleton.MySingleton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailNewsActivity extends AppCompatActivity {

    public static final String TAG = "DetailNewsActivity";
    TextView judul,  day, month, year, link;
    WebView field_1;
    ImageView image_news;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Portal Kukar");

        image_news = (ImageView) findViewById(R.id.image_news);
        judul = (TextView) findViewById(R.id.judul);
        day = (TextView) findViewById(R.id.day);
        month = (TextView) findViewById(R.id.month);
        year = (TextView) findViewById(R.id.year);
        field_1 = (WebView) findViewById(R.id.field_1);
        link = (TextView) findViewById(R.id.link);

        if(getIntent().getSerializableExtra("news") != null){
            final BeritaItem newsItem = (BeritaItem)getIntent().getSerializableExtra("news");

            String fullUrl = "http://kutaikartanegarakab.go.id/images/news/" +newsItem.field_id_3;
            Picasso.with(context)
                    .load(fullUrl)
                    .placeholder(R.drawable.ic_thumbnail)
                    .error(R.drawable.nav_header)
                    .into(image_news);

            judul.setText(newsItem.title);
            day.setText(newsItem.day);
            month.setText(newsItem.month);
            year.setText(newsItem.year);

            String url = "http://kutaikartanegarakab.go.id/ws_portal_kukar/index.php/api/webservice/channeldata_entryid/id/" +newsItem.entry_id;

            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d(TAG, response);

                            ArrayList<BeritaItem> newsList = new JsonConverter<BeritaItem>()
                                    .toArrayList(response, BeritaItem.class);

                            //test output result
                            String channel_id = "";
                            String paragrag1 = "";
                            String paragrag2 = "";
                            String paragrag9 = "";
                            String paragrag10 = "";
                            String paragrag12 = "";
                            String paragrag17 = "";
                            String paragrag18 = "";

                            for(BeritaItem p: newsList){
                                channel_id += p.channel_id;
                                paragrag1 += p.field_id_1;
                                paragrag2 += p.field_id_2;
                                paragrag9 += p.field_id_9;
                                paragrag10 += p.field_id_10;
                                paragrag12 += p.field_id_12;
                                paragrag17 += p.field_id_17;
                                paragrag18 += p.field_id_18;

                            }

                            if (channel_id.equals("6")) {
                            field_1.setBackgroundColor(Color.parseColor("#ffffff"));
                            field_1.setFocusableInTouchMode(false);
                            field_1.setFocusable(false);
                            field_1.getSettings().setDefaultTextEncodingName("UTF-8");

                            WebSettings webSettings = field_1.getSettings();
                            Resources res = getResources();
                            int fontSize = 16;
                            webSettings.setDefaultFontSize(fontSize);

                            String mimeType = "text/html; charset=UTF-8";
                            String encoding = "utf-8";
                                String url = "http://kutaikartanegarakab.go.id/default/images/" +paragrag9.substring(11);

                            String htmlText4 = paragrag9.substring(11);
                            String htmlText5 = paragrag12;

                            String text = "<html><head>"
                                    + "<style type=\"text/css\">body{color: #525252;}"
                                    + "</style></head>"
                                    + "<body>"
                                    + htmlText4 + "</br>"
                                    + htmlText5
                                    + "</body></html>";

                            field_1.loadData(text, mimeType, encoding);
                            link.setText(url);
                            }


                            else if ((channel_id.equals("8")) || (channel_id.equals("4"))){
                            field_1.setBackgroundColor(Color.parseColor("#ffffff"));
                            field_1.setFocusableInTouchMode(false);
                            field_1.setFocusable(false);
                            field_1.getSettings().setDefaultTextEncodingName("UTF-8");

                            WebSettings webSettings = field_1.getSettings();
                            Resources res = getResources();
                            int fontSize = 16;
                            webSettings.setDefaultFontSize(fontSize);

                            String mimeType = "text/html; charset=UTF-8";
                            String encoding = "utf-8";

                            String htmlText5 = paragrag10;
                            String htmlText7 = paragrag17;
                            String htmlText8 = paragrag18;

                            String text = "<html><head>"
                                    + "<style type=\"text/css\">body{color: #525252;}"
                                    + "</style></head>"
                                    + "<body>"
                                    + htmlText5
                                    + htmlText7 + "</br>"
                                    + htmlText8
                                    + "</body></html>";

                            field_1.loadData(text, mimeType, encoding);
                            }
                            else
                            {
                                field_1.setBackgroundColor(Color.parseColor("#ffffff"));
                                field_1.setFocusableInTouchMode(false);
                                field_1.setFocusable(false);
                                field_1.getSettings().setDefaultTextEncodingName("UTF-8");

                                WebSettings webSettings = field_1.getSettings();
                                Resources res = getResources();
                                int fontSize = 16;
                                webSettings.setDefaultFontSize(fontSize);

                                String mimeType = "text/html; charset=UTF-8";
                                String encoding = "utf-8";
                                String htmlText = paragrag1;
                                String htmlText2 = paragrag2;

                                String text = "<html><head>"
                                        + "<style type=\"text/css\">body{color: #525252;}"
                                        + "</style></head>"
                                        + "<body>"
                                        + htmlText
                                        + htmlText2
                                        + "</body></html>";
                                field_1.loadData(text, mimeType, encoding);}

                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG, error.toString());
                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_SHORT).show();
                        }
                    }


            );
            MySingleton.getInstance(getApplication()).addToRequestQueue(stringRequest);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
