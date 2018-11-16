package com.studioabir.recyclerbanner.recyclearbanner;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.Holder> {


    private List<FacultyModel> facultylist;
    private Context context;

    public FacultyAdapter(List<FacultyModel> facultylist, Context context) {
        this.facultylist = facultylist;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_facul, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        holder.name.setText(facultylist.get(position).getName());
        holder.position.setText(facultylist.get(position).getPosition());

    }

    @Override
    public int getItemCount() {
        return facultylist.size();
    }



    //-------This method is for filtering data of recyclearviiew-----------///
    public void setfilter(List<FacultyModel> ditem)
    {
        facultylist = new ArrayList<>();
        facultylist.addAll(ditem);
        notifyDataSetChanged();
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