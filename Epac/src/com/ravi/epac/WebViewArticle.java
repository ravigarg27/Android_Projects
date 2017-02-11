package com.ravi.epac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewArticle extends Activity {

	WebView	webview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		Intent in = getIntent();
		String page_url = in.getStringExtra("link");
		page_url = "http://www.bits-epac.org/" + page_url;
		webview = (WebView) findViewById(R.id.webpage);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl(page_url);

		webview.setWebViewClient(new DisPlayWebPageActivityClient());
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
	    	webview.goBack();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

	private class DisPlayWebPageActivityClient extends WebViewClient {
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}

}