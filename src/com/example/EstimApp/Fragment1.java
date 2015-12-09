package com.example.EstimApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.EstimApp.Server.Server;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.layout1, container, false);

        final Button button = (Button)rootView.findViewById(R.id.layout1SwitchButton);
        if (button != null)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSuccessLogin();
            }
        });

        final Button loginButton = (Button)rootView.findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText loginEdit = (EditText)rootView.findViewById(R.id.editTextNickName);
                String login = loginEdit.getText().toString();

                Server server = new Server();
                if (server.checkUsername(login))
                    onSuccessLogin();
            }

        });

        return rootView;
    }

    private void onSuccessLogin(){
        Intent intent = new Intent(getActivity(), Activity2.class);
        startActivity(intent);
    }

}
