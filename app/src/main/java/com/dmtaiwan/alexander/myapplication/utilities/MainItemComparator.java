package com.dmtaiwan.alexander.myapplication.utilities;

import com.dmtaiwan.alexander.myapplication.main.MainAsyncTask;
import com.dmtaiwan.alexander.myapplication.models.MainItem;

import java.util.Comparator;

/**
 * Created by Alexander on 10/8/2017.
 */

public class MainItemComparator implements Comparator<MainItem>{

    private String sortOrder;

    public MainItemComparator(String sortOrder) {
        this.sortOrder = sortOrder;
    }


    @Override
    public int compare(MainItem obj1, MainItem obj2) {
        if (sortOrder.equals(Utilities.SORT_ORDER_MOST_AWESOME)) {
            return obj2.getItemNumber() - obj1.getItemNumber();
        } else return obj1.getItemNumber() - obj2.getItemNumber();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
