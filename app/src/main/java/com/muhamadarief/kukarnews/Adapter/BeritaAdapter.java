package com.muhamadarief.kukarnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhamadarief.kukarnews.Activities.DetailNewsActivity;
import com.muhamadarief.kukarnews.Model.BeritaItem;
import com.muhamadarief.tenggarongcity3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Muhamad Arief on 21/07/2016.
 */
public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.NewsViewHolder> {

    private Context context;
    private ArrayList<BeritaItem> news;

    public BeritaAdapter(Context context, ArrayList<BeritaItem> news){
        this.context = context;
        this.news = news;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        NewsViewHolder newsViewHolder = new NewsViewHolder(v);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final BeritaItem newsItem = news.get(position);


       String fullUrl = "http://kutaikartanegarakab.go.id/images/news/" +newsItem.field_id_3;
        Picasso.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.ic_thumbnail)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.icon);


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
        public ImageView icon;
        public TextView title;
        public TextView day;
        public TextView month;
        public TextView year;

        public NewsViewHolder(View itemView) {
            super(itemView);
            cvItem = (CardView) itemView.findViewById(R.id.cv);
            title = (TextView) itemView.findViewById(R.id.news_title);
            icon = (ImageView) itemView.findViewById(R.id.news_image);
        //    entry_id = (TextView) itemView.findViewById(R.id.entry_id);
            day = (TextView) itemView.findViewById(R.id.day);
            month = (TextView) itemView.findViewById(R.id.month);
            year = (TextView) itemView.findViewById(R.id.year);

        }
    }
}
