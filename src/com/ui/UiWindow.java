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

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

public class UiWindow {

	public void showProgressDialogKeyboard(Window window) {				
		window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);		
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);		
	}
	
	public void showProgressDialogKeyboard(Context context) {		
		if (context instanceof FragmentActivity) {
			this.showProgressDialogKeyboard(((FragmentActivity) context).getWindow());
		
		} else if (context instanceof Activity) {
			this.showProgressDialogKeyboard(((Activity) context).getWindow());
		}
	}
	
	public void hideOnScreenKeyBoard(Context context) {
		if (context instanceof FragmentActivity) {
			((FragmentActivity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			
		} else if (context instanceof Activity) {
			((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);					
		}
	}
	
	public void setLayout(Window window, int height, int width) {
		window.setLayout(width, height);		
	}
	
	public void setLayout(Context context, int height, int width) {
		if (context instanceof FragmentActivity) {
			this.setLayout(((FragmentActivity) context).getWindow(), height, width);
			
		} else if (context instanceof Activity) {
			this.setLayout(((Activity) context).getWindow(), height, width);							
		}
	}
}
