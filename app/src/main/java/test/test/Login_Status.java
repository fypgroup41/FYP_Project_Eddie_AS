package test.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import android.widget.TextView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login_Status extends Activity {

    private static final int REQUEST_CODE = 3434;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_status);
    
        //EditText text2 = (EditText) findViewById(R.id.EditText02);
        //  text2.setText(getIntent().getStringExtra("Value1") + " " + getIntent().getStringExtra("Value2"));

  

     //   Logger.getLogger(S_Login.class.getName()).info(login.isValid() + "");

    }

   
    public void onClick(View view) {
        //      finish();
        Intent i = new Intent(this, Menu.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void onClick2(View view) {
        //      finish();
        Intent i = new Intent(this, Login.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    /*
     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
     if (data.hasExtra("returnKey1")) {
     TextView tv = (TextView) findViewById(R.id.TextView02);
     tv.setText("Result from Activity 2:\n"
     + data.getExtras().getString("returnKey1"));
     }
     }
     }*/
    public void setOutput(List<String> a) {

    }
}
