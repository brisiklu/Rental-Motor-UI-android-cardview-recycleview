package org.asa.app;

import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import android.support.v7.widget.Toolbar;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener
{
	
	Toolbar toolbarDaftar;
	TextView txtSignUp,toolbarText;
	Button btnSignup;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
        setContentView(R.layout.activity_daftar);
		if (Build.VERSION.SDK_INT >= 21)
		{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
		changeStatusBarColor();
			
        toolbarDaftar = (Toolbar) findViewById(R.id.toolbarDaftar);
        toolbarText = (TextView) findViewById(R.id.toolbar_text);
        if(toolbarText!=null && toolbarDaftar!=null) {
            toolbarText.setText(getTitle());
            setSupportActionBar(toolbarDaftar);
        }
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		txtSignUp = (TextView)findViewById(R.id.txtLogin);
        txtSignUp.setOnClickListener(this);
		
		
        btnSignup = (Button)findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(this);
		
    }
	
	@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtLogin:
                Intent daftar = new Intent(DaftarActivity.this, MasukActivity.class);
                startActivity(daftar);
                break;
			case R.id.btnSignup:
				final EditText namaLengkap = (EditText) findViewById(R.id.namaLengkap);
                final EditText emailDaftar = (EditText) findViewById(R.id.emailDaftar);
                final EditText passwordDaftar = (EditText) findViewById(R.id.passwordDaftar);
				final EditText passwordKonfirm = (EditText) findViewById(R.id.confirm_passwordDaftar);
                String username = namaLengkap.getText().toString();
                String email = emailDaftar.getText().toString();
                String password = passwordDaftar.getText().toString();
                String pass = passwordKonfirm.getText().toString();
                // Check if username, password is filled                
                if (username.trim().length() > 0 && email.trim().length() > 0 && password.trim().length() > 0&& pass.trim().length() > 0)
                {
                Intent daftar1 = new Intent(DaftarActivity.this, DaftarSuksesActivity.class);
				daftar1.putExtra("NAMA", namaLengkap.getText().toString());
				daftar1.putExtra("EMAIL", emailDaftar.getText().toString());
				startActivity(daftar1);
                }else{
                    alert.showAlertDialog(DaftarActivity.this, "Big Bos Rentalku.co", 
                    "Udah Makan? \nHarus Diisi Semua Ya!\nCek Email dan Password :)", false);
                }
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
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
