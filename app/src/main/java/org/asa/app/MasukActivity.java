package org.asa.app;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
public class MasukActivity extends AppCompatActivity implements View.OnClickListener
{
	TextView txtSignup;
    // Email, password edittext
    EditText txtUsernameEmail, txtPassword;

    // login button
    Button btnLogin;
    ImageButton btnGoogle;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
	SessionManager session;
	//public static android.content.SharedPreferences SharedPreferences = null;
	private static final String PREFER_NAME = "USER";
	

	private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		//showSystemUI();
        // Session Manager
        session = new SessionManager(this);

        if (session.isLoggedIn())
        {
            session.checkLogin();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finishAffinity();
        }

		// Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21)
		{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
		changeStatusBarColor();
        setContentView(R.layout.activity_login);
        //teks
		txtSignup = (TextView)findViewById(R.id.txtSignup);
        txtSignup.setOnClickListener(this);

        // Email, Password input text
        txtUsernameEmail = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.password); 
        // Login button
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        
        btnGoogle =( ImageButton) findViewById(R.id.google_login);
        btnGoogle.setOnClickListener(this);
		sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
	}

	@Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.txtSignup:
                Intent daftar = new Intent(MasukActivity.this, DaftarActivity.class);
                startActivity(daftar);
                break;
            case R.id.btnLogin:
                // Get username, password from EditText
                String username = txtUsernameEmail.getText().toString();
				String password = txtPassword.getText().toString();

				// Validate if username, password is filled             
				if(username.trim().length() > 0 && password.trim().length() > 0){
					String uNameEmail = null;
                    String uPassword =null;

					if (sharedPreferences.contains("EmailPengguna"))
					{
						uNameEmail = sharedPreferences.getString("EmailPengguna", "");

					}

					if (sharedPreferences.contains("Password"))
					{
						uPassword = sharedPreferences.getString("Password", "");

					}

					// Object uName = null;
					// Object uEmail = null;
					if(username.equals(uNameEmail) && password.equals(uPassword)){

						session.createLoginSession(uNameEmail,uPassword);
													   

						// Starting MainActivity
						Intent i = new  Intent(getApplicationContext(),MainActivity.class);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

						// Add new Flag to start new Activity
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(i);

						finish();
						
						}
                    else
                    {
                        // username / password doesn't match
                        alert.showAlertDialog(MasukActivity.this, "Big Bos Rentalku.co", "Lagi Lapar? \nCoba Inget!\nCek Email dan Password Lagi", false);
                    }               
                }
                else
                {
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
					alert.showAlertDialog(MasukActivity.this, "Big Bos Rentalku.co", "Udah Makan? \nCoba Inget!\nCek Email dan Password Lagi", false);
                }
                break;
                case R.id.google_login:
                alert.showAlertDialog(MasukActivity.this, "Google Lagi Gak Mau Di Ganggu", "jangan lupa makan :)\nudah gitu aja", false);
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
	public void onBackPressed()
	{
		//super.onBackPressed();  //just removed this line
	}



}

   
