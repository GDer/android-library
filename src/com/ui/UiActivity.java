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

import java.util.Map;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.view.Display;

/*
 * context -> activity
 * 
 */
public class UiActivity {
	public static final String ORIENTATION_PORTRAIT = "ORIENTATION_PORTRAIT";
	public static final String ORIENTATION_REVERSE_PORTRAIT = "ORIENTATION_REVERSE_PORTRAIT";
	public static final String ORIENTATION_LANDSCAPE = "ORIENTATION_LANDSCAPE";
	public static final String ORIENTATION_REVERSE_LANDSCAPE = "ORIENTATION_REVERSE_LANDSCAPE";
	
	public String getOrientationRotation(Context context) {
		int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
	
		if (rotation == 0 || rotation == 2) {
			return this.ORIENTATION_LANDSCAPE;
		} else if (rotation == 3 || rotation == 1) {
			return this.ORIENTATION_PORTRAIT;
		} 
		return this.ORIENTATION_PORTRAIT;
	}
	
	private int getScreenOrientation(Context context){
        return ((Display) ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()).getOrientation();        
	}
	
	public void startIntentServiceActivity(IntentService intentService,
											Intent intent, 
											Class<?> zls) { // intent service	
		intent.setClass(intentService.getBaseContext(), zls);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intentService.getApplication().startActivity(intent);
	}
	
	public void startServiceActivity(Context context, Intent intent) {
		context.startService(intent);	
	}
	
	public void startServiceActivity(Activity activity, Intent intent) {
		activity.startService(intent);		
	}
		
	public void startFragmentActivity(FragmentActivity fragmentActivity, 
										Class <?> zls,
										final Map<String, String> intentParameter) {
		Intent intent = (Intent) fragmentActivity.getIntent();
		intent.setClass(fragmentActivity.getBaseContext(), zls);	
		if (null != intentParameter) {
			for (Map.Entry<String, String> entry : intentParameter.entrySet()) {
				intent.putExtra(entry.getKey(), entry.getValue());
			}
		}
		
		fragmentActivity.startActivity(intent);
		fragmentActivity.finish();
	}
	
	public void startFragmentActivity(Context context, 
										Class <?> zls,
										final Map<String, String> intentParameter) {
		FragmentActivity fragmentActivity = ((FragmentActivity) context);
		Intent intent = (Intent) fragmentActivity.getIntent();
		intent.setClass(context, zls);	
		if (null != intentParameter) {
			for (Map.Entry<String, String> entry : intentParameter.entrySet()) {
				intent.putExtra(entry.getKey(), entry.getValue());
			}
		}
	
		fragmentActivity.startActivity(intent);
		fragmentActivity.finish();
	}
	
	public void startActivity(Activity activity, 
								Class <?> zls,
								final Map<String, String> intentParameter) {
		Intent intent = (Intent) activity.getIntent();
		intent.setClass(activity.getBaseContext(), zls);	
		if (null != intentParameter) {
			for (Map.Entry<String, String> entry : intentParameter.entrySet()) {
				intent.putExtra(entry.getKey(), entry.getValue());
			}
		}
		activity.startActivity(intent);
		activity.finish();
	}
	
	public void startActivity(Context context, 
								Class <?> zls,
								final Map<String, String> intentParameter) {
		
		Activity activity = ((Activity) context);		
		Intent intent = (Intent) activity.getIntent();
		intent.setClass(context, zls);
		if (null != intentParameter) {
			for (Map.Entry<String, String> entry : intentParameter.entrySet()) {
				intent.putExtra(entry.getKey(), entry.getValue());
			}
		}
		activity.startActivity(intent);
		activity.finish();
	}
	
	public void finish(Context context) {
		((Activity) context).finish();	
	}
}
