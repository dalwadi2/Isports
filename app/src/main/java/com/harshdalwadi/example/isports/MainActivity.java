package com.harshdalwadi.example.isports;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ListView mmlist;
    private ShareActionProvider mShareActionProvider;
    String[] names = {"New Deck Tavern", "Atlantic Grill", "White Dog Cafe", "Coast","New Deck Tavern", "Atlantic Grill", "White Dog Cafe", "Coast","New Deck Tavern", "Atlantic Grill", "White Dog Cafe", "Coast"};
    int[] images = {R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.forth,R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.forth,R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.forth};
    String[] dist = {"0.3", "0.2", "0.2", "0.4","0.3", "0.2", "0.2", "0.4","0.3", "0.2", "0.2", "0.4"};
    String[] place = {"Sansom Street,Brooklyn,NY", "S38th St,Times Square,NY", "Sansom Street,Brooklyn,NY", "The Strip 1049,Las Vegas","Sansom Street,Brooklyn,NY", "S38th St,Times Square,NY", "Sansom Street,Brooklyn,NY", "The Strip 1049,Las Vegas","Sansom Street,Brooklyn,NY", "S38th St,Times Square,NY", "Sansom Street,Brooklyn,NY", "The Strip 1049,Las Vegas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mmlist = (ListView) findViewById(R.id.mylist);
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, names, images, dist, place);
        mmlist.setAdapter(customAdapter);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
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
                        Intent iii = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(iii);
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
                        Intent i21 = new Intent(MainActivity.this,FixturesListActivity.class);
                        startActivity(i21);
                        Toast.makeText(getApplicationContext(), "filter Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nearme:
                        Intent i = new Intent(MainActivity.this,MapDitance.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "nearme Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.favourites:
                        Toast.makeText(getApplicationContext(), "favourites Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.fetures:
                        Intent ii = new Intent(MainActivity.this,second.class);
                        startActivity(ii);
                        Toast.makeText(getApplicationContext(), "features Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "about Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.merchandise:
                        Intent i2 = new Intent(MainActivity.this,MerchandiesActivity.class);
                        startActivity(i2);
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


    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItemCompat item = (MenuItemCompat) menu.findItem(R.id.menu_item_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider((MenuItem) item);

        // Return true to display menu
        return true;
    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }*/
}
