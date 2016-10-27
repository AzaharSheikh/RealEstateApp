package com.thoughtinterac.realestateapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Fragments.CommonPageHomeFragment;
import com.thoughtinterac.realestateapp.Fragments.CommonPagePhotosFragment;
import com.thoughtinterac.realestateapp.Fragments.CommonPageProjectFragment;
import com.thoughtinterac.realestateapp.Fragments.ContactFragment;
import com.thoughtinterac.realestateapp.Fragments.PrivacyPolicyFragment;
import com.thoughtinterac.realestateapp.Fragments.ProjectListFragment;
import com.thoughtinterac.realestateapp.Fragments.RealtorMyProfileFragment;
import com.thoughtinterac.realestateapp.Fragments.RealtorProjectListFragment;
import com.thoughtinterac.realestateapp.Fragments.TermNConditionFragment;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 27-10-2016.
 */
public class CommonPageActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_LOGIN = "My_Login";
    private static final String TAG_HOME = "Home";
    private static final String TAG_PROJECT = "Project";
    private static final String TAG_PHOTOS = "Photos";
    public static String CURRENT_TAG = TAG_HOME;
    private static final String TAG_PRIVACY ="Privacy";
    private static final String TAG_CONTACT_US = "ContactUs";
    private static final String TAG_T_N_C = "TnC";
    private static final String TAG_PRIVACY_POLICY = "PrivacyPolicy";
    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;
    public static String str_user_name="",str_user_address="",str_user_job="",str_user_mobile="",str_user_email="";
    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;
    public static int flag=0;
    static RelativeLayout notifCount;
    static int mNotifCount = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_page);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHandler = new Handler();
        Bundle bundle = getIntent().getExtras();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fab = (FloatingActionButton) findViewById(R.id.fab_search);

        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
//        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
//        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.common_page_item_activity_titles);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CommonPageActivity.this,SearchProjectActivity.class);
                startActivity(i);
            }
        });

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }
    private void loadNavHeader() {
        // name, website
        txtName.setText("Hello Guest");
        txtWebsite.setText("Gemini@gmail.com");
// showing dot next to notifications label
        //navigationView.getMenu().getItem(2).setActionView(R.layout.menu_dot);
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
                fragmentTransaction.replace(R.id.common_page_frame, fragment, CURRENT_TAG);
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
                CommonPageHomeFragment commonPageHomeFragment = new CommonPageHomeFragment();
                return commonPageHomeFragment;
            case 1:
                //flag=1;
                CommonPageProjectFragment commonPageProjectFragment = new CommonPageProjectFragment();
                return commonPageProjectFragment;
            case 2:
                //flag=1;
                CommonPagePhotosFragment commonPagePhotosFragment = new CommonPagePhotosFragment();
                return commonPagePhotosFragment;
            case 3:
                //flag=1;
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;
            case 4:
                //flag=1;
                TermNConditionFragment termNConditionFragment = new TermNConditionFragment();
                return termNConditionFragment;
            case 5:
                //flag=1;
                PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
                return privacyPolicyFragment;



            default:
                return new RealtorMyProfileFragment();
        }
    }
    private void setToolbarTitle() {
        if(flag!=0) {
            // getSupportActionBar().setTitle(activityTitles[navItemIndex]);
            getSupportActionBar().setTitle(Html.fromHtml("<small>"+activityTitles[navItemIndex]+"</small>"));
            flag=1;
        }else
        {
            //getSupportActionBar().setTitle(activityTitles[navItemIndex]);
            //getSupportActionBar().setTitle("Welcome");
            getSupportActionBar().setTitle(Html.fromHtml("<small>"+activityTitles[navItemIndex]+"</small>"));
        }
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
                    case R.id.m_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.m_projects:
                        navItemIndex = 1;
                        CURRENT_TAG =TAG_PROJECT ;
                        break;
                    case R.id.m_photos:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_PHOTOS;
                        break;
                    case R.id.m_contact:
                        navItemIndex = 3;
                        CURRENT_TAG =TAG_CONTACT_US ;
                        break;
                    case R.id.m_terms_n_condition:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_T_N_C;

                        break;
                    case R.id.m_privacy_policy:
                        navItemIndex = 5;
                        CURRENT_TAG =TAG_PRIVACY_POLICY ;
                        break;

                    default:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
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
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }
}
