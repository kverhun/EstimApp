package com.example.EstimApp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.EstimApp.Server.Server;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout3, container, false);

        TextView titleTextView = (TextView)rootView.findViewById(R.id.textWorkItemTitle);
        TextView descriptionTextView = (TextView)rootView.findViewById(R.id.textWorkItemDesciption);

        Server server = Server.Instance();
        Server.WorkItem workItem = server.getWorkItem();

        titleTextView.setText(workItem.getTitle());
        descriptionTextView.setText(workItem.getDescription());

        progressBar = (ProgressBar)rootView.findViewById(R.id.progressBarEstimMaking);

        TableLayout tableLayout = (TableLayout)rootView.findViewById(R.id.tableLayoutEstimButtons);
        fillLayoutWithButtons(tableLayout);

        return rootView;
    }

    private void fillLayoutWithButtons(TableLayout tableLayout){
        final int itemsPerRow = 4;

        int idx = 0;
        ArrayList<Integer> values = new ArrayList<>(itemsPerRow);
        while (idx < estimationValues.length){
            if (values.size() < itemsPerRow){
                values.add(values.size(), estimationValues[idx]);
                ++idx;
            }
            if (values.size() == itemsPerRow || idx == estimationValues.length){
                TableRow row = createRowWithButtons(values);
                tableLayout.addView(row);
                values.clear();
            }
        }
    }

    private TableRow createRowWithButtons(ArrayList<Integer> values){
        TableRow row = new TableRow(getActivity());

        for (final int value : values){
            Button button = new Button(getActivity());
            button.setText(Integer.toString(value));
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    (new TaskMakeEstim(progressBar, new Callable<Void>() {
                        @Override
                        public Void call() throws Exception {
                            onEstimMade();
                            return null;
                        }
                    })).execute(value);
                }
            });
            row.addView(button);
        }
        return row;
    }

    private void onEstimMade(){
        Intent intent = new Intent(getActivity(), Activity4.class);
        startActivity(intent);
    }

    private class TaskMakeEstim extends AsyncTask<Integer, Void, Void>{
        public TaskMakeEstim(ProgressBar progressBar, Callable<Void> onPostExecuteFunc){
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
        protected Void doInBackground(Integer... param){
            Server.Instance().makeEstimation(param[0]);
            return null;
        }

        private ProgressBar progressBar;
        private Callable<Void> onPostExecuteFunc;
    }

    private ProgressBar progressBar;
    private final int[] estimationValues = {0, 1, 2, 3, 5, 8, 13, 21};
    }

