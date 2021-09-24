package com.example.newsupdates.CustomAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsupdates.R;
import com.example.newsupdates.ResponseNews;
import com.example.newsupdates.ViewClass.parentViewClass;

import java.util.List;

public class CustomAdapterParent extends RecyclerView.Adapter<CustomAdapterParent.ParentViewHolder> {
    private RecyclerView.RecycledViewPool
            viewPool
            = new RecyclerView
            .RecycledViewPool();
    private List<parentViewClass> list;
    private Activity activity;


    public CustomAdapterParent(Activity activity,List<parentViewClass> list) {
        this.activity=activity;
        this.list = list;

    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_news,viewGroup,false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int position) {
        parentViewClass parentView=list.get(position);
        parentViewHolder.textView.setText(parentView.getCategory().toUpperCase()+"->");
        LinearLayoutManager layoutManager=new LinearLayoutManager(parentViewHolder.ChildRecyclerView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setInitialPrefetchItemCount(parentView.getChildList().size());

        CustomAdapterChild adapterChild=new CustomAdapterChild(activity,parentView.getChildList());
        parentViewHolder.ChildRecyclerView.setLayoutManager(layoutManager);
        parentViewHolder.ChildRecyclerView.setAdapter(adapterChild);
        parentViewHolder.ChildRecyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ParentViewHolder extends RecyclerView.ViewHolder  {
        private TextView textView;
        private RecyclerView ChildRecyclerView;
        public ParentViewHolder(final View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.textView4);
            ChildRecyclerView= itemView.findViewById(R.id.child_recyclerview);
        }


    }
}
