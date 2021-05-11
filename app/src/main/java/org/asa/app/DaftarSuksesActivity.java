package org.asa.app;

import android.content.*;
import android.content.SharedPreferences.Editor;
import android.graphics.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import android.support.v7.widget.Toolbar;

public class DaftarSuksesActivity extends AppCompatActivity implements View.OnClickListener
{

	Toolbar toolbarDaftarSukses;
	TextView txtNamaLengkap,txtEmailDaftar,txtPassword,toolbartextSukse;
	Button btnLoginSukses;
    private String nama,email,password;
    private String 
	KEY_NAME = "Name", 
	KEY_EMAIL= "EmailPengguna",
	KEY_PASS = "Password";
	
	SharedPreferences sharedPreferences;
	Editor editor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daftar_sukses);
		if (Build.VERSION.SDK_INT >= 21)
		{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
		changeStatusBarColor();

        sharedPreferences = getApplicationContext().getSharedPreferences("USER", 0);
        // get editor to edit in file
		editor = sharedPreferences.edit();
		
		
		Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
		email= extras.getString(KEY_EMAIL);
		password = extras.getString(KEY_PASS);
		
		txtNamaLengkap = (TextView) findViewById(R.id.txtNamaLengkap);
        txtNamaLengkap.setText("Oi, " + nama + " !");
		txtEmailDaftar = (TextView) findViewById(R.id.txtEmailDaftar);
        txtEmailDaftar.setText("Emailmu, " + email + "");
   		txtPassword = (TextView) findViewById(R.id.txtPassword);
		txtPassword.setText("Password, " + password + "");
		
		btnLoginSukses = (Button)findViewById(R.id.btnSuksesDaftar);
        btnLoginSukses.setOnClickListener(this);
	}

	@Override
    public void onClick(View v) {
        switch (v.getId()){
			
			case R.id.btnSuksesDaftar:
				Intent daftarToMasuk = new Intent(DaftarSuksesActivity.this, MasukActivity.class);
				editor.putString("Name",nama );
				editor.putString("EmailPengguna",email);
				editor.putString("Password",password);
				editor.commit();   // commit the values
				startActivity(daftarToMasuk);
                break;
            default:
                break;
        }
    }
	
	
	private void changeStatusBarColor()
	{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
		{
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

	@Override
	public void onBackPressed(){
		//super.onBackPressed();  //just removed this line
	}

	
}
