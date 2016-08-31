package com.viksaaskool.two.ckout.demo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.devmarvel.creditcardentry.library.CreditCardForm;
import com.viksaaskool.two.ckout.TwoCheckoutWrapper;
import com.viksaaskool.two.ckout.callbacks.TwoCheckoutTokenCallback;
import com.viksaaskool.two.ckout.model.TwoCheckoutCard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements TwoCheckoutTokenCallback {

    @BindView(R.id.root_relative_layout)
    LinearLayout mRootLinearLayout;
    @BindView(R.id.enter_credit_card_form)
    CreditCardForm mEnterCreditCardForm;
    @BindView(R.id.ok_button)
    Button mOkButton;

    private TwoCheckoutWrapper mTwoCheckoutWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo);
        ButterKnife.bind(this);

        //set up the wrapper
        mTwoCheckoutWrapper = new TwoCheckoutWrapper(this);
        mTwoCheckoutWrapper.setTwoCheckoutTokenCallback(this);

    }


    @OnClick(R.id.ok_button)
    public void onClick() {

        if (mEnterCreditCardForm != null && mEnterCreditCardForm.isCreditCardValid()) {
            //create the credit card object
            TwoCheckoutCard twoCheckoutCard = new TwoCheckoutCard();
            twoCheckoutCard.setCcNo(mEnterCreditCardForm.getCreditCard().getCardNumber());
            twoCheckoutCard.setCvv(mEnterCreditCardForm.getCreditCard().getSecurityCode());
            twoCheckoutCard.setExpMonth(mEnterCreditCardForm.getCreditCard().getExpMonth().toString());
            twoCheckoutCard.setExpYear(mEnterCreditCardForm.getCreditCard().getExpYear().toString());
            twoCheckoutCard.setSellerId(BuildConfig.SELLER_ID);
            twoCheckoutCard.setPublishableKey(BuildConfig.PUBLISHABLE_KEY);

            //get the token
            mTwoCheckoutWrapper.get2CheckoutToken(twoCheckoutCard, BuildConfig.ENVIRONMENT);

        } else if (mRootLinearLayout != null)
            Snackbar.make(mRootLinearLayout, R.string.notif_card, Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void on2CheckoutTokenSuccess(String token) {
        if (mRootLinearLayout != null) {
            String message = String.format(getString(R.string.notif_success), token);
            Snackbar.make(mRootLinearLayout, message, Snackbar.LENGTH_SHORT).show();
        }

    }

    @Override
    public void on2CheckoutTokenError(String error) {
        if (mRootLinearLayout != null) {
            String message = String.format(getString(R.string.notif_error), error);
            Snackbar.make(mRootLinearLayout, message, Snackbar.LENGTH_SHORT).show();
        }

    }
}
