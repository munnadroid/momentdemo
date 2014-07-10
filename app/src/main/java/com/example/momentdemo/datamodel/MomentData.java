package com.example.momentdemo.datamodel;

/**
 * Created by munnadroid on 7/10/14.
 */
public class MomentData {

    private int id;
    private String username;

    public MomentData(){
    }

    public MomentData(int id, String username){
        this.id=id;
        this.username=username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
