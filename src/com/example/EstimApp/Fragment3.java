package com.example.EstimApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.EstimApp.Server.Server;
import org.w3c.dom.Text;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout3, container, false);

        Button button = (Button)rootView.findViewById(R.id.layout3SwitchButton);
        if (button != null)
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(), Activity4.class);
                    startActivity(intent);

                }
            });

        TextView titleTextView = (TextView)rootView.findViewById(R.id.textWorkItemTitle);
        TextView descriptionTextView = (TextView)rootView.findViewById(R.id.textWorkItemDesciption);

        Server server = new Server();
        Server.WorkItem workItem = server.getWorkItem();

        titleTextView.setText(workItem.getTitle());
        descriptionTextView.setText(workItem.getDescription());


        return rootView;
    }
}