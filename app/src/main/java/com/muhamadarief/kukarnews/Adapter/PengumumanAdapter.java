package com.muhamadarief.kukarnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhamadarief.kukarnews.Activities.DetailNewsActivity;
import com.muhamadarief.kukarnews.Model.BeritaItem;
import com.muhamadarief.tenggarongcity3.R;

import java.util.ArrayList;

/**
 * Created by Muhamad Arief on 21/07/2016.
 */
public class PengumumanAdapter extends RecyclerView.Adapter<PengumumanAdapter.NewsViewHolder> {

    private Context context;
    private ArrayList<BeritaItem> news;

    public PengumumanAdapter(Context context, ArrayList<BeritaItem> news){
        this.context = context;
        this.news = news;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.from(parent.getContext())
                .inflate(R.layout.fragment_pengumuman, parent, false);

        NewsViewHolder newsViewHolder = new NewsViewHolder(v);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final BeritaItem newsItem = news.get(position);

        holder.title.setText(newsItem.title);
      //  holder.entry_id.setText("" + newsItem.entry_id);
        holder.day.setText(newsItem.day);
        holder.month.setText(newsItem.month);
        holder.year.setText(newsItem.year);


        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailNewsActivity.class);
                i.putExtra("news", newsItem);
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if( news != null){
            return news.size();
        }
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        public CardView cvItem;
        public TextView title;
        public TextView day;
        public TextView month;
        public TextView year;

        public NewsViewHolder(View itemView) {
            super(itemView);
            cvItem = (CardView) itemView.findViewById(R.id.cv);
            title = (TextView) itemView.findViewById(R.id.news_title);
        //    entry_id = (TextView) itemView.findViewById(R.id.entry_id);
            day = (TextView) itemView.findViewById(R.id.day);
            month = (TextView) itemView.findViewById(R.id.month);
            year = (TextView) itemView.findViewById(R.id.year);

        }
    }
}
