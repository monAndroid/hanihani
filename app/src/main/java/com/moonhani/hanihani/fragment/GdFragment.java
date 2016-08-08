package com.moonhani.hanihani.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.moonhani.hanihani.R;
import com.moonhani.hanihani.adapter.PtPagerAdapter;


public class GdFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    //public static int int_items = 3 ;

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onGdFragmentInteraction(Uri uri);
    }

    ////////////////////////////////////////////////////////////
    //  Start here...
    ////////////////////////////////////////////////////////////

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GdFragment newInstance(String param1, String param2) {
        GdFragment fragment = new GdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ////////////////////////////////////////////////////////////
    //  Overrides
    ////////////////////////////////////////////////////////////

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // for options menu
        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate
        View view = inflater.inflate(R.layout.fragment_gd, container, false);

        _setAppBar(view);
        //_setFab(view);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    // Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.main, menu);
        inflater.inflate(R.menu.toolbar_gd, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == android.R.id.home){
            // open the Drawer menu
            DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    ////////////////////////////////////////////////////////////
    //  methods
    ////////////////////////////////////////////////////////////

    private void _setAppBar(View view) {
        // toolbar
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        AppCompatActivity atvt = (AppCompatActivity)getActivity();
        atvt.setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary_Gd));
        toolbar.setTitle(R.string.app_clinic_gd_title);

        //toolbar.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.pink_100));

        // back button
        //ActionBar ab = atvt.getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        //ab.setDisplayHomeAsUpEnabled(true);
        //ab.setTitle("생활 지도");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onGdFragmentInteraction(uri);
        }
    }


    ////////////////////////////////////////////////////////////
    //  Implements
    ////////////////////////////////////////////////////////////

}
