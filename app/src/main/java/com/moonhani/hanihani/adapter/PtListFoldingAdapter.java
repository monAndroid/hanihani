package com.moonhani.hanihani.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.moonhani.hanihani.R;
import com.moonhani.hanihani.model.Pt;
import com.ramotion.foldingcell.FoldingCell;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;

import utils.Basic;
import utils.Util;
//import com.monandroid.hanihani.AppController;

import static utils.Util.VMGetJsonArr;
import static utils.Util.VMGetJsonObj;
import static utils.Util.VMNetImageReq;
import static utils.Util.VMPostJsonArr;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class PtListFoldingAdapter extends ArrayAdapter<Pt> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    //private View.OnClickListener defaultRequestBtnClickListener;

    public PtListFoldingAdapter(Context context, List<Pt> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get pt for selected view
        Pt pt = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.pt_cell, parent, false);
            // binding view parts to view holder
            viewHolder.name = (TextView) cell.findViewById(R.id.title_name);
            viewHolder.name2 = (TextView) cell.findViewById(R.id.title_name2);
            viewHolder.sex = (TextView) cell.findViewById(R.id.title_sex_label);
            viewHolder.age = (TextView) cell.findViewById(R.id.title_age_label);
            viewHolder.FirstDate = (TextView) cell.findViewById(R.id.title_from_address);
            viewHolder.lastDate = (TextView) cell.findViewById(R.id.title_to_address);
            viewHolder.visitCount = (TextView) cell.findViewById(R.id.title_requests_count);
            viewHolder.birth = (TextView) cell.findViewById(R.id.title_pledge);
            viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        // bind data from selected element to view through view holder
        viewHolder.name.setText(pt.getName());
        viewHolder.name2.setText(pt.getName() + "(" + pt.getAge() + "/" + pt.getSex() + ")");
        viewHolder.sex.setText(pt.getSex());
        viewHolder.age.setText(pt.getAge());
        viewHolder.FirstDate.setText(pt.getFirstDate());
        viewHolder.lastDate.setText(pt.getLastDate());
        viewHolder.visitCount.setText(String.valueOf(pt.getVisitCount()));
        viewHolder.birth.setText(pt.getBirth());
/*
        // set custom btn handler for list pt from that pt
        if (pt.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(pt.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in pt
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }
*/

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }
    /*
        public View.OnClickListener getDefaultRequestBtnClickListener() {
            return defaultRequestBtnClickListener;
        }

        public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
            this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
        }
    */
    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView name2;
        TextView contentRequestBtn;
        TextView birth;
        TextView FirstDate;
        TextView lastDate;
        TextView visitCount;
        TextView age;
        TextView sex;
    }

}