package com.thoughtinterac.realestateapp.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.Fragments.ContactFragment;
import com.thoughtinterac.realestateapp.Fragments.GalleryFragment;
import com.thoughtinterac.realestateapp.Fragments.MyBankDetailsFragment;
import com.thoughtinterac.realestateapp.Fragments.MyDocFragment;
import com.thoughtinterac.realestateapp.Fragments.MyProfileFragment;
import com.thoughtinterac.realestateapp.Fragments.MyProjectFragment;
import com.thoughtinterac.realestateapp.Fragments.PrivacyPolicyFragment;
import com.thoughtinterac.realestateapp.Fragments.ProjectListFragment;
import com.thoughtinterac.realestateapp.Fragments.RealtorProjectListFragment;
import com.thoughtinterac.realestateapp.Fragments.TermNConditionFragment;
import com.thoughtinterac.realestateapp.Fragments.UserInstallmentStatusFragment;
import com.thoughtinterac.realestateapp.Fragments.UserProjectListFragment;
import com.thoughtinterac.realestateapp.Fragments.User_Welcome_Page;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.Utility;

public class MainActivity extends AppCompatActivity {

    Animation zoomOut;
    ImageView img_dashboard,img_share;
    String data;
    public static String userFlag ="true";
    public static String realtorFlag ="false";
    private ListView listView;

    private ProgressDialog pDialog;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    // tags used to attach the fragments
    private static final String TAG_HOME = "Home";
    private static final String TAG_ME = "Me";
    private static final String TAG_MYPROJECT = "MyProject";
    private static final String TAG_MYDOC = "MyDoc";
    private static final String TAG_GALLERY = "Gallery";
    private static final String TAG_BANK_DETAILS = "BankDetails";
    private static final String TAG_CONTACT_US = "ContactUs";
    private static final String TAG_T_N_C = "TnC";
    private static final String TAG_PRIVACY_POLICY = "PrivacyPolicy";
    private static final String TAG_LOGOUT="Logout";
    private static final String TAG_PROJECT_LIST = "ProjectList";
    private static final String TAG_PROJECT_STATUS= "ProjectStatus";

    public static String CURRENT_TAG = TAG_HOME;
    TextView txtName,txtWebsite;
    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;
    FloatingActionButton fab_edit_user;
    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;
    // index to identify current nav menu item
    public static int navItemIndex = 0;
    Toolbar toolbar;

