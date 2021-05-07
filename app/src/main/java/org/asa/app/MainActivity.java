package org.asa.app;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.AppBarLayout;
import android.graphics.Rect;
import android.util.TypedValue;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import java.util.List;
import java.util.ArrayList;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.content.res.Resources;
import java.util.HashMap;
import android.widget.*;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnClickListener
{
    
    private RecyclerView recyclerView;
    private OutletsAdapter adapter;
    private List<Outlet> outletList;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(this);
        boolean user = true;
       
        
        session.checkLogin();
        HashMap<String, String> pengguna = session.getUserDetails();

        // name
        String userNameEmail = pengguna.get(SessionManager.KEY_NAME_EMAIL);
        if(user == true){
            Toast.makeText(getApplicationContext(), "Hai " + userNameEmail + " :)" , Toast.LENGTH_LONG).show();
            
        }else{

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.email);
        navUsername.setText(userNameEmail);
        ImageButton imgBtn = headerView.findViewById(R.id.arrow);
        imgBtn.setOnClickListener(this);
        
        recyclerView = (RecyclerView) findViewById(R.id.recycleviewOutlet);

        outletList = new ArrayList<>();
        adapter = new OutletsAdapter(this, outletList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
            
        prepareAlbums();

        
    }
    
    @Override
    public void onClick(View p1)
    {
        // TODO: Implement this method
    }
    private void setHeaderNameIntent (String name){
        TextView y = (TextView) findViewById(R.id.email);
        y.setText(name);
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,
            R.drawable.bg1,};
        Outlet a = new Outlet("ZEE RENT","1 Km","5",covers[0],0);
        outletList.add(a);

        a = new Outlet("BRISIK RENT", "1.2 Km","2", covers[1],1);
        outletList.add(a);

        a = new Outlet("HISTORIA RENT", "1.5 Km","3.5", covers[2],2);
        outletList.add(a);

        a = new Outlet("LYANNA RENT", "2 Km","3", covers[3],3);
        outletList.add(a);

        a = new Outlet("SANSA RENT", "2.5 Km","5", covers[4],4);
        outletList.add(a);

        a = new Outlet("EZ RENT", "3 Km","4", covers[5],5);
        outletList.add(a);

        a = new Outlet("STARK RENT", "3.5 Km","5", covers[6],6);
        outletList.add(a);

        a = new Outlet("LANNISTER RENT", "4 Km", "5",covers[7],7);
        outletList.add(a);

        a = new Outlet("TARGARYAN RENT", "4. 5","4.5", covers[8],8);
        outletList.add(a);

        a = new Outlet("PARAHMENRENT", "10 Km", "3.5",covers[9],9);
        outletList.add(a);

        adapter.notifyDataSetChanged();
    }
    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration
    {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge)
        {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
        {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge)
            {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount)
                { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            }
            else
            {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount)
                {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp)
    {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }






////////////////////
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // TODO: Implement this method
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_account)
        {
            session.logoutUser();
        }
        else if (id == R.id.my_wishlist)
        {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));
        }
        else if (id == R.id.my_orders)
        {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));
        }
        else if (id == R.id.my_rewards)
        {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));
        }
        else if (id == R.id.my_cart)
        {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));
        }
        else if (id == R.id.contact_us)
        {
            String phoneNumberWithCountryCode = "+6289698568653";
            String message = "Hallo";
            startActivity(
                new Intent(Intent.ACTION_VIEW,
                           Uri.parse(
                               String.format("https://api.whatsapp.com/send?phone=%s&text=%s", phoneNumberWithCountryCode, message)
                           )
                           )
            );
        }
        else
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        invalidateOptionsMenu();
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
