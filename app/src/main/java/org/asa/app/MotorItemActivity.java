package org.asa.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.*;
import android.content.*;
import java.util.List;

/**
 * Created by User on 1/2/2018.
 */

public class MotorItemActivity extends AppCompatActivity implements OnClickListener
{

	ImageView imageMotor;
	TextView name,mhargaMotor;
    private static final String TAG = "MotorItemActivity";
    Context mContext;
    Button btnOrder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motor_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmainMotorItem);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIncomingIntent();
getIncomingIntent1();


        btnOrder = (Button) findViewById(R.id.btnMakeOrder);
        btnOrder.setOnClickListener(this);
    }

    private void getIncomingIntent()
	{
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if (getIntent().hasExtra("nama") && getIntent().hasExtra("harga") && getIntent().hasExtra("poto"))
		{
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String snamaMotor = getIntent().getStringExtra("nama");
            String sHargaMotor = getIntent().getStringExtra("harga");
            String sPotoMotor = getIntent().getStringExtra("poto");
            setImage(snamaMotor, sHargaMotor, sPotoMotor);
        }
    }


    private void setImage(String snamaMotor, String shargaMotor, String sPotoMotor)
	{
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = (TextView) findViewById(R.id.namaMotorItem);
        name.setText(snamaMotor);

        TextView mhargaMotor = (TextView) findViewById(R.id.hargaMotorItem);
        mhargaMotor.setText("Harga " + "Rp. " + shargaMotor + " / hari");

        ImageView imageMotor = (ImageView) findViewById(R.id.imageMotor);
        Glide.with(this)

            .load(sPotoMotor)
            .into(imageMotor);
    }
	
	
	private void getIncomingIntent1()
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
			setImage1(snamaOutlet, sAlamat, sJarak,sBintang);
        }
    }


    private void setImage1(String snamaOutlet, String sAlamat, String sJarak, String sBintang)
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        if (item.getItemId() == android.R.id.home)
		{
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view)
    {

		name = (TextView) findViewById(R.id.namaMotorItem);
		mhargaMotor = (TextView) findViewById(R.id.hargaMotorItem);

		String sPotoMotor = getIntent().getStringExtra("poto");
		ImageView imageMotor = (ImageView) findViewById(R.id.imageMotor);
        Glide.with(this)

            .load(sPotoMotor)
            .into(imageMotor);

        switch (view.getId())
		{
			case R.id.btnMakeOrder:
				Toast.makeText(getApplicationContext(), "Add To Order", Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(MotorItemActivity.this, OrderActivity.class);
				//intent.putExtra(AlbumActivity.ALBUM, album);
				intent.putExtra("nama", name.getText().toString());
				intent.putExtra("harga", mhargaMotor.getText().toString());
				intent.putExtra("poto", sPotoMotor);
//                    Intent intent = new Intent(mContext, MotorItemActivity.class);
//                    intent.putExtra("NAMA_MOTOR", mnamaMotor.get(position));
//                    intent.putExtra("POTO_MOTOR", mPotoMotor.get(position));
				startActivity(intent);
				break;
            default:
        }
    }

}
