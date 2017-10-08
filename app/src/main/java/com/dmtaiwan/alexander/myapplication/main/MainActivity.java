package com.dmtaiwan.alexander.myapplication.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dmtaiwan.alexander.myapplication.R;
import com.dmtaiwan.alexander.myapplication.models.MainItem;
import com.dmtaiwan.alexander.myapplication.utilities.Utilities;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainListener {

    private static final String KEY_SORT_ORDER = "com.dmtaiwan.alexander.sort.order";

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ArrayList<MainItem> items;
    private String selectedSortOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setup recycler view
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        adapter = new MainAdapter();
        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        //Create an instance of our AsyncTask
        MainAsyncTask asyncTask = new MainAsyncTask(this);

        if (savedInstanceState == null) {
            //Start AsyncTask with default sort order of MOST AWESOME if this is the first run
            asyncTask.execute(Utilities.SORT_ORDER_MOST_AWESOME);
        } else {
            //Restore the selected sort order, use MOST AWESOME as default in case one hasn't been selected
            selectedSortOrder = savedInstanceState.getString(KEY_SORT_ORDER, Utilities.SORT_ORDER_MOST_AWESOME);
            asyncTask.execute(selectedSortOrder);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MainAsyncTask asyncTask = new MainAsyncTask(this);
        switch (item.getItemId()) {
            case R.id.sort_order_most_awesome:
                //Set the selected sort order so that we know which value the user selected
                selectedSortOrder = Utilities.SORT_ORDER_MOST_AWESOME;
                //start the AsyncTask
                asyncTask.execute(selectedSortOrder);
                return true;
            case R.id.sort_order_least_awesome:
                selectedSortOrder = Utilities.SORT_ORDER_LEAST_AWESOME;
                asyncTask.execute(selectedSortOrder);
                return true;
            default:
                selectedSortOrder = Utilities.SORT_ORDER_MOST_AWESOME;
                asyncTask.execute(selectedSortOrder);
                return true;
        }
    }

    @Override
    public void returnResults(ArrayList<MainItem> items) {
        this.items = items;
        adapter.setData(this.items);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_SORT_ORDER, selectedSortOrder);
        super.onSaveInstanceState(outState);
    }
}
