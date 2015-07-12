package com.pearlstudio.abdinasir.navigationdrawerexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView navList;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ActionBar actionBar;
    private FragmentTransaction fragmentTransaction;
    private  FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        //set up ListView and its Adapter
        navList = (ListView)findViewById(R.id.navlist);
        ArrayList<String> navArray = new ArrayList<>();
        navArray.add("Home");
        navArray.add("Profile");
        navArray.add("Friends");
        navArray.add("Payment");
        navArray.add("Settings");

        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                android.R.layout.simple_list_item_activated_1,
                                                                navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);

        // Create HAMBURGER Icon in the ActionBar
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                                                            drawerLayout,
                                                            R.string.open_drawer,
                                                            R.string.close_drawer);
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);

        // Create HAMBURGER Icon in the ActionBar
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        loadSelection(0);

    }

    private void loadSelection(int i){
        navList.setItemChecked(i, true);

        switch (i){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,homeFragment);
                fragmentTransaction.commit();

                break;
            case 1:
                MyFragment1 myFragment1 = new MyFragment1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,myFragment1);
                fragmentTransaction.commit();
                break;
            case 2:
                MyFragment2 myFragment2 = new MyFragment2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,myFragment2);
                fragmentTransaction.commit();

                break;
            case 3:
                MyFragment3 myFragment3 = new MyFragment3();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,myFragment3);
                fragmentTransaction.commit();

                break;
            case 4:
                MyFragment4 myFragment4 = new MyFragment4();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_holder,myFragment4);
                fragmentTransaction.commit();
                break;

        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == android.R.id.home){
            if (drawerLayout.isDrawerOpen(navList)){
                drawerLayout.closeDrawer(navList);
            }else {
                drawerLayout.openDrawer(navList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        loadSelection(position);

        drawerLayout.closeDrawer(navList);
    }
}
