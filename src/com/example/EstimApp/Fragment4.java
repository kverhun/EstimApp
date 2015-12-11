package com.example.EstimApp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ServiceCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.EstimApp.PersonalDataStorage.PersonalDataStorage;
import com.example.EstimApp.PersonalDataStorage.UserItemEstim;
import com.example.EstimApp.Server.Server;

import java.util.concurrent.Callable;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Fragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout4, container, false);

        TextView titleTextView = (TextView)rootView.findViewById(R.id.textWorkItemTitle);
        TextView descriptionTextView = (TextView)rootView.findViewById(R.id.textWorkItemDesciption);

        Server server = Server.Instance();
        Server.WorkItem workItem = server.getWorkItem();

        titleTextView.setText(workItem.getTitle());
        descriptionTextView.setText(workItem.getDescription());

        Button button = (Button)rootView.findViewById(R.id.layout4SwitchButton);
        if (button != null)
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Activity6.class);
                    startActivity(intent);
                }
            });

        Button buttonWithEstim = (Button)rootView.findViewById(R.id.buttonEstimMade);
        buttonWithEstim.setText(Server.Instance().getLastEstimationValue().toString());

        PersonalDataStorage estimHistory = PersonalDataStorage.getInstance(getActivity());
        UserItemEstim userItemEstim = new UserItemEstim(
                estimHistory.GetCurrentLogin(),
                server.getWorkItem().getTitle(),
                server.getLastEstimationValue());
        estimHistory.StoreUserItemEstim(userItemEstim);

        ProgressBar progressBar = (ProgressBar)rootView.findViewById(R.id.progressBarWaitEndSession);
        (new WaitEndSessionTask(progressBar, new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Intent intent = new Intent(getActivity(), Activity2.class);
                startActivity(intent);
                return null;
            }
        })).execute();

        return rootView;
    }

    private class WaitEndSessionTask extends AsyncTask<Void, Void, Void> {
        public WaitEndSessionTask(ProgressBar progressBar, Callable<Void> onPostExecuteFunc){
            this.progressBar = progressBar;
            this.onPostExecuteFunc = onPostExecuteFunc;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void result){
            progressBar.setVisibility(View.INVISIBLE);
            try {
                onPostExecuteFunc.call();
            } catch (Exception e){

            }
        }

        @Override
        protected Void doInBackground(Void... params){
            Server.Instance().waitEndSession();
            return null;
        }

        private ProgressBar progressBar;
        private Callable<Void> onPostExecuteFunc;
    }


}