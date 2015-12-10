package com.example.EstimApp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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

                EditText passwordEdit = (EditText)rootView.findViewById(R.id.editTextPassword);
                String password = passwordEdit.getText().toString();

                ProgressBar progressBar = (ProgressBar)rootView.findViewById(R.id.loginProgressBar);
                TextView errorTextView = ((TextView)rootView.findViewById(R.id.textLoginError));

                LoginTask task = new LoginTask(login, password, progressBar, errorTextView);
                task.execute();
            }

        });




        return rootView;
    }

    private void onSuccessLogin(){
        Intent intent = new Intent(getActivity(), Activity2.class);
        startActivity(intent);
    }

    private class LoginTask extends AsyncTask<String, Integer, Boolean>{

        public LoginTask(String login, String password, ProgressBar progressBar, TextView textView) {
            this.login = login;
            this.password = password;
            this.progressBar = progressBar;
            this.textView = textView;
        }

        @Override
        protected void onPreExecute() {
            textView.setText("");
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Boolean result){
            progressBar.setVisibility(View.INVISIBLE);
            if (result == false){
                textView.setText("Incorrect login or password!");
            }
        }

        @Override
        protected Boolean doInBackground(String... params){
            Server server = Server.Instance();
            if (server.checkLoginInfo(login, password))
                return true;
            else
                return false;
        }

        private String login;
        private String password;
        private ProgressBar progressBar;
        private TextView textView;
    }

}
