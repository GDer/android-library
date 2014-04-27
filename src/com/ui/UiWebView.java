/*
 * Copyright (C) 2013 GDer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ui;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.webkit.WebView;

public class UiWebView extends WebView {
	public static final String MIME = "text/html";
	public static final String ENCODING_UTF = "utf-8";
	public static final String JAVA_INTERFACE = "jsinterface";
	
	public UiWebView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
	}
	
	public UiWebView(Context context) {
		super(context);
	}
	
	public void loadUrl(boolean isJavaScriptEnadbled, Context context,
			String loadUrl) {
		this.getSettings().setJavaScriptEnabled(isJavaScriptEnadbled);
		this.addJavascriptInterface(((Activity) context), this.JAVA_INTERFACE);
		this.loadUrl(loadUrl);
	}

	public void loadUrl(boolean isJavaScriptEnadbled, String loadUrl) {
		this.getSettings().setJavaScriptEnabled(isJavaScriptEnadbled);
		this.loadUrl(loadUrl);
	}

	public void loadData(boolean isJavaScriptEnadbled, String data,
			String mimeType, String encoding) { // custom html
		this.getSettings().setJavaScriptEnabled(isJavaScriptEnadbled);
		this.loadData(data, mimeType, encoding);
	}

	public void loadHtml(boolean isJavaScriptEnadbled,
						AssetManager assetManager,
						String fileName, 
						String mimeType,
						String encoding) { // custom html
		try {
			this.getSettings().setJavaScriptEnabled(isJavaScriptEnadbled);
			InputStream inputStream = assetManager.open(fileName);
			int size = inputStream.available();
			byte[] buffer = new byte[size];
			inputStream.read(buffer);
			inputStream.close();
			this.loadData(new String(buffer), mimeType, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
