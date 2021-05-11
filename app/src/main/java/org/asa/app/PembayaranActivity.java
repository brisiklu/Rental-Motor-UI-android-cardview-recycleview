package org.asa.app;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.bumptech.glide.Glide;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.*;

public class PembayaranActivity extends AppCompatActivity implements OnClickListener
{

	@Override
	public void onClick(View v)
	{
		// TODO: Implement this method
		switch (v.getId())
		{
            case R.id.btnBayar:
                Intent bayar = new Intent(PembayaranActivity.this, BarcodeActivity.class);
                startActivity(bayar);
                break;
			default:
				break;
				}
	}
	Button btnMakeOrder;
    EditText selectDateDelivery,selecDatePick;
    TextView btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarOrder);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getIncomingIntent();
		btnMakeOrder = (Button)findViewById(R.id.btnBayar);
        btnMakeOrder.setOnClickListener(this);
	}
	
	private void getIncomingIntent(){

        if(getIntent().hasExtra("nama") && 
		   getIntent().hasExtra("harga")&& 
		   getIntent().hasExtra("poto")&&
		   getIntent().hasExtra("kiriman") ){


            String snamaMotor = getIntent().getStringExtra("nama");
            String sHargaMotor = getIntent().getStringExtra("harga");
            String sPotoMotor = getIntent().getStringExtra("poto");
			String sdCh = getIntent().getStringExtra("kiriman");
            setImage(snamaMotor, sHargaMotor, sPotoMotor,sdCh);
        }
    }


    private void setImage(String snamaMotor, String shargaMotor ,String sPotoMotor, String sdCh){


        TextView name = (TextView) findViewById(R.id.namaMotorItem);
        name.setText(snamaMotor);

        TextView mhargaMotor = (TextView) findViewById(R.id.hargaMotorItem);
        mhargaMotor.setText(shargaMotor.subSequence(5,17));

        ImageView imageMotor = (ImageView) findViewById(R.id.imageMotor);
        Glide.with(this)

            .load(sPotoMotor)
            .into(imageMotor);
		EditText sch = (EditText) findViewById(R.id.dateDeliverySch);
        sch.setText(sdCh);
			
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
