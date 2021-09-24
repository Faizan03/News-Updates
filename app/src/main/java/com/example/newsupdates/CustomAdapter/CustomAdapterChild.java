package com.example.newsupdates.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsupdates.R;
import com.example.newsupdates.ViewClass.ChildViewClass;
import com.example.newsupdates.webView.WebViewActivity;

import java.util.List;

public class CustomAdapterChild  extends RecyclerView.Adapter<CustomAdapterChild.ChildViewHolder>{

        List<ChildViewClass> ChildList;
        Activity activity;
        public static final String WEB_URL="NewsUpdates.URI";

        public CustomAdapterChild(Activity activity,List<ChildViewClass> list) {
            this.ChildList = list;
            this.activity = activity;
        }

        @NonNull
        @Override
        public CustomAdapterChild.ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_child,parent,false);
            return new ChildViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomAdapterChild.ChildViewHolder childViewHolder, int position) {
            ChildViewClass childView=ChildList.get(position);
            childViewHolder.textView3.setText(childView.getTitle());
            childViewHolder.textView7.setText(childView.getDate());
           try {
               Glide.with(childViewHolder.itemView.getContext()).load(childView.getImage()).into(childViewHolder.imageView);
           }catch (Exception e){

           }
        }

        @Override
        public int getItemCount() {
            return ChildList.size();
        }


        public class ChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView imageView;
            TextView textView3;
            TextView textView7;
            CardView cardView;
            public ChildViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView= itemView.findViewById(R.id.newsImage);
                textView3=itemView.findViewById(R.id.child_item_title);
                textView7=itemView.findViewById(R.id.child_item_date);
                cardView=itemView.findViewById(R.id.cardView);
               itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
               int position=getAdapterPosition();
              String Url=ChildList.get(position).getUrl();
               Intent in=new Intent(activity,WebViewActivity.class);
               in.putExtra(WEB_URL,Url);
               activity.startActivity(in);
            }
        }


}


