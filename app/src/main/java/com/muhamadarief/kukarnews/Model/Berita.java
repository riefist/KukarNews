package com.muhamadarief.kukarnews.Model;

/**
 * Created by Muhamad Arief on 03/11/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Berita {

    @SerializedName("entry_id")
    private String entryId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("title")
    private String title;
    @SerializedName("status")
    private String status;
    @SerializedName("url_title")
    private String urlTitle;
    @SerializedName("year")
    private String year;
    @SerializedName("month")
    private String month;
    @SerializedName("day")
    private String day;
    @SerializedName("field_id_3")
    private String fieldId3;

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrlTitle() {
        return urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFieldId3() {
        return fieldId3;
    }

    public void setFieldId3(String fieldId3) {
        this.fieldId3 = fieldId3;
    }
}
