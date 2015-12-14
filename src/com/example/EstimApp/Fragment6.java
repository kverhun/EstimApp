package com.example.EstimApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.EstimApp.PersonalDataStorage.PersonalDataStorage;
import com.example.EstimApp.PersonalDataStorage.UserItemEstim;

import java.util.ArrayList;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Fragment6 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout6, container, false);

        TextView textView = (TextView)rootView.findViewById(R.id.textViewHistory);
        if (textView != null) {
            ShowEstimHistory(textView);
        }

        Button button = (Button)rootView.findViewById(R.id.layout6EscapeButton);
        if (button != null)
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().finish();
                    System.exit(0);
                }
            });

        return rootView;
    }

    private void ShowEstimHistory(TextView o_textView){
        PersonalDataStorage storage = PersonalDataStorage.getInstance(getActivity());
        ArrayList<UserItemEstim> estimHistory = storage.GetStoredUserItemEstims();
        String str = new String("");
        for(UserItemEstim el : estimHistory){
           str = str + el.toString() + "\n";
        }
        o_textView.setText(str);
    }
}