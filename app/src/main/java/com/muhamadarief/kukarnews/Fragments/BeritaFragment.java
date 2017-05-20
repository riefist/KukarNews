package com.muhamadarief.kukarnews.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.muhamadarief.kukarnews.Adapter.BeritaAdapter;
import com.muhamadarief.kukarnews.ApiInterface;
import com.muhamadarief.kukarnews.Model.Berita;
import com.muhamadarief.kukarnews.Model.BeritaItem;
import com.muhamadarief.tenggarongcity3.R;
import com.muhamadarief.kukarnews.Singleton.MySingleton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class BeritaFragment extends android.support.v4.app.Fragment {

    public final static String TAG = "BeritaFragment";
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<BeritaItem> newsList;

    public BeritaFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.recycler_view_frag, container, false);

        mRecyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //membuat service
        ApiInterface apiService = ApiInterface.client.create(ApiInterface.class);

        //Melakukan call dengan method getDataBerita
        Call<Berita> call = apiService.getDataBerita();

        //proses call
        call.enqueue(new Callback<Berita>() {
            @Override
            public void onResponse(Call<Berita> call, retrofit2.Response<Berita> response) {

                //merubah response body menjadi model
                Berita berita = response.body();

                //instance adapter dengan object Item (Berita.getItem)
            }

            @Override
            public void onFailure(Call<Berita> call, Throwable t) {

            }
        });

        /*String url = "http://kutaikartanegarakab.go.id/ws_portal_kukar/index.php/api/webservice/channeltitle_channelid/id/3";
       // String url = "http://192.168.14.2/ws_portal_kukar/index.php/api/webservice/channeltitle_channelid/id/3";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);

                            ArrayList<BeritaItem> newsList = new JsonConverter<BeritaItem>()
                                    .toArrayList(response, BeritaItem.class);

                                BeritaAdapter adapter = new BeritaAdapter(getActivity(), newsList);

                                mRecyclerView.setAdapter(adapter);
                            }



                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error != null){
                            Log.d(TAG, error.toString());
                            Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);

        */
        return rootview;
    }


}
