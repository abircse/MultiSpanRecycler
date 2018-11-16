package com.studioabir.recyclerbanner.recyclearbanner;


import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.Holder> {


    private List<AdminModel> adminlist;
    private Context context;

    public AdminAdapter(List<AdminModel> facultylist, Context context) {
        this.adminlist = facultylist;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_admin, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        holder.name.setText(adminlist.get(position).getName());
        holder.position.setText(adminlist.get(position).getPosition());


    }

    @Override
    public int getItemCount() {
        return adminlist.size();
    }



    class Holder extends RecyclerView.ViewHolder
    {

        TextView name;
        TextView position;

        Holder(View fview)
        {
            super(fview);

            name = fview.findViewById(R.id.name);
            position = fview.findViewById(R.id.position);

        }


    }
}