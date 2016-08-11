package com.moonhani.hanihani.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moonhani.hanihani.R;
import com.moonhani.hanihani.adapter.PtListFoldingAdapter;
import com.moonhani.hanihani.model.Pt;
import com.ramotion.foldingcell.FoldingCell;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.Basic;
import utils.Util;

public class PtFragment03 extends Fragment {

    private String url_ptList = "http://112.133.112.77:3333/patientsByState";
    ListView theListView;
    View view;
    JSONObject params;
    Gson gson;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pt_03, null);
        //resultTxt = (TextView) view.findViewById(R.id.resultTxt);

        // get our list view
        theListView = (ListView) view.findViewById(R.id.listView_pt_03);


        gson = new Gson();

        String data = "{\"date\":\"20160811\", \"type\":\"state3\"}";

        try {
            params = new JSONObject(data);
        } catch (JSONException e) {

        }

        //pts = Pt.getTestingList();

        Util.VMPostJsonArr(url_ptList, params, getContext(), new Util.VMCallback_JSONArr() {
            //Util.VMGetJsonArr(url_ptList, getContext(), new  Util.VMCallback_JSONArr()  {
            @Override
            public void onSuccess(JSONArray response) {

                ArrayList<Pt> pts = gson.fromJson(response.toString(), new TypeToken<List<Pt>>() { }.getType());

                // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
                final PtListFoldingAdapter adapter = new PtListFoldingAdapter(getContext(), pts);

                // set elements to adapter
                theListView.setAdapter(adapter);

                // set on click event listener to list view
                theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                        // toggle clicked cell state
                        ((FoldingCell) view).toggle(false);
                        // register in adapter that state for selected cell is toggled
                        adapter.registerToggle(pos);
                    }
                });

            }
        });


        // prepare elements to display
        //final ArrayList<Pt> pts = Pt.getTestingList();


        //ArrayList<Pt> pts = Pt.getTestingList();



/*
        // add custom btn handler to first list pt
        pts.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
            }
        });
*/
        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        //final PtListFoldingAdapter adapter = new PtListFoldingAdapter(getContext(), pts);
/*
        // add default btn handler for each request btn on each pt if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });
*/
        return view;

    }
}
