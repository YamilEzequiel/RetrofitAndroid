package com.hobbyappgame.retrofit.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hobbyappgame.retrofit.R;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {

    private ArrayList<GetBebes> mPosts;
    private Context mContext;

    public AdapterRecycler(ArrayList<GetBebes> posts, Context context) {
        mPosts = posts;
        mContext = context;
    }

    @NonNull
    @Override
    public AdapterRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt1.setText(mPosts.get(position).getIdNombre());
        holder.txt2.setText(mPosts.get(position).getGenero());
        holder.txt3.setText(mPosts.get(position).getNombre());
        holder.txt4.setText(mPosts.get(position).getDescEs());
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txt1,txt2,txt3,txt4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1=itemView.findViewById(R.id.txt1);
            txt2=itemView.findViewById(R.id.txt2);
            txt3=itemView.findViewById(R.id.txt3);
            txt4=itemView.findViewById(R.id.txt4);
        }

    }


}
