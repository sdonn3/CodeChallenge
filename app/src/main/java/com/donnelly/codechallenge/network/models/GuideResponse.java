package com.donnelly.codechallenge.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Steve on 6/19/2017.
 */

public class GuideResponse {
    private int total;
    @SerializedName("data")
    private List<Guide> guides;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public void setGuides(List<Guide> guides) {
        this.guides = guides;
    }
}
