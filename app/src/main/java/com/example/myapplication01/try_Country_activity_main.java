package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class try_Country_activity_main extends AppCompatActivity {

    RecyclerView recyclerView;
    List<try_Country> country_list = new ArrayList<>();
    try_CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try__country_main);
        country_list.add(new try_Country("Lucknow", "Uttar Pradesh"));
        country_list.add(new try_Country("Mumbai", "Maharashtra"));
        country_list.add(new try_Country("Dehradun", "Uttarakhand"));
        country_list.add(new try_Country("Kolkata", "WestBengal"));
        country_list.add(new try_Country("Bhopal", "Madhya Pradesh"));
        country_list.add(new try_Country("Imphal", "Manipur"));
        country_list.add(new try_Country("Shillong", "Meghalaya"));
        country_list.add(new try_Country("Aizawl", "Mizoram"));
        country_list.add(new try_Country("Chandigarh", "Punjab"));
        country_list.add(new try_Country("Panaji", "Goa"));
        country_list.add(new try_Country("Lucknow", "Uttar Pradesh"));
        country_list.add(new try_Country("Mumbai", "Maharashtra"));
        country_list.add(new try_Country("Dehradun", "Uttarakhand"));
        country_list.add(new try_Country("Kolkata", "WestBengal"));
        country_list.add(new try_Country("Bhopal", "Madhya Pradesh"));
        country_list.add(new try_Country("Imphal", "Manipur"));
        country_list.add(new try_Country("Shillong", "Meghalaya"));
        country_list.add(new try_Country("Aizawl", "Mizoram"));
        country_list.add(new try_Country("Chandigarh", "Punjab"));
        country_list.add(new try_Country("Panaji", "Goa"));

        countryAdapter = new try_CountryAdapter(country_list);
        recyclerView = findViewById(R.id.recycler_view);recyclerView.addItemDecoration(new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL));
        LinearLayoutManager layoutManager = new   LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }
}