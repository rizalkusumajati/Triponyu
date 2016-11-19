package com.example.macmini2.triponyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.macmini2.triponyu.bookingManagement.BookingManagementMenuFragment;
import com.example.macmini2.triponyu.customDialog.Deposit;
import com.example.macmini2.triponyu.deposit.DepositFragment;
import com.example.macmini2.triponyu.home.RecyclerViewFragment;
import com.example.macmini2.triponyu.message.MyMessageFragment;
import com.example.macmini2.triponyu.myBooking.MyBookingMenuFragment;
import com.example.macmini2.triponyu.profile.ProfileFragment;
import com.example.macmini2.triponyu.requestTrip.RequestTripFragment;
import com.example.macmini2.triponyu.search.SearchFragment;

public class IndexActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private ImageButton back;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerViewFragment homeFragment;
    private ProfileFragment profileFragment;
    private MyBookingMenuFragment myBookingFragment;
    private BookingManagementMenuFragment bookingManagementAdapter;
    private ContactUsFragment contactUsFragment;
    private DepositFragment depositFragment;
    private MyMessageFragment myMessageFragment;
    private FloatingActionButton fab;
    private Step1AddNewTripFragment step1AddNewTripFragment;
    private Step2AddNewTripFragment step2AddNewTripFragment;
    private IncludeExcludeFragment includeExcludeFragment;
    private SearchFragment searchFragment;
    private RequestTripFragment requsetTripFragment;
    public int fragmentIndex=0;
    private DrawerLayout drawer;
    private    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        homeFragment=new RecyclerViewFragment();
        profileFragment=new ProfileFragment();
        myBookingFragment=new MyBookingMenuFragment();
        bookingManagementAdapter=new BookingManagementMenuFragment();
        contactUsFragment=new ContactUsFragment();
        depositFragment=new DepositFragment();
        myMessageFragment=new MyMessageFragment();
        step1AddNewTripFragment=new Step1AddNewTripFragment();
        step2AddNewTripFragment=new Step2AddNewTripFragment();
        includeExcludeFragment=new IncludeExcludeFragment();
        searchFragment=new SearchFragment();
        requsetTripFragment=new RequestTripFragment();
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSearch();
               // new Search().show(getSupportFragmentManager(), null);
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        gotoHome();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int fragments = getSupportFragmentManager().getBackStackEntryCount();
            if (fragments == 1) {
                finish();
            } else {
                if (getFragmentManager().getBackStackEntryCount() > 1) {
                    getFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            gotoProfile();
        } else if (id == R.id.nav_home) {
            gotoHome();

        } else if (id == R.id.nav_booking) {
            gotoMyBooking();
        } else if (id == R.id.nav_trip) {
            gotoAddNewTrip();

        } else if (id == R.id.nav_manage) {
            gotoBookingManagement();

        } else if (id == R.id.nav_message) {
            gotoMyMessage();

        } else if (id == R.id.nav_deposit) {
            gotoDeposit();

        } else if (id == R.id.nav_requestTrip) {
            gotoRequestTrip();

        } else if (id == R.id.nav_contact) {
            gotoContactUs();
        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_logout) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void gotoRequestTrip() {
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, requsetTripFragment)
                .addToBackStack(null)
                .commit();
    }

    public void setFabVisible(){
        fab.setVisibility(View.VISIBLE);
    }
    public void setFabInvisible(){
        fab.setVisibility(View.INVISIBLE);
    }

    public void closeDrawer(View view){
        drawer.closeDrawer(GravityCompat.START);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (fragmentIndex==0) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    public void hamburgerShow(){

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();

    }

    public void showDepositDialog(){
        new Deposit().show(getSupportFragmentManager(), null);
    }
    public void backShow(){
       // toggle.setDrawerIndicatorEnabled(false);
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void backMyBooking(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburgerShow();
                gotoMyBooking();

            }
        });
    }

    public void backMyMessage(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburgerShow();
                gotoMyMessage();

            }
        });
    }

    public void backBookingManag(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburgerShow();
                gotoBookingManagement();

            }
        });
    }

    public void backAddNewTrip(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburgerShow();
                gotoAddNewTrip();

            }
        });
    }

    public void backStep1(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburgerShow();
                gotoStep1();

            }
        });
    }

    public void backStep2(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // hamburgerShow();
                gotoStep2();

            }
        });
    }

    public void backIncludeExclude(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // hamburgerShow();
                gotoIncludeExclude();

            }
        });
    }





    public void gotoHome(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, homeFragment)
                .addToBackStack(null)
                .commit();

    }

    public void gotoStep1(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, step1AddNewTripFragment)
                .addToBackStack(null)
                .commit();

    }

    public void gotoSearch(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, searchFragment)
                .addToBackStack(null)
                .commit();

    }
    public void gotoStep2(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, step2AddNewTripFragment)
                .addToBackStack(null)
                .commit();

    }

    public void gotoIncludeExclude(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, includeExcludeFragment)
                .addToBackStack(null)
                .commit();

    }

    private void gotoProfile(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, profileFragment)
                .addToBackStack(null)
                .commit();


    }
    public void gotoAddNewTrip(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, step1AddNewTripFragment)
                .addToBackStack(null)
                .commit();
    }


    private void gotoMyBooking(){

        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, myBookingFragment)
                .addToBackStack(null)
                .commit();

    }

    private void gotoBookingManagement(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, bookingManagementAdapter)
                .addToBackStack(null)
                .commit();
    }

    private void gotoContactUs(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, contactUsFragment)
                .addToBackStack(null)
                .commit();
    }

    private void gotoDeposit(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, depositFragment)
                .addToBackStack(null)
                .commit();

    }

    public void gotoMyMessage(){
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, myMessageFragment)
                .addToBackStack(null)
                .commit();
    }



    public void setToolbarTitle(String title) {
        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(title);
    }

}
