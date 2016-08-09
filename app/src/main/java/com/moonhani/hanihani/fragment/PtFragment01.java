package com.moonhani.hanihani.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.moonhani.hanihani.R;
import com.moonhani.hanihani.adapter.PtListFoldingAdapter;
import com.moonhani.hanihani.model.Pt;
import com.ramotion.foldingcell.FoldingCell;

public class PtFragment01 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pt_01, null);

        // get our list view
        ListView theListView = (ListView) view.findViewById(R.id.listView_pt);

        // prepare elements to display
        final ArrayList<Pt> pts = Pt.getTestingList();
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
        final PtListFoldingAdapter adapter = new PtListFoldingAdapter(getContext(), pts);
/*
        // add default btn handler for each request btn on each pt if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });
*/
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

        return view;

    }
}
