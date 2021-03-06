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

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener
{

	Toolbar toolbarDaftar;
	TextView txtSignUp,toolbarText;
	Button btnSignup;
    AlertDialogManager alert = new AlertDialogManager();
	EditText namaLengkap,emailDaftar,passwordDaftar,passwordKonfirm;
	SessionManager session;
    SharedPreferences sharedPreferences;
	Editor editor;

	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daftar);
		if (Build.VERSION.SDK_INT >= 21)
		{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
		changeStatusBarColor();

        toolbarDaftar = (Toolbar) findViewById(R.id.toolbarDaftar);
        toolbarText = (TextView) findViewById(R.id.toolbar_text);
        if (toolbarText != null && toolbarDaftar != null)
		{
            toolbarText.setText(getTitle());
            setSupportActionBar(toolbarDaftar);
        }
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		sharedPreferences = getApplicationContext().getSharedPreferences("USER", 0);
        // get editor to edit in file
		editor = sharedPreferences.edit();

		txtSignUp = (TextView)findViewById(R.id.txtLogin);
        txtSignUp.setOnClickListener(this);


        btnSignup = (Button)findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(this);

		namaLengkap = (EditText) findViewById(R.id.namaLengkap);
		emailDaftar = (EditText) findViewById(R.id.emailDaftar);
		passwordDaftar = (EditText) findViewById(R.id.passwordDaftar);
		passwordKonfirm = (EditText) findViewById(R.id.confirm_passwordDaftar);


    }

	@Override
    public void onClick(View v)
	{
        switch (v.getId())
		{
            case R.id.txtLogin:
                Intent daftar = new Intent(DaftarActivity.this, MasukActivity.class);
                startActivity(daftar);
                break;
			case R.id.btnSignup:
				String username = namaLengkap.getText().toString();
                String email = emailDaftar.getText().toString();
                String password = passwordDaftar.getText().toString();
                String passKonfirm = passwordKonfirm.getText().toString();
                // Check if username, password is filled   

				if (namaLengkap.getText().length() <= 0)
				{
					alert.showAlertDialog(DaftarActivity.this, "Big Bos Rentalku.co", "Kasih Tau Namamu\nBiar Ku Ingat Slalu\nHehehe", false);
				}
				else if (emailDaftar.getText().length() <= 0)
				{
					alert.showAlertDialog(DaftarActivity.this, "Big Bos Rentalku.co", "Kasih Tau Emailmu\nBiar Ku Follow Dirimu\nHehehe", false);
				}
				else if (passwordDaftar.getText().length() <= 0)
				{
					alert.showAlertDialog(DaftarActivity.this, "Big Bos Rentalku.co", "Kasih Tau Password Hatimu\nAkan Ku Amankan Hatimu\nHehehe", false);
				}
				else if (passwordKonfirm.getText().length() <= 0)
				{
					alert.showAlertDialog(DaftarActivity.this, "Big Bos Rentalku.co", "Samain Password\nBiar Kita Nanti 2 + 3 = 5\nKita Akan Selalu Bersama\nHeyaHeya", false);
				}
				else
				{
					if (validate())
					{
						Intent daftar1 = new Intent(DaftarActivity.this, DaftarSuksesActivity.class);
						daftar1.putExtra("Name", namaLengkap.getText().toString());
						daftar1.putExtra("EmailPengguna", emailDaftar.getText().toString());
						daftar1.putExtra("Password", passwordDaftar.getText().toString());
						
						editor.putString("Name", username);
						editor.putString("EmailPengguna", email);
						editor.putString("Password", password);
						editor.putString("PassworKonfirm", passKonfirm);
						editor.commit();  // commit the values

						startActivity(daftar1);
					}
				}
                break;
            default:
                break;
        }}

	private boolean validate()
	{
		boolean temp=true;
		String pass=passwordDaftar.getText().toString();
		String cpass=passwordKonfirm.getText().toString();
		if (!pass.equals(cpass))
		{
			alert.showAlertDialog(DaftarActivity.this, "Big Bos Rentalku.co", "Nungguin Kamu Nyamain\nOjo Suwe Suwe Lah\nHeyaHeya", false);
			temp = false;
		}
		return temp;
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
	public void onBackPressed()
	{
		//super.onBackPressed();  //just removed this line
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
