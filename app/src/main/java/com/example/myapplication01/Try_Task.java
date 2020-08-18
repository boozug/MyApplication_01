package com.example.myapplication01;

public class Try_Task {
    private String description;
    private boolean isComplete;
    private int priority;

    public Try_Task(String description, boolean isComplete, int priority){
        this.description = description;
        this.isComplete = isComplete;
        this.priority = priority;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean getIsComplete() {return isComplete;}

    public void setComplete(boolean complete) {this.isComplete = complete;}

    public int getPriority() {return priority;}

    public void setPriority(int priority) {this.priority = priority;}
}
