package com.moonhani.hanihani;

import android.app.Fragment;
//import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.moonhani.hanihani.R;
import com.moonhani.hanihani.fragment.DxFragment;
import com.moonhani.hanihani.fragment.GdFragment;
import com.moonhani.hanihani.fragment.PtFragment;
import com.moonhani.hanihani.fragment.TxFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        PtFragment.OnFragmentInteractionListener,
        DxFragment.OnFragmentInteractionListener,
        TxFragment.OnFragmentInteractionListener,
        GdFragment.OnFragmentInteractionListener {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    //FragmentManager mFragmentManager;
    //FragmentTransaction mFragmentTransaction;
    Toolbar mToolbar;
    private Window window;

    ////////////////////////////////////////////////////////////
    //  Overrides
    ////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_main) ;
        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        window = getWindow();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new PtFragment()).addToBackStack(null).commit();

        /**
         * Setup click events on the Navigation View Items.
         */

        _setDrawer();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    ////////////////////////////////////////////////////////////
    //  methods
    ////////////////////////////////////////////////////////////

    private void _setDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_main);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void _replaceFragment(int id) {
        window = getWindow();

        if (id == R.id.nav_item_pt) {
           window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_Pt));
            this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new PtFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_item_dx) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_Dx));
            this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new DxFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_item_tx) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_Tx));
            this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new TxFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_item_gd) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_Gd));
            this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new GdFragment()).addToBackStack(null).commit();
            /*
            try {
                FragmentManager fragmentManager = this.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, GdFragment.class.newInstance()).addToBackStack(null).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            */
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

    }



    ////////////////////////////////////////////////////////////
    //  Implements
    ////////////////////////////////////////////////////////////

    //----------------PtFragment.OnFragmentInteractionListener

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDxFragmentInteraction(Uri uri) {

    }

    /*
    @Override
    public void onPtFragmentInteraction(Uri uri) {

    }
*/


    @Override
    public void onTxFragmentInteraction(Uri uri) {

    }

    @Override
    public void onGdFragmentInteraction(Uri uri) {

    }

    //--------------------------- NavigationView.OnNavigationItemSelectedListener
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        _replaceFragment(id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
