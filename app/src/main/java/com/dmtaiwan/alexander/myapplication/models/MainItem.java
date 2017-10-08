package com.dmtaiwan.alexander.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alexander on 9/25/2017.
 */

public class MainItem implements Parcelable {

    private int itemNumber;

    public MainItem(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return "This is item's awesome rating is: " + itemNumber;
    }

    protected MainItem(Parcel in) {
        itemNumber = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemNumber);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MainItem> CREATOR = new Parcelable.Creator<MainItem>() {
        @Override
        public MainItem createFromParcel(Parcel in) {
            return new MainItem(in);
        }

        @Override
        public MainItem[] newArray(int size) {
            return new MainItem[size];
        }
    };
}