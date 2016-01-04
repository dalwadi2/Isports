package com.harshdalwadi.example.isports;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class second extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ImageButton shrebtn, fbbtn, yesbtn, ftballbtn, locatebtn, featurbtn, listingbtn, nearmebtn, myfavbtn;
    android.app.Fragment fr;
    android.app.FragmentTransaction fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shrebtn = (ImageButton) findViewById(R.id.sharebtn);
        fbbtn = (ImageButton) findViewById(R.id.fbbtn);
        yesbtn = (ImageButton) findViewById(R.id.yesbtn);
        ftballbtn = (ImageButton) findViewById(R.id.ftballbtn);
        locatebtn = (ImageButton) findViewById(R.id.locatebtn);
        featurbtn = (ImageButton) findViewById(R.id.feturebtn);
        listingbtn = (ImageButton) findViewById(R.id.listingbtn);
        nearmebtn = (ImageButton) findViewById(R.id.nearmebtn);
        myfavbtn = (ImageButton) findViewById(R.id.favouritebtn);

        featurbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second.this, "Feature Btn", Toast.LENGTH_SHORT).show();
            }
        });
        listingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second.this, "Feature Btn", Toast.LENGTH_SHORT).show();
            }
        });
        nearmebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second.this, "Feature Btn", Toast.LENGTH_SHORT).show();
            }
        });
        myfavbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second.this, "Feature Btn", Toast.LENGTH_SHORT).show();
            }
        });
        fr = new ContentFrag();
        fm = getFragmentManager().beginTransaction();
        fm.add(R.id.myframe, fr);
        fm.commit();

        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr = new ContentFrag();
                fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.myframe, fr);
                fm.commit();
            }
        });

        ftballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr = new FieldFrag();
                fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.myframe, fr);
                fm.commit();
            }
        });
        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(false);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "home Selected", Toast.LENGTH_SHORT).show();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.myaccount:
                        Toast.makeText(getApplicationContext(), "myacc Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.login:
                        Toast.makeText(getApplicationContext(), "login Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.signup:
                        Toast.makeText(getApplicationContext(), "signup Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.filter:
                        Toast.makeText(getApplicationContext(), "filter Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nearme:
                        Toast.makeText(getApplicationContext(), "nearme Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.favourites:
                        Toast.makeText(getApplicationContext(), "favourites Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.fetures:
                        Toast.makeText(getApplicationContext(), "features Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "about Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.merchandise:
                        Toast.makeText(getApplicationContext(), "merchndise Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.worldcup:
                        Toast.makeText(getApplicationContext(), "worldcup Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

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
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Block Buster", R.drawable.block_buster_banner);
        file_maps.put("Chcco Black", R.drawable.chocoblock_banner);
        file_maps.put("Know Different Flavours", R.drawable.flavours_banner);
        file_maps.put("SugerFree", R.drawable.sugerfree_banner);
        file_maps.put("Triranga", R.drawable.triranga_banner);
        file_maps.put("Turbo Cones", R.drawable.turbo_cone_banner);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    }

    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
