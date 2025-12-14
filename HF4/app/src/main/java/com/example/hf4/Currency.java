package com.example.hf4;
public class Currency {
    private final String code;
    private final String name;
    private final int flagResId; // Erőforrás ID (R.drawable.xxx)
    private final String buyingRate;
    private final String sellingRate;

    public Currency(String code, String name, int flagResId, String buyingRate, String sellingRate) {
        this.code = code;
        this.name = name;
        this.flagResId = flagResId;
        this.buyingRate = buyingRate;
        this.sellingRate = sellingRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getFlagResId() {
        return flagResId;
    }

    public String getBuyingRate() {
        return buyingRate;
    }

    public String getSellingRate() {
        return sellingRate;
    }
}
