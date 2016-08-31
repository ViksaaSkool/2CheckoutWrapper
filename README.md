# 2CheckoutWrapper

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-2CheckoutWrapper-green.svg?style=true)](http://android-arsenal.com/details/1/4262)

<img src="https://github.com/ViksaaSkool/2CheckoutWrapper/blob/master/art/main_logo.png" width="128" height="128"/>

Simple wrapper library for acquiring 2Checkout payment gateway token.

[2Checkout](https://www.2checkout.com/) is payment gateway that is widely used in almost every country in the world. It accepts Credit Cards, PayPal, and Debit Cards. Their official documentation page is [here](https://www.2checkout.com/documentation). 
Unfortunately, they don't have dedicated Android SDK, but the [official Java SDK](http://bit.ly/29DaaEm) should do the trick.

Yet, this might be too much and not all is needed on Android side. In general sense the payment is done on the server side and the only thing you need to do is to get checkout token - which is generated with the appropriate 2chekout credentials (sellerId, publisherKey and environment) and credit card details. That's where this library comes handy - it wraps the [official js library](http://bit.ly/29DbLKv), makes a call and returns the token to you.  

# Demo

<img src="https://github.com/ViksaaSkool/2CheckoutWrapper/blob/master/art/success.gif" width="210" height="330"/>
<img src="https://github.com/ViksaaSkool/2CheckoutWrapper/blob/master/art/failure.gif" width="210" height="330"/>

The gifs above are form the [demo](http://bit.ly/29D8z1i) application made to display the usage of the library. 
Note: the credit card form is not part of 2CheckoutWrapper and is sparate library, that you can check out [here](http://bit.ly/29D8YB8).



# Usage

Add it in your root build.gradle at the end of repositories:
```javascript
   allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
and then in dependencies:
```javascript
	dependencies {
	        compile 'com.github.ViksaaSkool:2CheckoutWrapper:v1.1'
	}
```

Here is how you utilze the library in your code:

```java

//or in your Fragment; don't forget to impelement the TwoCheckoutTokenCallback

public class MyActivity extends AppCompatActivity implements TwoCheckoutTokenCallback{

private TwoCheckoutWrapper mTwoCheckoutWrapper;

 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo);

        //set up the wrapper
        mTwoCheckoutWrapper = new TwoCheckoutWrapper(this);
        mTwoCheckoutWrapper.setTwoCheckoutTokenCallback(this);
        
        //call for the token 
        getTokenMethod();

    }
    
    public void getTokenMethod(){
     //create the credit card object
            TwoCheckoutCard twoCheckoutCard = new TwoCheckoutCard();
            
            //get credit card values form your field(s)
            twoCheckoutCard.setCcNo("creditCardNumber");
            twoCheckoutCard.setCvv("cVV");
            twoCheckoutCard.setExpMonth("month");
            twoCheckoutCard.setExpYear("year");
            
            //set these in local.properties and asign them via build.gradle
            twoCheckoutCard.setSellerId(BuildConfig.SELLER_ID);
            twoCheckoutCard.setPublishableKey(BuildConfig.PUBLISHABLE_KEY);

            //call for the token
            mTwoCheckoutWrapper.get2CheckoutToken(twoCheckoutCard, BuildConfig.ENVIRONMENT);
    
    }
    
    
    @Override
    public void on2CheckoutTokenSuccess(String token) {
        //do something with the token

    }

    @Override
    public void on2CheckoutTokenError(String error) {
       //handle the error

    }

}

```







License
--------

    The MIT License (MIT)

    Copyright (c) 2016 Viktor Arsovski
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.


# Developed By
Viktor Arsovski
</br>
<a href="https://mk.linkedin.com/in/varsovski">
  <img alt="Add me to Linkedin" src="http://is.gd/u42ILV" width="96" height="96"/>
</a>

