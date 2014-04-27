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

import android.net.Uri;
import java.net.URI;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class UiHttp {

	public UiHttp() {
	}

	public String getHttpResponse(String url) throws Exception {
        org.apache.http.HttpEntity httpEntity;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI(url));
        HttpResponse httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity);
    }

	public String getUrlEncode(String url) throws Exception {
        return URLEncoder.encode(url, "utf-8");
    }

	public android.net.Uri.Builder getNetURIBuilderUrl(String url) {
		return Uri.parse(url).buildUpon();
	}

	public android.net.Uri.Builder getNetURIAppendQueryParameter(
			android.net.Uri.Builder builder, String key, String value) {
		return builder.appendQueryParameter(key, value);
	}

	public String getNetURIToString(android.net.Uri.Builder builder) {
		return builder.build().toString();
	}
}