/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.project;

/**
 *
 * @author test
 */
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class LoadingLogin extends Activity {

//    ProgressDialog mProgressDialog;
    /**
     * Duration of wait *
     */
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);

        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
        /*    mProgressDialog = ProgressDialog.show(Splash.this, "", "Loading...", true);
         mProgressDialog.setCancelable(false);
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(LoadingLogin.this, Menu.class);
                LoadingLogin.this.startActivity(mainIntent);
                LoadingLogin.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);     
        
        
    }
}
