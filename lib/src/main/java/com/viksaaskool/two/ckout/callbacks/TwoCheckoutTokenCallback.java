package com.viksaaskool.two.ckout.callbacks;

/**
 * Created by varsovski on 14-Jul-16.
 */
public interface TwoCheckoutTokenCallback {
    void on2CheckoutTokenSuccess(String token);

    void on2CheckoutTokenError(String error);
}