    public static String str_user_name="",str_user_address="",str_user_job="",str_user_mobile="",str_user_email="",str_user_pan="",str_user_bank="",str_male_female="",str_project_name="";
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img_share=(ImageView)findViewById(R.id.img_share);
        mHandler = new Handler();
        fab_edit_user=(FloatingActionButton)findViewById(R.id.fab_edit_user);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        Bundle bundle = getIntent().getExtras();
        fab_edit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString(DatabaseHandler.KEY_USER_NAME, str_user_name);
                bundle1.putString(DatabaseHandler.KEY_Project_Name, str_project_name);
                bundle1.putString(DatabaseHandler.KEY_USER_ADDRESS,str_user_address);
                bundle1.putString(DatabaseHandler.KEY_USER_JOB_DESC, str_user_job);
                bundle1.putString(DatabaseHandler.KEY_USER_MOBILE, str_user_mobile);
                bundle1.putString(DatabaseHandler.KEY_USER_EMAIL, str_user_email);
                bundle1.putString(DatabaseHandler.KEY_PAN_NUMBER, str_user_pan);
                bundle1.putString(DatabaseHandler.KEY_BANK_DETAILS, str_user_bank);
                bundle1.putString(DatabaseHandler.KEY_MALE_OR_FEMALE, str_male_female);
                Intent i = new Intent(MainActivity.this,UserProfileUpdateActivity.class);
                i.putExtra("KEY_USER_NAME", str_user_name);
                i.putExtras(bundle1);
                startActivity(i);
            }
        });
        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,MyProjectFragment.link,Toast.LENGTH_SHORT).show();
                String message = MyProjectFragment.link;
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(share, "Share Via"));
            }
        });
        if(bundle!=null)
        {
            str_user_name = bundle.getString(DatabaseHandler.KEY_USER_NAME);
            str_project_name = bundle.getString(DatabaseHandler.KEY_Project_Name);
            str_user_address = bundle.getString(DatabaseHandler.KEY_USER_ADDRESS);
            str_user_job = bundle.getString(DatabaseHandler.KEY_USER_JOB_DESC);
            str_user_mobile = bundle.getString(DatabaseHandler.KEY_USER_MOBILE);
            str_user_email = bundle.getString(DatabaseHandler.KEY_USER_EMAIL);
            str_user_pan = bundle.getString(DatabaseHandler.KEY_PAN_NUMBER);
            str_user_bank = bundle.getString(DatabaseHandler.KEY_BANK_DETAILS);
            str_male_female = bundle.getString(DatabaseHandler.KEY_MALE_OR_FEMALE);


        }
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        // initializing navigation menu
        loadNavHeader();
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    private void loadNavHeader() {
        // name, website
        txtName.setText(str_user_name);
        txtWebsite.setText(str_user_email);
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
        //toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }


    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                User_Welcome_Page myProfileFragment1 = new User_Welcome_Page();
                return myProfileFragment1;
            case 1:
                fab_edit_user.setVisibility(View.VISIBLE);
                img_share.setVisibility(View.GONE);
                MyProfileFragment myProfileFragment = new MyProfileFragment();
                return myProfileFragment;
            case 2:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.VISIBLE);
                ProjectListFragment myProjectFragment = new ProjectListFragment();
                return myProjectFragment;

            case 3:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                MyDocFragment myDocFragment = new MyDocFragment();
                return myDocFragment;
            case 4:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                UserInstallmentStatusFragment userProjectStatus = new UserInstallmentStatusFragment();
                return userProjectStatus;

            case 5:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                GalleryFragment galleryFragment = new GalleryFragment();
                return galleryFragment;
            case 6:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                MyBankDetailsFragment MyBankDetails = new MyBankDetailsFragment();
                return MyBankDetails;
            case 7:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;
            case 8:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                TermNConditionFragment termNConditionFragment = new TermNConditionFragment();
                return termNConditionFragment;
            case 9:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
                return privacyPolicyFragment;
            case 10:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                UserProjectListFragment ProjectList = new UserProjectListFragment();
               return ProjectList;

            case 11:
                fab_edit_user.setVisibility(View.GONE);
                img_share.setVisibility(View.GONE);
                //LogoutFragment logoutFragment = new LogoutFragment();
                SharedPreferences sharedPref = getSharedPreferences(
                        Utility.remember_me_share_pref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(Utility.remember_me_flag, "false");
                editor.commit();
                Intent i= new Intent(MainActivity.this,CommonPageActivity.class);
                startActivity(i);
                finish();
                userFlag ="false";



            default:
                return new MyProjectFragment();
        }
    }

    private void setToolbarTitle() {
        //getSupportActionBar().setTitle(activityTitles[navItemIndex]);
        getSupportActionBar().setTitle(Html.fromHtml("<small>"+activityTitles[navItemIndex]+"</small>"));
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
                    case R.id.my_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.my_profile:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_ME;
                        break;
                    case R.id.my_project:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_MYPROJECT;
                        break;
                    case R.id.my_document:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_MYDOC;
                        break;
                    case R.id.my_project_status:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_PROJECT_STATUS;
                        break;
                    case R.id.my_gallery:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_GALLERY;
                        break;
                    case R.id.my_bank_details:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_BANK_DETAILS;
                        break;
                    case R.id.contact:
                        navItemIndex = 7;
                        CURRENT_TAG = TAG_CONTACT_US;
                        break;
                    case R.id.terms_n_condition:
                        navItemIndex = 8;
                        CURRENT_TAG = TAG_T_N_C;
                        break;
                    case R.id.privacy_policy:
                        navItemIndex = 9;
                        CURRENT_TAG = TAG_PRIVACY_POLICY;
                        break;
                    case R.id.project_list:
                        navItemIndex = 10;
                        CURRENT_TAG = TAG_PROJECT_LIST;
                        break;
                    case R.id.logout:
                        navItemIndex = 11;
                        CURRENT_TAG = TAG_LOGOUT;
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
                // menuItem.setChecked(true);

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
    private void fetchListData() {
        //new fetchPlaceListDataAsync().execute("http://172.17.11.18:80/brewawebonlinePHP/product_list.php");
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }

            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity","onResume Called");
        fetchUserData();
        try {
            MyProfileFragment.setData();
        }catch (Exception e){}


    }
    public  void fetchUserData() {
        DatabaseHandler handler = new DatabaseHandler(MainActivity.this);
        SQLiteDatabase db = handler.getWritableDatabase();
        String[] colmn = new String[]{DatabaseHandler.KEY_USER_NAME, DatabaseHandler.KEY_USER_ADDRESS, DatabaseHandler.KEY_USER_JOB_DESC, DatabaseHandler.KEY_USER_MOBILE, DatabaseHandler.KEY_USER_EMAIL, DatabaseHandler.KEY_USER_PASSWORD, DatabaseHandler.KEY_PAN_NUMBER, DatabaseHandler.KEY_BANK_DETAILS};
        Cursor cursor = db.query(DatabaseHandler.TABLE_REGISTER, colmn, DatabaseHandler.KEY_USER_EMAIL + " = '" + str_user_email + "'" , null, null, null, null);
        if (cursor != null) {
            String lstr_user_name = "", lstr_user_address = "", lstr_user_job = "", lstr_user_mobile = "", lstr_user_email = "", lstr_user_pan = "", lstr_user_bank = "";
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    lstr_user_name = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_NAME));
                    lstr_user_address = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_ADDRESS));
                    lstr_user_job = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_JOB_DESC));
                    lstr_user_mobile = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_MOBILE));
                    lstr_user_email = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_EMAIL));
                    lstr_user_pan = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_PAN_NUMBER));
                    lstr_user_bank = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_BANK_DETAILS));


                    str_user_name = lstr_user_name;
                    str_user_address = lstr_user_address;
                    str_user_job = lstr_user_job;
                    str_user_mobile = lstr_user_mobile;
                    str_user_email = lstr_user_email;
                    str_user_pan = lstr_user_pan;
                    str_user_bank = lstr_user_bank;

                }
                cursor.close();
            }
        }
        db.close();
    }

}
