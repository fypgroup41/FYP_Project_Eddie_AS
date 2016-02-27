/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.test;

import android.app.Activity;
import android.view.View;
import java.net.HttpURLConnection;

/**
 *
 * @author test
 */
public class S_Main extends AsyncTask_Type {

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public S_Main(Activity activity, String http_method, String val) {
        super(http_method);
        super.setVal(val);
        this.activity = activity;
    }

    public void doWay(String output) {
    }

    public void executeAsyncTask() {
        
    }

    public void showRecord(Integer val) {

    }
}
