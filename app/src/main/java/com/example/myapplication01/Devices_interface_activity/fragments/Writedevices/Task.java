package com.example.myapplication01.Devices_interface_activity.fragments.Writedevices;

public class Task {
    private String description;
    private boolean isComplete;
    private int priority;

    public Task(String description, boolean isComplete, int priority){
        this.description = description;
        this.isComplete = isComplete;
        this.priority = priority;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isComplete() {return isComplete;}

    public void setComplete(boolean complete) {this.isComplete = complete;}


}
