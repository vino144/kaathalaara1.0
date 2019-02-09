package com.vino.raven.kaathalaara;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.vino.raven.kathalara.R;
import com.vino.raven.kaathalaara.fragment.About;
import com.vino.raven.kaathalaara.fragment.Contact;
import com.vino.raven.kaathalaara.fragment.Contents;
import com.vino.raven.kaathalaara.fragment.Settings;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private static final String TAG_CONTENT = "content";
    private static final String TAG_ABOUT = "about";
    private static final String TAG_SETTINGS = "settings";
    private static final String TAG_CONTACT = "contact";
    public static String CURRENT_TAG = TAG_CONTENT;
    Fragment fragment;
    FragmentTransaction ft;
    Toolbar toolbar;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("CHECK 3");

        mDrawerLayout=findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(CURRENT_TAG);
        setSupportActionBar(toolbar);
        initNavView();

        if (getActionBar()!=null){
            getActionBar().setDisplayHomeAsUpEnabled(true); // this sets the button to the    back icon
            getActionBar().setHomeButtonEnabled(true); // makes it clickable
            getActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);// set your own icon
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new Contents()).commit();
        if (toolbar.getTitle()==null) {
            toolbar.setTitle(CURRENT_TAG);
        }

    }

    private void initNavView() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout=findViewById(R.id.drawer_layout);

        NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        if (navigationMenuView != null) {
            navigationMenuView.setVerticalScrollBarEnabled(false);
        }
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        ///navigationView.set
        mDrawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        mDrawerLayout=findViewById(R.id.drawer_layout);
        if (mDrawerLayout!=null){
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }else {
                if(getFragmentManager().getBackStackEntryCount()>0){
                    getFragmentManager().popBackStack();
                }else {
                    super.onBackPressed();
                }
            }
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_content:
                item.setChecked(true);
                toolbar.setTitle(TAG_CONTENT);
                fragment=new Contents();
                break;
            case R.id.nav_about:
                item.setChecked(true);
                toolbar.setTitle(TAG_ABOUT);
                fragment=new About();
                break;
            case R.id.nav_settings:
                item.setChecked(true);
                toolbar.setTitle(TAG_SETTINGS);
                fragment=new Settings();
                break;
            case R.id.nav_contact:
                item.setChecked(true);
                toolbar.setTitle(TAG_CONTACT);
                fragment=new Contact();
                break;
        }
        if (fragment!=null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }else {
            System.out.println("FRAGMENT IS NULL");
        }
        mDrawerLayout=findViewById(R.id.drawer_layout);
        assert mDrawerLayout != null;
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

}
