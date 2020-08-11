package com.hobbyappgame.retrofit.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hobbyappgame.retrofit.R;

import java.util.ArrayList;

public class ModeloDelHolder extends RecyclerView.Adapter<ModeloDelHolder.ViewHolder> {

    private ArrayList<GetBebes> mGetBebes;

    public ModeloDelHolder(ArrayList<GetBebes> getBebes) {
        mGetBebes = getBebes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mTextView.setText(mGetBebes.get(position).getIdNombre());

    }

    @Override
    public int getItemCount() {
        return mGetBebes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.txt1);
        }
    }

}
