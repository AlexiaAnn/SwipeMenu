package com.example.alexiaann.swipemenu.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexiaann.swipemenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexiaAnn on 2016/8/19 0019.
 */
public class CustomRecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<String> lists;
    private LayoutInflater inflater;

    public CustomRecycleViewAdapter(Context context,List<String> lists) {

        mContext = context;
        this.lists = (lists!=null ?lists:new ArrayList<String>());
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_single_textview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.showData);
    }
}
