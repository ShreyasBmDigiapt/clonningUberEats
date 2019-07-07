package com.example.clonningubereats.modelClass;

import java.util.ArrayList;

public class SearchModel {

    public String searchCategoryTitle;
    public ArrayList<SearchSingleModel> searchCategoryList;

    public SearchModel(String searchCategoryTitle, ArrayList<SearchSingleModel> searchCategoryList) {
        this.searchCategoryTitle = searchCategoryTitle;
        this.searchCategoryList = searchCategoryList;
    }

    public String getSearchCategoryTitle() {
        return searchCategoryTitle;
    }

    public ArrayList<SearchSingleModel> getSearchCategoryList() {
        return searchCategoryList;
    }
}
