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
import android.support.v7.widget.*;


public class MotorActivity extends AppCompatActivity 
{


    private RecyclerView recyclerViewMotor;
    private MotorsAdapter adapterMotor;
    private List<MotorModel> motorModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmainMotor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        
        recyclerViewMotor = (RecyclerView) findViewById(R.id.recycleviewMotor);

        motorModelList = new ArrayList<>();
        adapterMotor = new MotorsAdapter(this, motorModelList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewMotor.setLayoutManager(mLayoutManager);
        recyclerViewMotor.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerViewMotor.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMotor.setAdapter(adapterMotor);

        prepareAlbums();


    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
            R.drawable.vario,
            R.drawable.ninja,
            R.drawable.supra,
            R.drawable.klx,
            R.drawable.veszpa,
            R.drawable.beat,
            R.drawable.nmax,
            R.drawable.ninja,
            R.drawable.mio,
            R.drawable.grand,};
            
        MotorModel a = new MotorModel("Vario 125","90.000",covers[0],0);
        motorModelList.add(a);

        a = new MotorModel("R15", "140.000",covers[1],1);
        motorModelList.add(a);

        a = new MotorModel("Supra", "80.000",covers[2],2);
        motorModelList.add(a);

        a = new MotorModel("KLX", "175.000",covers[3],3);
        motorModelList.add(a);

        a = new MotorModel("Vespa", "120.000", covers[4],4);
        motorModelList.add(a);

        a = new MotorModel("Beat", "80.000", covers[5],5);
        motorModelList.add(a);

        a = new MotorModel("Nmax", "150.000", covers[6],6);
        motorModelList.add(a);

        a = new MotorModel("Ninja RR", "130.000", covers[7],7);
        motorModelList.add(a);

        a = new MotorModel("Mio", "10.000", covers[8],8);
        motorModelList.add(a);

        a = new MotorModel("Grand Astrea", "Gratis Poto",covers[9],9);
        motorModelList.add(a);

        adapterMotor.notifyDataSetChanged();
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
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}    
