package com.dmtaiwan.alexander.myapplication.main;

import android.os.AsyncTask;

import com.dmtaiwan.alexander.myapplication.models.MainItem;
import com.dmtaiwan.alexander.myapplication.utilities.MainItemComparator;
import com.dmtaiwan.alexander.myapplication.utilities.Utilities;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Alexander on 9/25/2017.
 */

public class MainAsyncTask extends AsyncTask<String, Void, ArrayList<MainItem>> {

    private static final int NUM_OF_ITEMS = 100;
    private ArrayList<MainItem> items;
    private MainListener listener;

    public MainAsyncTask(MainListener listener) {
        this.listener = listener;
    }


    @Override
    protected ArrayList<MainItem> doInBackground(String... strings) {
        //Fetch our sort order
        String sortOrder = strings[0];


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        items = new ArrayList<>();
        for (int i = 0; i < NUM_OF_ITEMS; i++) {
            MainItem item = new MainItem(i);
            items.add(item);
        }

        //Sort items based on sort order:
        switch (sortOrder) {
            case Utilities.SORT_ORDER_MOST_AWESOME:
                Collections.sort(items, new MainItemComparator(sortOrder));
                break;
            case Utilities.SORT_ORDER_LEAST_AWESOME:
                Collections.sort(items, new MainItemComparator(sortOrder));
        }
        return items;
    }

    @Override
    protected void onPostExecute(ArrayList<MainItem> items) {
        super.onPostExecute(items);
        listener.returnResults(items);
    }
}
