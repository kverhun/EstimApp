package com.example.EstimApp.Server;

/**
 * Created by Kostya on 09.12.2015.
 */
public class Server {

    public static Server Instance(){
        if (instance == null)
            instance = new Server();
        return instance;
    }

    public boolean checkLoginInfo(String username, String password) {
        // imitation of long operation
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            Thread.interrupted();
        }

        return checkUsername(username) && checkPassword(password);
    }

    public class WorkItem {
        public WorkItem(String title, String description){
            this.title = title;
            this.description = description;
        }

        public String getTitle(){ return title;}
        public String getDescription(){return description;}

        private final String title;
        private final String description;
    }

    public void waitForWorkItem(){
        // imitation of long operation
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e){
            Thread.interrupted();
        }
    }

    public WorkItem getWorkItem(){
        return new WorkItem("Work item 1 title", "Work item 1 description");
    }

    public Integer getLastEstimationValue(){
        return lastEstimationValue;
    }

    public void makeEstimation(int value){
        // imitation of long operation
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            Thread.interrupted();
        }
        lastEstimationValue = value;
    }

    private boolean checkUsername(String username){
        return username.equals("admin");
    }

    private boolean checkPassword(String password){
        return password.equals("admin");
    }

    private Integer lastEstimationValue;

    private Server(){}
    private static Server instance;
}
