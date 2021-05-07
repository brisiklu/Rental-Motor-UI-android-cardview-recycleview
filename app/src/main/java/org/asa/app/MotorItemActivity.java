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

/**
 * Created by User on 1/2/2018.
 */

public class MotorItemActivity extends AppCompatActivity implements OnClickListener{

    private static final String TAG = "MotorItemActivity";
    Context mContext;
    Button btnOrder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motor_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmainMotorItem);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIncomingIntent();
        
        btnOrder = (Button) findViewById(R.id.btnMakeOrder);
        btnOrder.setOnClickListener(this);
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("nama") && getIntent().hasExtra("harga")&& getIntent().hasExtra("poto")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String snamaMotor = getIntent().getStringExtra("nama");
            String sHargaMotor = getIntent().getStringExtra("harga");
            String sPotoMotor = getIntent().getStringExtra("poto");
            setImage(snamaMotor, sHargaMotor, sPotoMotor);
        }
    }


    private void setImage(String snamaMotor, String shargaMotor, String sPotoMotor){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = (TextView) findViewById(R.id.namaMotorItem);
        name.setText(snamaMotor);

        TextView mhargaMotor = (TextView) findViewById(R.id.hargaMotorItem);
        mhargaMotor.setText("Harga "+"Rp. "+shargaMotor+" / hari");
        
        ImageView imageMotor = (ImageView) findViewById(R.id.imageMotor);
        Glide.with(this)
            
            .load(sPotoMotor)
            .into(imageMotor);
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
    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
                case R.id.btnMakeOrder:
                    Toast.makeText(getApplicationContext(), "Add To Order", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                    startActivity(intent);
                    break;
            default:
        }
    }
    
}
