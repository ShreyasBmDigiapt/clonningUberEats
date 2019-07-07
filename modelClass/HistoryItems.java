package com.example.clonningubereats.modelClass;

public class HistoryItems {

    private String historyImage, historyRestroName, historyOrderStatus, historyOrderDate, historyOrderId, historyOrderName;
    private String historyDeliverMan, historyOrderTotal, historySubToatal, historyDiscount, historyTax, historyDeliveryFee;

    public HistoryItems(String historyImage, String historyRestroName, String historyOrderStatus, String historyOrderDate, String historyOrderId, String historyOrderName,  String historyDeliverMan, String historyDeliveryFee, String historySubToatal, String historyDiscount, String historyTax, String historyOrderTotal) {
        this.historyImage = historyImage;
        this.historyRestroName = historyRestroName;
        this.historyOrderStatus = historyOrderStatus;
        this.historyOrderDate = historyOrderDate;
        this.historyOrderId = historyOrderId;
        this.historyOrderName = historyOrderName;
        this.historyDeliverMan = historyDeliverMan;
        this.historyOrderTotal = historyOrderTotal;
        this.historySubToatal = historySubToatal;
        this.historyDiscount = historyDiscount;
        this.historyTax = historyTax;
        this.historyDeliveryFee = historyDeliveryFee;
    }

    public String getHistoryImage() {
        return historyImage;
    }

    public void setHistoryImage(String historyImage) {
        this.historyImage = historyImage;
    }

    public String getHistoryRestroName() {
        return historyRestroName;
    }

    public void setHistoryRestroName(String historyRestroName) {
        this.historyRestroName = historyRestroName;
    }

    public String getHistoryOrderStatus() {
        return historyOrderStatus;
    }

    public void setHistoryOrderStatus(String historyOrderStatus) {
        this.historyOrderStatus = historyOrderStatus;
    }

    public String getHistoryOrderDate() {
        return historyOrderDate;
    }

    public void setHistoryOrderDate(String historyOrderDate) {
        this.historyOrderDate = historyOrderDate;
    }

    public String getHistoryOrderId() {
        return historyOrderId;
    }

    public void setHistoryOrderId(String historyOrderId) {
        this.historyOrderId = historyOrderId;
    }

    public String getHistoryOrderName() {
        return historyOrderName;
    }

    public void setHistoryOrderName(String historyOrderName) {
        this.historyOrderName = historyOrderName;
    }

    public String getHistoryDeliverMan() {
        return historyDeliverMan;
    }

    public void setHistoryDeliverMan(String historyDeliverMan) {
        this.historyDeliverMan = historyDeliverMan;
    }

    public String getHistoryOrderTotal() {
        return historyOrderTotal;
    }

    public void setHistoryOrderTotal(String historyOrderTotal) {
        this.historyOrderTotal = historyOrderTotal;
    }

    public String getHistorySubToatal() {
        return historySubToatal;
    }

    public void setHistorySubToatal(String historySubToatal) {
        this.historySubToatal = historySubToatal;
    }

    public String getHistoryDiscount() {
        return historyDiscount;
    }

    public void setHistoryDiscount(String historyDiscount) {
        this.historyDiscount = historyDiscount;
    }

    public String getHistoryTax() {
        return historyTax;
    }

    public void setHistoryTax(String historyTax) {
        this.historyTax = historyTax;
    }

    public String getHistoryDeliveryFee() {
        return historyDeliveryFee;
    }

    public void setHistoryDeliveryFee(String historyDeliveryFee) {
        this.historyDeliveryFee = historyDeliveryFee;
    }
}
