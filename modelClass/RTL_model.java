package com.example.clonningubereats.modelClass;

import java.util.ArrayList;

public class RTL_model {


    //OfferItems
    private ArrayList<OfferModel> offerItems;
    private String tabTitle, imageURLS;

    public RTL_model(ArrayList<OfferModel> offerItems, String tabTitle, String imageURLS) {
        this.offerItems = offerItems;
        this.tabTitle = tabTitle;
        this.imageURLS = imageURLS;
    }

    public ArrayList<OfferModel> getOfferItems() {
        return offerItems;
    }

    public void setOfferItems(ArrayList<OfferModel> offerItems) {
        this.offerItems = offerItems;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getImageURLS() {
        return imageURLS;
    }

    public void setImageURLS(String imageURLS) {
        this.imageURLS = imageURLS;
    }


    /////////////////////////////////////////////////////

    //History Items

    private ArrayList<HistoryItems> historyItems;
    private String historyTitle;

    public RTL_model(ArrayList<HistoryItems> historyItems, String historyTitle) {
        this.historyItems = historyItems;
        this.historyTitle = historyTitle;
    }

    public ArrayList<HistoryItems> getHistoryItems() {
        return historyItems;
    }

    public void setHistoryItems(ArrayList<HistoryItems> historyItems) {
        this.historyItems = historyItems;
    }

    public String getHistoryTitle() {
        return historyTitle;
    }

    public void setHistoryTitle(String historyTitle) {
        this.historyTitle = historyTitle;
    }


}
