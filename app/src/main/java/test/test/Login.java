package test.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.logging.Logger;

public class Login extends Activity {

    private static final int REQUEST_CODE = 3434;

    EditText edit_username;
    EditText edit_password;
    private Button btn_send;
    public String webpage_output = null;
    private TextView tvOutput;
    //private FetchPageTask task = null;
    private GridView gv;
    private ArrayAdapter aryAdapter_list;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.login);
        setObjectView();
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);
        edit_username.setText("staff001");
        edit_password.setText("fyp");

        //ImageView img = (ImageView) findViewById(R.id.abcd);
        //  /   Drawable myDrawable = getResources().getDrawable(R.drawable.logo);
        ///      img.setImageDrawable(myDrawable);
        if (getIntent() != null) {
            if (getIntent().getStringExtra("type") != null) {
                AlertDialog.Builder MyAlertDialog = new AlertDialog.Builder(this);
                MyAlertDialog.setTitle("Login Fail");
                MyAlertDialog.setMessage("Please Login Again");
                edit_username.setText("");
                edit_password.setText("");
                MyAlertDialog.show();
            }
        }
    }

    public void onClick(View view) {
        //  super.finish();
        System.gc();
        /*Intent i = new Intent(this, Login_Status.class);
        i.putExtra("userName", edit_username.getText().toString());
        i.putExtra("password", edit_password.getText().toString());
        startActivityForResult(i, REQUEST_CODE);*/

        AsyncTask_Type login = new S_Login("http://vbacdu.ddns.net:8080/WBS/login_json?", Login.this, webpage_output, aryAdapter_list, gv, tvOutput, "post", "userName=" + edit_username.getText().toString() + "&password=" + edit_password.getText().toString() + "");
        login.executeAsyncTask();
    }

    public void onClick2(View view) {
        edit_username.setText("");
        edit_password.setText("");
    }

    @Override
    public void finish() {
        super.finish();

    }

    public void setObjectView() {
        btn_send = (Button) findViewById(R.id.btn_send);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        tvOutput.setMovementMethod(ScrollingMovementMethod.getInstance());
        gv = (GridView) findViewById(R.id.gridViewObj);
        gv.setNumColumns(3);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                tvOutput.setText(parent.getItemAtPosition(position).toString() + " : " + position);
            }
        });
    }

}
