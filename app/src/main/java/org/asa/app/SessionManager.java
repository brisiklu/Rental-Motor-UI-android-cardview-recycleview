package org.asa.app;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "USER";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
	
	public static final String KEY_NAME = "Name";
	
    // User name (make variable public to access from outside)
    public static final String KEY_NAME_EMAIL = "EmailPengguna";

    // Email address (make variable public to access from outside)
    public static final String KEY_PASS = "Password";
	public static final String KEY_PASS_KONFIRM = "PasswordKonfirm";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static String getKEY_NAME_EMAIL()
    {
        return KEY_NAME_EMAIL;
    }

    /**
     * Create login session
     * */
    public void createLoginSession(Object emailPengguna, Object passwordPengguna){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME_EMAIL,(String) emailPengguna);

        // Storing email in pref
        editor.putString(KEY_PASS,(String) passwordPengguna );

        // commit changes
        editor.commit();
    }   

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, MasukActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
           
            
        }

    }

    

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME_EMAIL, pref.getString(KEY_NAME_EMAIL, null));

        // user email id
        user.put(KEY_PASS, pref.getString(KEY_PASS, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        
        editor.clear();
		editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, MasukActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}

