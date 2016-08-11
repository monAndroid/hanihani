package com.moonhani.hanihani.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moonhani.hanihani.R;
import com.moonhani.hanihani.model.Pt;
import com.ramotion.foldingcell.FoldingCell;


import java.util.HashSet;
import java.util.List;

import utils.Basic;
import utils.Util;


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
        //Pt pt = getItem(position);
        Pt pt = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.pt_cell, parent, false);
            // binding view parts to view holder
            viewHolder.photo = (ImageView) cell.findViewById(R.id.pt_photo);
            viewHolder.name = (TextView) cell.findViewById(R.id.title_name);
            viewHolder.name2 = (TextView) cell.findViewById(R.id.title_name2);
            //viewHolder.sex = (TextView) cell.findViewById(R.id.title_sex);
            //viewHolder.age = (TextView) cell.findViewById(R.id.title_age);
            viewHolder.firstDate = (TextView) cell.findViewById(R.id.title_firstDate);
            viewHolder.lastDate = (TextView) cell.findViewById(R.id.title_lastDate);
            viewHolder.JTIME = (TextView) cell.findViewById(R.id.title_visitCount);
            viewHolder.ITYPE = (TextView) cell.findViewById(R.id.title_birth);
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
        Glide.with(getContext()).load(pt.getLastPic()).into(viewHolder.photo);
        //Glide.with(getContext()).load("http://112.133.112.77:9999/photo/thumb/default0.png").into(viewHolder.photo);
        viewHolder.name.setText(pt.getNAME() + "(" + pt.getAGE() + "/" + pt.getSEX() + ")");
        viewHolder.name2.setText(pt.getNAME() + "(" + pt.getAGE() + "/" + pt.getSEX() + ")");
        //viewHolder.SEX.setText(pt.getSEX());
        //viewHolder.AGE.setText(pt.getAGE());
        viewHolder.firstDate.setText(pt.getFIRSTDATE());
        viewHolder.lastDate.setText(pt.getLASTDATE());
        viewHolder.JTIME.setText(String.valueOf(pt.getJTIME()));
        viewHolder.ITYPE.setText(pt.getITYPE());

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
        ImageView photo;
        TextView name;
        TextView name2;
        TextView contentRequestBtn;
        TextView JTIME;
        TextView firstDate;
        TextView lastDate;
        TextView ITYPE;
        //TextView birth;
        //TextView visitCount;
    }

}