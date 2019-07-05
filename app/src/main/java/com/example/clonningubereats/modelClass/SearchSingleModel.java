package com.example.clonningubereats.modelClass;

public class SearchSingleModel {

    public String searchSingleImageText;
    public String searchSingleImageURl;

    public SearchSingleModel(String searchSingleImageText, String searchSingleImageURl) {
        this.searchSingleImageText = searchSingleImageText;
        this.searchSingleImageURl = searchSingleImageURl;
    }

    public String getSearchSingleImageText() {
        return searchSingleImageText;
    }

    public String getSearchSingleImageURl() {
        return searchSingleImageURl;
    }

    public void setSearchSingleImageText(String searchSingleImageText) {
        this.searchSingleImageText = searchSingleImageText;
    }

    public void setSearchSingleImageURl(String searchSingleImageURl) {
        this.searchSingleImageURl = searchSingleImageURl;
    }
}
