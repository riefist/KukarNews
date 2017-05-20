package com.muhamadarief.kukarnews.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.muhamadarief.kukarnews.Adapter.PengumumanAdapter;
import com.muhamadarief.kukarnews.Model.BeritaItem;
import com.muhamadarief.tenggarongcity3.R;
import com.muhamadarief.kukarnews.Singleton.MySingleton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformasiFragment extends Fragment {

    public final static String TAG = "InformasiFragment";
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<BeritaItem> newsList;

    public InformasiFragment() {
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

        String url = "http://kutaikartanegarakab.go.id/ws_portal_kukar/index.php/api/webservice/channeltitle_channelid/id/4";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);

                        ArrayList<BeritaItem> newsList = new JsonConverter<BeritaItem>()
                                .toArrayList(response, BeritaItem.class);

                        PengumumanAdapter adapter = new PengumumanAdapter(getActivity(), newsList);

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


        return rootview;
    }

}
