package com.mk.a2dp.Vol;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
 
public class Help extends Activity {
 
	private WebView webView;
 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
 
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/index.html");
 
	}
 
}
