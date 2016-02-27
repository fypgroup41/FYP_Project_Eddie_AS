/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.project.asyncTask;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author test
 */
public class Http_AsyncTask extends AsyncTask<String, Void, String> {

    public AsyncTask_Type asyncTask;
    Http_GetPost http_getPost = new Http_GetPost();

    public Http_AsyncTask(AsyncTask_Type asyncTask) {
        this.asyncTask = asyncTask;
    }

    @Override
    protected void onPreExecute() {
        this.asyncTask.showRecord(2);

    }

    //AsyncTask Process Function
    @Override
    protected String doInBackground(String... urls) {

        if (this.asyncTask.getHttp_method().equals("get")) {
            http_getPost.http_getPost_Entrance(urls[0], "get", this.asyncTask.getVal());
            /*http_getPost.uploadFile("/DCIM/Camera/a.mp4");*/
        }
        if (this.asyncTask.getHttp_method().equals("post")) {
            http_getPost.http_getPost_Entrance(urls[0], "post", this.asyncTask.getVal());
            /*            http_getPost.uploadFile("/DCIM/Camera/a.mp4");*/
        }

        return null;
    }

    //AsyncTask Finish Function
    @Override
    protected void onPostExecute(String result) {
        this.asyncTask.doWay(http_getPost.getWebpage_output());

    }

    protected void onProgressUpdate(Integer... values) {

    }

}
