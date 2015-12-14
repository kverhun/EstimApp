package com.example.EstimApp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.EstimApp.Server.Server;

import java.util.concurrent.Callable;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout2, container, false);

        ProgressBar progressBar = (ProgressBar)rootView.findViewById(R.id.progressBarWaitForWorkItem);
        WaitForWorkItemTask task = new WaitForWorkItemTask(progressBar, new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Intent intent = new Intent(getActivity(), Activity3.class);
                startActivity(intent);
                return null;
            }
        });
        task.execute();


        return rootView;
    }

    private class WaitForWorkItemTask extends AsyncTask<String, Integer, Boolean>{
        public WaitForWorkItemTask(ProgressBar progressBar, Callable<Integer> onPostExecuteFunc){
            this.progressBar = progressBar;
            this.onPostExecuteFunc = onPostExecuteFunc;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Boolean result){
            progressBar.setVisibility(View.INVISIBLE);
            try {
                onPostExecuteFunc.call();
            } catch (Exception e){

            }
        }

        @Override
        protected Boolean doInBackground(String... params){
            Server.Instance().waitForWorkItem();
            return true;
        }

        private ProgressBar progressBar;
        private Callable<Integer> onPostExecuteFunc;
    }

}