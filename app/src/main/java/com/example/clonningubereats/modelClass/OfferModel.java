package com.example.clonningubereats.modelClass;

public class OfferModel {

    private String offerImageUrl, offerSingleTitle, offerSingleSubTitle, offerSingleTime, offerSingleRatings;

    public OfferModel( String offerImageUrl, String offerSingleTitle, String offerSingleSubTitle, String offerSingleTime, String offerSingleRatings) {
        this.offerImageUrl = offerImageUrl;
        this.offerSingleTitle = offerSingleTitle;
        this.offerSingleSubTitle = offerSingleSubTitle;
        this.offerSingleTime = offerSingleTime;
        this.offerSingleRatings = offerSingleRatings;
    }

    public String getOfferImageUrl() {
        return offerImageUrl;
    }

    public void setOfferImageUrl(String offerImageUrl) {
        this.offerImageUrl = offerImageUrl;
    }

    public String getOfferSingleTitle() {
        return offerSingleTitle;
    }

    public void setOfferSingleTitle(String offerSingleTitle) {
        this.offerSingleTitle = offerSingleTitle;
    }

    public String getOfferSingleSubTitle() {
        return offerSingleSubTitle;
    }

    public void setOfferSingleSubTitle(String offerSingleSubTitle) {
        this.offerSingleSubTitle = offerSingleSubTitle;
    }

    public String getOfferSingleTime() {
        return offerSingleTime;
    }

    public void setOfferSingleTime(String offerSingleTime) {
        this.offerSingleTime = offerSingleTime;
    }

    public String getOfferSingleRatings() {
        return offerSingleRatings;
    }

    public void setOfferSingleRatings(String offerSingleRatings) {
        this.offerSingleRatings = offerSingleRatings;
    }
}
