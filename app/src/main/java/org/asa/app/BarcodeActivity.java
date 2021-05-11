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

public class BarcodeActivity extends AppCompatActivity implements OnClickListener
{

	@Override
	public void onClick(View v)
	{
		// TODO: Implement this method
		switch (v.getId())
		{
            case R.id.text_action_bottom1:
                Intent kembali = new Intent(BarcodeActivity.this, MainActivity.class);
                startActivity(kembali);
                break;
			case R.id.text_action_bottom2:
                Intent selesai = new Intent(BarcodeActivity.this, MainActivity.class);
                startActivity(selesai);
                break;
			default:
				break;
		}
	}

    EditText selectDateDelivery,selecDatePick;
    TextView txtKembali,txtSelesai;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        txtKembali = (TextView)findViewById(R.id.text_action_bottom1);
        txtKembali.setOnClickListener(this);
		txtSelesai = (TextView)findViewById(R.id.text_action_bottom2);
        txtSelesai.setOnClickListener(this);
	}
}
	
