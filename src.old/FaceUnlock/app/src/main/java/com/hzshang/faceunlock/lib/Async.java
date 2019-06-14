package com.hzshang.faceunlock.lib;

import android.content.Context;
import android.os.AsyncTask;



public class Async<param1,param2,param3> extends AsyncTask<param1,param2,param3> {

    protected Context context=null;
    public interface  interFace < param1 , param2> {
        void processFinish(param1 out);
        void processPre();
        void processRunning(param2 progress);
    }

    public interFace delegate = null;

    public Async(Context context,interFace delegate){
        this.context=context;
        this.delegate=delegate;
    }
    @Override
    protected param3 doInBackground(param1... param1s) {
        return null;
    }
    @Override
    protected void onPreExecute(){
        delegate.processPre();
    }
    @Override
    protected void onProgressUpdate(param2... process){
        delegate.processRunning(process[0]);
    }
    @Override
    protected void onPostExecute(param3 ret) {
        delegate.processFinish(ret);
    }


}
