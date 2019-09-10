package com.gzgd.rt.flink.integration.bean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ItemWithWikiInfo extends Item {
    @NotNull
    private ArrayList<String> bid;
    @NotBlank
    private String itemId;
    @NotBlank
    private String itemTitle;
    private String type;
    private String describe;
    private ArrayList<String> poolId;
    private ArrayList<String> tags;
    private Time itemTime;
    private Float Score;
    private String country;
    private WikiInfo extend;

    public ArrayList<String> getBid() {
        return bid;
    }

    public void setBid(ArrayList<String> bid) {
        this.bid = bid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public ArrayList<String> getPoolId() {
        return poolId;
    }

    public void setPoolId(ArrayList<String> poolId) {
        this.poolId = poolId;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Time getItemTime() {
        return itemTime;
    }

    public void setItemTime(Time itemTime) {
        this.itemTime = itemTime;
    }

    public Float getScore() {
        return Score;
    }

    public void setScore(Float score) {
        Score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getExtend() {
        return extend;
    }

    public void setExtend(WikiInfo extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "ItemWithWikiInfo{" +
                "bid=" + bid +
                ", itemId='" + itemId + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                ", type='" + type + '\'' +
                ", describe='" + describe + '\'' +
                ", poolId=" + poolId +
                ", tags=" + tags +
                ", itemTime=" + itemTime +
                ", Score=" + Score +
                ", country='" + country + '\'' +
                ", extend=" + extend +
                '}';
    }
}
