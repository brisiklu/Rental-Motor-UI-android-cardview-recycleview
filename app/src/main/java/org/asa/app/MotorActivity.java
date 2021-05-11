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
        getIncomingIntent();
        
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
	private void getIncomingIntent()
	{

        if (getIntent().hasExtra("NamaOutlet") 
			&& getIntent().hasExtra("Alamat") 
			&& getIntent().hasExtra("Jarak")
			&& getIntent().hasExtra("Bintang"))
		{

            String snamaOutlet = getIntent().getStringExtra("NamaOutlet");
            String sAlamat = getIntent().getStringExtra("Alamat");
            String sJarak = getIntent().getStringExtra("Jarak");
			String sBintang = getIntent().getStringExtra("Bintang");
			setImage(snamaOutlet, sAlamat, sJarak,sBintang);
        }
    }


    private void setImage(String snamaOutlet, String sAlamat, String sJarak, String sBintang)
	{
        
        TextView nameOutlet = (TextView) findViewById(R.id.titleOutlet);
        nameOutlet.setText(snamaOutlet);

        TextView  mAlamat= (TextView) findViewById(R.id.title);
        mAlamat.setText(sAlamat);
		
		TextView  mJarak= (TextView) findViewById(R.id.jarakText);
        mJarak.setText(sJarak);
		
        TextView  mBintang= (TextView) findViewById(R.id.starText);
        mBintang.setText(sBintang);
    }
	
	
	

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
          
            R.drawable.ninja
			
			};
            
        MotorModel a = new MotorModel("Vespa Cimplis","290.000","https://www.vespa.com/dam/jcr:fe8f43d3-c325-4860-94cd-6232d44bce23/yellow-lime-2.png",0);
        motorModelList.add(a);

        a = new MotorModel("Yamaha R15 Kuning", "200.000","https://i1.wp.com/motomazine.com/wp-content/uploads/2019/05/r15-kuning.png",1);
        motorModelList.add(a);

        a = new MotorModel("Trail 250cc", "280.000","https://www.motoris.id/wp-content/uploads/2020/08/Motor-Trail-listrik-yang-dikembangkan-perusahaan-rintisan-asal-Belanda-yang-didukung-Yamaha-Eropa-dok.Electric-Motorcyles-e1596857633928.jpg",2);
        motorModelList.add(a);

        a = new MotorModel("Honda C70", "175.000","https://asset.kompas.com/crop/0x5:740x498/750x500/data/photo/2017/10/20/1570158269.jpg",3);
        motorModelList.add(a);

        a = new MotorModel("Kawasaki", "120.000", "https://dirtbikemagazine.com/wp-content/uploads/2016/01/procteam.jpg",4);
        motorModelList.add(a);

        a = new MotorModel("Scoopy", "80.000", "https://i2.wp.com/motomazine.com/wp-content/uploads/2020/11/IMG-20201111-WA0010.jpg",5);
        motorModelList.add(a);

        a = new MotorModel("CBR600RR", "150.000", "https://i1.wp.com/motomazine.com/wp-content/uploads/2021/02/AHM_CBR600RR.jpg",6);
        motorModelList.add(a);
//
        a = new MotorModel("LED WHITE Vespa", "130.000", "https://www.vespa.com/dam/jcr:1ac570fc-0c5d-495a-bf18-9d7e10e9c857/VXL-125-150-led-white.png",7);
        motorModelList.add(a);

        a = new MotorModel("VIXION", "10.000", "https://i1.wp.com/motomazine.com/wp-content/uploads/2021/03/Vixion-Matte-Blue.jpg",8);
        motorModelList.add(a);

        a = new MotorModel("Stay Class Vespa", "500.000","https://s3-ap-southeast-1.amazonaws.com/moladin.assets/blog/wp-content/uploads/2019/10/28100055/5-Vespa-Termahal.jpg",9);
        motorModelList.add(a);
//
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
