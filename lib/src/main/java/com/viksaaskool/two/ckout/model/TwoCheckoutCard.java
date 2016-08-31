package com.viksaaskool.two.ckout.model;

/**
 * Created by varsovski on 14-Jul-16.
 */
public class TwoCheckoutCard {

    private String publishableKey;
    private String ccNo;
    private String cvv;
    private String sellerId;
    private String expMonth;
    private String expYear;

    public String getPublishableKey() {
        return publishableKey;
    }

    public void setPublishableKey(String publishableKey) {
        this.publishableKey = publishableKey;
    }

    public String getCcNo() {
        return ccNo;
    }

    public void setCcNo(String ccNo) {
        this.ccNo = ccNo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getCardValuesAsJSParam(){
        return "{\"publishableKey\" : " + "\"" + this.publishableKey + "\""
                + ",\"ccNo\" : " + "\"" + this.ccNo + "\""
                + ",\"cvv\" : " + "\"" + this.cvv + "\""
                + ",\"sellerId\" : " + "\"" + this.sellerId + "\""
                + ",\"expMonth\" : " + "\"" + this.expMonth + "\""
                + ",\"expYear\" : " + "\"" + this.expYear + "\"}";
    }
}
