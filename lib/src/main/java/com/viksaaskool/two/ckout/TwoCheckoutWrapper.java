package com.viksaaskool.two.ckout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.viksaaskool.two.ckout.callbacks.TwoCheckoutTokenCallback;
import com.viksaaskool.two.ckout.constants.Constants;
import com.viksaaskool.two.ckout.model.TwoCheckoutCard;

/**
 * Created by varsovski on 14-Jul-16.
 */
public class TwoCheckoutWrapper {

    private WebView mWebView;
    private TwoCheckoutTokenCallback mTwoCheckoutTokenCallback;

    public TwoCheckoutWrapper(Context c) {
        this.initTwoCheckoutWrapper(c);
    }

    @SuppressWarnings("all")
    private void initTwoCheckoutWrapper(Context c) {
        View view = LayoutInflater.from(c).inflate(R.layout.two_checkout_layout, null);
        mWebView = (WebView) view.findViewById(R.id.two_checkout_web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(this, Constants.TWO_CHECKOUT_WRAPPER);
        mWebView.loadUrl(Constants.TWO_CHECKOUT_HTML);
    }

    public void get2CheckoutToken(TwoCheckoutCard card, String environment) {
        if (mWebView != null && card != null) {
            mWebView.loadUrl("javascript:generateToken('" + environment + "','" + card.getCardValuesAsJSParam() + "')");
        }
    }

    public void setTwoCheckoutTokenCallback(TwoCheckoutTokenCallback twoCheckoutTokenCallback) {
        this.mTwoCheckoutTokenCallback = twoCheckoutTokenCallback;

    }

    @JavascriptInterface
    public void on2CheckoutTokenError(String error) {
        mTwoCheckoutTokenCallback.on2CheckoutTokenError(error);
    }

    @JavascriptInterface
    public void on2CheckoutTokenSuccess(String token) {
        mTwoCheckoutTokenCallback.on2CheckoutTokenSuccess(token);
    }

}
