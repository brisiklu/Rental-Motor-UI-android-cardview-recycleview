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
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
public class OrderActivity extends AppCompatActivity implements OnClickListener
{ 
    EditText selectDateDelivery,selecDatePick;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarOrder);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectDateDelivery=(EditText)findViewById(R.id.dateDeliverySch);
        selectDateDelivery.setOnClickListener(this);
        selecDatePick=(EditText)findViewById(R.id.datePickSch);
        selecDatePick.setOnClickListener(this);
        
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
                        int kode = monthOfYear +1;
                        String nama;

                        if(kode == 1){
                            nama = "Januari";
                        }else if(kode == 2){
                            nama = "Februari";
                        }else if(kode == 3)
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
                        int kode = monthOfYear +1;
                        String nama;

                        if(kode == 1){
                            nama = "Januari";
                        }else if(kode == 2){
                            nama = "Februari";
                        }else if(kode == 3)
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
