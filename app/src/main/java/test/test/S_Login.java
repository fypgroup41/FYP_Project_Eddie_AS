package test.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import upload.lib.UploadVideo;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author test
 */
public class S_Login extends AsyncTask_Type {

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getWebpage_output() {
        return webpage_output;
    }

    public void setWebpage_output(String webpage_output) {
        this.webpage_output = webpage_output;
    }

    public ArrayAdapter getAryAdapter_list() {
        return aryAdapter_list;
    }

    public void setAryAdapter_list(ArrayAdapter aryAdapter_list) {
        this.aryAdapter_list = aryAdapter_list;
    }

    public GridView getGv() {
        return gv;
    }

    public void setGv(GridView gv) {
        this.gv = gv;
    }

    public TextView getTvOutput() {
        return tvOutput;
    }

    public void setTvOutput(TextView tvOutput) {
        this.tvOutput = tvOutput;
    }
    private static final int REQUEST_CODE = 3434;
    private Activity activity;
    private String webpage_output;
    private ArrayAdapter aryAdapter_list;
    private GridView gv;
    private TextView tvOutput;
    private Http_AsyncTask task = null;
    private boolean uiCheck = false;
    private String url;

    public boolean isUiCheck() {
        return uiCheck;
    }

    public void setUiCheck(boolean uiCheck) {
        this.uiCheck = uiCheck;
    }

    public ProgressDialog getmProgressDialog() {
        return mProgressDialog;
    }

    public void setmProgressDialog(ProgressDialog mProgressDialog) {
        this.mProgressDialog = mProgressDialog;
    }

    ProgressDialog mProgressDialog;

    public Http_AsyncTask getTask() {
        return task;
    }

    public void setTask(Http_AsyncTask task) {
        this.task = task;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public S_Login(String url, Activity activity, String webpage_output, ArrayAdapter aryAdapter_list, GridView gv, TextView tvOutput, String http_method, String val) {
        super(http_method);
        super.setVal(val);
        this.url = url;
        this.activity = activity;
        this.webpage_output = webpage_output;
        this.aryAdapter_list = aryAdapter_list;
        this.gv = gv;
        this.tvOutput = tvOutput;
        uiCheck = true;
    }

    public void executeAsyncTask() {
        if (url != null && uiCheck) {
            try {
                if (task == null || task.getStatus().equals(AsyncTask.Status.FINISHED)) {
                    task = new Http_AsyncTask(this);
                    task.execute(url);
                    
                    //      Logger.getLogger(S_Login.class.getName()).info(s.getTask() + "CD");
                }
            } catch (Exception ex) {
                tvOutput.setText(ex.getMessage());
            }
        }
        
    }
    //NewClass1 a = new NewClass1();

    public void doWay(String server_output) {
        /*        tvOutput.setText(Environment.getExternalStorageDirectory() + "/DCIM/Camera/a.mp4");*/

        JSONArray array = null;
        List<String> list_output = new ArrayList<String>();
        String output = server_output;
        if (!output.equals("[]")) {

            Logger.getLogger(S_Login.class.getName()).info("true...............");
            try {
                array = new JSONArray(server_output);
            } catch (JSONException ex) {
                Logger.getLogger(S_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int n = 0; n < array.length(); n++) {
                for (int m = 0; m < 3; m++) {
                    try {
                        output += " " + array.getJSONArray(n).get(m).toString() + "\n ";
                    } catch (JSONException ex) {
                        Logger.getLogger(S_Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        list_output.add(array.getJSONArray(n).get(m).toString());
                    } catch (JSONException ex) {
                        Logger.getLogger(S_Login.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
                output += "\n";
            }
            String[] a = new String[list_output.size()];
            int i = 0;
            for (String number : a) {
                a[i] = number;
                i += 1;
            }
            aryAdapter_list = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, list_output);
            gv.setAdapter(aryAdapter_list);
            Logger.getLogger(S_Login.class.getName()).info(output);

        } else {

            tvOutput.setText("Page Not Found 404" + server_output);

            Intent i = new Intent(activity, Login.class);
            i.putExtra("type", "false");
            activity.startActivityForResult(i, REQUEST_CODE);
        }

        mProgressDialog.dismiss();

    }

    public void showRecord(Integer val) {
        mProgressDialog = ProgressDialog.show(activity, "", "Downloading...", true);
        mProgressDialog.setCancelable(false);
        //  tvOutput.setText(val);
    }

}
