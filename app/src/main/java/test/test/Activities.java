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

public class Activities extends Activity {

    private static final int REQUEST_CODE = 3434;
    private Button btn_send;
    public String webpage_output = null;
    private TextView tvOutput;
    //private FetchPageTask task = null;
    private GridView gv;
    private ArrayAdapter aryAdapter_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_status);
        setObjectView();
        //EditText text2 = (EditText) findViewById(R.id.EditText02);
        //  text2.setText(getIntent().getStringExtra("Value1") + " " + getIntent().getStringExtra("Value2"));

        AsyncTask_Type login = new S_Login("http://vbacdu.ddns.net:8080/WBS/activity_json?", Activities.this, webpage_output, aryAdapter_list, gv, tvOutput, "post", "id=2");
        login.executeAsyncTask();

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
