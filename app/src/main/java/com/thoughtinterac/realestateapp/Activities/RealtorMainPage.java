package com.thoughtinterac.realestateapp.Activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.Fragments.MyProfileFragment;
import com.thoughtinterac.realestateapp.Fragments.New_Project_Fragment;
import com.thoughtinterac.realestateapp.Fragments.RealtorMyProfileFragment;
import com.thoughtinterac.realestateapp.Fragments.UserListFragment;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 01-10-2016.
 */
public class RealtorMainPage extends AppCompatActivity
{
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_MY_PROFILE = "My_Profile";
    private static final String TAG_NEW_PROJECT = "New_Project";
    private static final String TAG_USER_LIST = "User_List";
    public static String CURRENT_TAG = TAG_MY_PROFILE;
    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;
    public static String str_user_name="",str_user_address="",str_user_job="",str_user_mobile="",str_user_email="";
    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    static RelativeLayout notifCount;
    static int mNotifCount = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtor_activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();
        Bundle bundle = getIntent().getExtras();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        if(bundle!=null)
        {
            str_user_name = bundle.getString(DatabaseHandler.KEY_USER_NAME);
            str_user_address = bundle.getString(DatabaseHandler.KEY_USER_ADDRESS);
            str_user_job = bundle.getString(DatabaseHandler.KEY_USER_JOB_DESC);
            str_user_mobile = bundle.getString(DatabaseHandler.KEY_USER_MOBILE);
            str_user_email = bundle.getString(DatabaseHandler.KEY_USER_EMAIL);

        }
        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.realtor_nav_item_activity_titles);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search Here", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_MY_PROFILE;
            loadHomeFragment();
        }
    }
    private void loadNavHeader() {
        // name, website
        txtName.setText("Azahar");
        txtWebsite.setText("www.thoughtiteract.com");
// showing dot next to notifications label
        navigationView.getMenu().getItem(2).setActionView(R.layout.menu_dot);
    }
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            toggleFab();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }
    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                MyProfileFragment myProfileFragment = new MyProfileFragment();
                return myProfileFragment;
            case 1:
                New_Project_Fragment new_Project_Fragment = new New_Project_Fragment();
                return new_Project_Fragment;
            case 2:
                UserListFragment userListFragment = new UserListFragment();
                return userListFragment;

            default:
                return new RealtorMyProfileFragment();
        }
    }
    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.my_profile:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_MY_PROFILE;
                        break;
                    case R.id.nav_new_project:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_NEW_PROJECT;
                        break;
                    case R.id.nav_user_list:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_USER_LIST;
                        break;

                    default:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_MY_PROFILE;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
    // show or hide the fab
    private void toggleFab() {
        if (navItemIndex == 2)
            fab.show();
        else
            fab.show();
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_MY_PROFILE;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        /*if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }*/
        /*getMenuInflater().inflate(R.menu.notification_main, menu);
        MenuItem item = menu.findItem(R.id.badge);
        MenuItemCompat.setActionView(item, R.layout.feed_update_count);
        //notifCount = (RelativeLayout) MenuItemCompat.getActionView(item);

        //inflater.inflate(R.menu.main, menu);

        *//*View count = menu.findItem(R.id.badge).getActionView();
        notifCount = (Button) count.findViewById(R.id.notif_count);*//*
        //notifCount.setText(String.valueOf(mNotifCount));
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.feed_update_count, null);
        TextView notifCount = (TextView)view.findViewById(R.id.txt_notif_count);

        notifCount.setText(String.valueOf(mNotifCount));
        return super.onCreateOptionsMenu(menu);*/
        getMenuInflater().inflate(R.menu.notification_main, menu);

        MenuItem menuItem = menu.findItem(R.id.new_user_reg);
        MenuItem menuItem2 = menu.findItem(R.id.user_alert);
        menuItem.setIcon(buildCounterDrawable(2,  R.drawable.my_document));
        menuItem2.setIcon(buildCounterDrawable(115,  R.drawable.my_document));

        return true;

    }
    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.feed_update_count, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            //View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            //counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.txt_notif_count);
            textView.setText("" + count);
        }if(count > 99)
        {
            TextView textView = (TextView) view.findViewById(R.id.txt_notif_count);
            textView.setText("99+");
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0,0 , view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }
    private void setNotifCount(int count){
        mNotifCount = count;
        invalidateOptionsMenu();
    }

}
