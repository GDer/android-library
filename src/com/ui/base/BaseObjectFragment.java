/*
 * Copyright (C) 2013 
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

package com.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseObjectFragment  {
	public Bundle bundle;	
	public Context context;
	public View view;
	public Intent intent;
	public AssetManager assetManager;
	public LayoutInflater layoutInflater;
	public ViewGroup viewGroup;
	
	
	public BaseObjectFragment(Bundle bundle,
								Intent intent,								
								Context context,
								AssetManager assetManager,
								LayoutInflater layoutInflater,
								ViewGroup viewGroup) {
		this.bundle = bundle;
		this.intent = intent;
		this.context = context;
		this.assetManager = assetManager;
		this.layoutInflater = layoutInflater;
		this.viewGroup = viewGroup;
	}
	
	public Bundle getBundle() {
		return bundle;
	}
	
	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}
	
	public View getView() {
		return view;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public Intent getIntent() {
		return intent;
	}
	
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}
	
	public void setAssetManager(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public LayoutInflater getLayoutInflater() {
		return layoutInflater;
	}

	public void setLayoutInflater(LayoutInflater layoutInflater) {
		this.layoutInflater = layoutInflater;
	}

	public ViewGroup getViewGroup() {
		return viewGroup;
	}

	public void setViewGroup(ViewGroup viewGroup) {
		this.viewGroup = viewGroup;
	}
}
