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
public class OrderActivity extends AppCompatActivity implements OnClickListener
{ 
    EditText selectDateDelivery,selecDatePick;
    private int mYear, mMonth, mDay;
	private ImageView imageView;
	TextView btnNext;
	TextView name,mhargaMotor;
	ImageView imageMotor;
	EditText mEdtSch;
	AlertDialogManager alert = new AlertDialogManager();
	
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarOrder);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectDateDelivery = (EditText)findViewById(R.id.dateDeliverySch);
        selectDateDelivery.setOnClickListener(this);
        selecDatePick = (EditText)findViewById(R.id.datePickSch);
        selecDatePick.setOnClickListener(this);

		btnNext = (TextView) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		getIncomingIntent();
		imageView = (ImageView) findViewById(R.id.imagePotoPas);

		imageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view)
				{
					selectImage(OrderActivity.this);
				}
			});


    }

	private void getIncomingIntent()
	{

        if (getIntent().hasExtra("nama") && 
			getIntent().hasExtra("harga") && getIntent().hasExtra("poto"))
		{


            String snamaMotor = getIntent().getStringExtra("nama");
            String sHargaMotor = getIntent().getStringExtra("harga");
            String sPotoMotor = getIntent().getStringExtra("poto");
            setImage(snamaMotor, sHargaMotor, sPotoMotor);
        }
    }


    private void setImage(String snamaMotor, String shargaMotor , String sPotoMotor)
	{


        TextView name = (TextView) findViewById(R.id.namaMotorItem);
        name.setText(snamaMotor);

        TextView mhargaMotor = (TextView) findViewById(R.id.hargaMotorItem);
        mhargaMotor.setText(shargaMotor);

        ImageView imageMotor = (ImageView) findViewById(R.id.imageMotor);
        Glide.with(this)

            .load(sPotoMotor)
            .into(imageMotor);
    }

    @Override
    public void onClick(View view)
    {
        if (view == selectDateDelivery)
        {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth)
                    {
                        int kode = monthOfYear + 1;
                        String nama;

                        if (kode == 1)
						{
                            nama = "Januari";
                        }
						else if (kode == 2)
						{
                            nama = "Februari";
                        }
						else if (kode == 3)
                            nama = "Maret";
                        else
                        if (kode == 4)
                            nama = "April";
                        else
                        if (kode == 5)
                            nama = "Mei";
                        else
                        if (kode == 6)
                            nama = "Juni";
                        else
                        if (kode == 7)
                            nama = "Juli";
                        else
                        if (kode == 8)
                            nama = "Agustus";
                        else
                        if (kode == 9)
                            nama = "September";
                        else
                        if (kode == 10)
                            nama = "Oktober";
                        else
                        if (kode == 11)
                            nama = "November";
                        else
                        if (kode == 12)
                            nama = "Desember";
                        else
                            nama = "kode salah!";
                        selectDateDelivery.setText(dayOfMonth + " - " + (nama) + " - " + year);

                    }
                }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == selecDatePick)
        {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth)
                    {
                        int kode = monthOfYear + 1;
                        String nama;

                        if (kode == 1)
						{
                            nama = "Januari";
                        }
						else if (kode == 2)
						{
                            nama = "Februari";
                        }
						else if (kode == 3)
                            nama = "Maret";
                        else
                        if (kode == 4)
                            nama = "April";
                        else
                        if (kode == 5)
                            nama = "Mei";
                        else
                        if (kode == 6)
                            nama = "Juni";
                        else
                        if (kode == 7)
                            nama = "Juli";
                        else
                        if (kode == 8)
                            nama = "Agustus";
                        else
                        if (kode == 9)
                            nama = "September";
                        else
                        if (kode == 10)
                            nama = "Oktober";
                        else
                        if (kode == 11)
                            nama = "November";
                        else
                        if (kode == 12)
                            nama = "Desember";
                        else
                            nama = "kode salah!";
                        selecDatePick.setText(dayOfMonth + " - " + (nama) + " - " + year);

                    }
                }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
		mEdtSch = (EditText) findViewById(R.id.dateDeliverySch);
		name = (TextView) findViewById(R.id.namaMotorItem);
		mhargaMotor = (TextView) findViewById(R.id.hargaMotorItem);
		String sPotoMotor = getIntent().getStringExtra("poto");
		ImageView imageMotor = (ImageView) findViewById(R.id.imageMotor);
		Glide.with(this)

			.load(sPotoMotor)
			.into(imageMotor);

		if (view == btnNext)
		{
			if (selectDateDelivery.getText().length() <= 0)
			{
				alert.showAlertDialog(OrderActivity.this, "Pilih Tanggal Delivery Schedule", "Udah Gitu Aja", false);
			}
			else{
			Toast.makeText(getApplicationContext(), "Pembayaran", Toast.LENGTH_SHORT).show();
			
			Intent intent = new Intent(OrderActivity.this, PembayaranActivity.class);

			intent.putExtra("nama", name.getText().toString());
			intent.putExtra("harga", mhargaMotor.getText().toString());
			intent.putExtra("poto", sPotoMotor);
			intent.putExtra("kiriman", mEdtSch.getText().toString());

			startActivity(intent);
}
		}

    }


    private void selectImage(Context context)
	{
        final CharSequence[] options = {"KAMERA","HAHAIN"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Senyum Sayang");

        builder.setItems(options, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int item)
				{

					if (options[item].equals("KAMERA"))
					{
						Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
						startActivityForResult(takePicture, 0);
					}
					else if (options[item].equals("HAHAIN"))
					{
						dialog.dismiss();
					}
				}
			});
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
        if (resultCode != RESULT_CANCELED)
		{
            switch (requestCode)
			{
                case 0:
                    if (resultCode == RESULT_OK && data != null)
					{
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(selectedImage);
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null)
					{
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null)
						{
                            Cursor cursor = getContentResolver().query(selectedImage,
																	   filePathColumn, null, null, null);
                            if (cursor != null)
							{
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
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
}
