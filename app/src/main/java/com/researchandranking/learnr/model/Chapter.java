package com.researchandranking.learnr.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Chapter implements Parcelable {

    private String title;
    private int image;
    private String information;

    public Chapter(String title, int image, String information) {
        this.title = title;
        this.image = image;
        this.information = information;
    }

    protected Chapter(Parcel in) {
        title = in.readString();
        image = in.readInt();
        information = in.readString();
    }

    public static final Creator<Chapter> CREATOR = new Creator<Chapter>() {
        @Override
        public Chapter createFromParcel(Parcel in) {
            return new Chapter(in);
        }

        @Override
        public Chapter[] newArray(int size) {
            return new Chapter[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(image);
        dest.writeString(information);
    }
}
