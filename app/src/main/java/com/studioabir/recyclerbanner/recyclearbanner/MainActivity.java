package com.studioabir.recyclerbanner.recyclearbanner;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MultiSnapRecyclerView recyclerView;
    MultiSnapRecyclerView recyclerView1;
    MultiSnapRecyclerView recyclerView2;

    List<FacultyModel> facultyalllist;
    FacultyAdapter fadapter;

    List<AdminModel> adminalllist;
    AdminAdapter aadapter;

    List<FacultyModel> facultyalllist1;
    FacultyAdapter fadapter1;

    String url,url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///----for one recyclear----//
        recyclerView = findViewById(R.id.first_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        ////----for second Recyclear----/
        recyclerView1 = findViewById(R.id.second_recycler_view);
        recyclerView1.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);


        ////----for second Recyclear----/
        recyclerView2 = findViewById(R.id.third_recycler_view);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);




        facultyalllist = new ArrayList<>();
        adminalllist = new ArrayList<>();
        facultyalllist1 = new ArrayList<>();

        url = getString(R.string.urltouse)+"Facultiesall.php";
        url2 = getString(R.string.urltouse)+"administration.php";

        loadfacultydata();
        LOAD2();
        loadfacultydata1();

    }

    public void loadfacultydata() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    facultyalllist.clear();
                    JSONArray jsonarray = new JSONArray(response);
                    for(int i=0; i < jsonarray.length(); i++)
                    {

                        JSONObject object = jsonarray.getJSONObject(i);
                        facultyalllist.add(new FacultyModel(

                                object.getString("Name"),
                                object.getString("Position"),
                                object.getString("Department"),
                                object.getString("Email"),
                                object.getString("Phone")
                        ));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                fadapter = new FacultyAdapter(facultyalllist, MainActivity.this);
                recyclerView.setAdapter(fadapter);
                fadapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        com.studioabir.recyclerbanner.recyclearbanner.AppController.getInstance().addToRequestQueue(stringRequest);
    }


    public void LOAD2() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    adminalllist.clear();
                    JSONArray jsonarray = new JSONArray(response);
                    for(int i=0; i < jsonarray.length(); i++)
                    {

                        JSONObject object = jsonarray.getJSONObject(i);
                        adminalllist.add(new AdminModel(

                                object.getString("name"),
                                object.getString("designation")

                        ));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                aadapter = new AdminAdapter(adminalllist, MainActivity.this);
                recyclerView1.setAdapter(aadapter);
                aadapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        com.studioabir.recyclerbanner.recyclearbanner.AppController.getInstance().addToRequestQueue(stringRequest);
    }


    public void loadfacultydata1() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    facultyalllist1.clear();
                    JSONArray jsonarray = new JSONArray(response);
                    for(int i=0; i < jsonarray.length(); i++)
                    {

                        JSONObject object = jsonarray.getJSONObject(i);
                        facultyalllist1.add(new FacultyModel(

                                object.getString("Name"),
                                object.getString("Position"),
                                object.getString("Department"),
                                object.getString("Email"),
                                object.getString("Phone")
                        ));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                fadapter1 = new FacultyAdapter(facultyalllist, MainActivity.this);
                recyclerView2.setAdapter(fadapter1);
                fadapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        com.studioabir.recyclerbanner.recyclearbanner.AppController.getInstance().addToRequestQueue(stringRequest);
    }



}
