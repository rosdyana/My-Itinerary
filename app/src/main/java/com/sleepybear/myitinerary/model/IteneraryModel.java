/*
 * Copyright (c) Rosdyana Kusuma - 2018.
 */

package com.sleepybear.myitinerary.model;

import android.os.Parcel;
import android.os.Parcelable;

public class IteneraryModel implements Parcelable {
    private int id;
    private String title;
    private String category;
    private String description;
    private String datetime;
    private float longitude;
    private float latitude;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public IteneraryModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.category);
        dest.writeString(this.description);
        dest.writeString(this.datetime);
        dest.writeFloat(this.longitude);
        dest.writeFloat(this.latitude);
        dest.writeInt(this.status);
    }

    protected IteneraryModel(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.category = in.readString();
        this.description = in.readString();
        this.datetime = in.readString();
        this.longitude = in.readFloat();
        this.latitude = in.readFloat();
        this.status = in.readInt();
    }

    public static final Creator<IteneraryModel> CREATOR = new Creator<IteneraryModel>() {
        @Override
        public IteneraryModel createFromParcel(Parcel source) {
            return new IteneraryModel(source);
        }

        @Override
        public IteneraryModel[] newArray(int size) {
            return new IteneraryModel[size];
        }
    };
}
