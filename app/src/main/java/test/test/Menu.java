package test.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends Activity {

    private static final int REQUEST_CODE = 3434;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void onClick(View view) {
        //      finish();
        Intent i = new Intent(this, AndroidBarcodeQrExample.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void onClick2(View view) {
//        finish();
        Intent i = new Intent(this, Login.class);
        i.putExtra("Value1", "staff001");
        i.putExtra("Value2", "fyp");
        startActivityForResult(i, REQUEST_CODE);
    }

    public void onClick3(View view) {
//        finish();
        Intent i = new Intent(this, Activities.class);
        i.putExtra("Value", "staff001");
        i.putExtra("Value2", "fyp");
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
}
