package com.example.myapplication01;

import java.util.ArrayList;
import java.util.List;

public class Try_DataSource {
    public static List<Try_Task> createTaskList(){
        List<Try_Task> try_tasks = new ArrayList<>();
        try_tasks.add(new Try_Task("Take out the trash",true,3));
        try_tasks.add(new Try_Task("Walk the dog",false,2));
        try_tasks.add(new Try_Task("Make my beg",false,1));
        try_tasks.add(new Try_Task("Unload my diswhaser",false,0));
        try_tasks.add(new Try_Task("Make dinner",true,5));
        return try_tasks;
    }

}
