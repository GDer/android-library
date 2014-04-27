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
import android.util.DisplayMetrics;

public class UiDensity {
	
	public String getDensityDpiByString(Context context) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		if (DisplayMetrics.DENSITY_XXHIGH == displayMetrics.densityDpi) {
			return "DENSITY_XXHIGH";
		} else if (DisplayMetrics.DENSITY_XHIGH == displayMetrics.densityDpi) {
			return "DENSITY_XHIGH";
		} else if (DisplayMetrics.DENSITY_HIGH == displayMetrics.densityDpi) {
			return "DENSITY_HIGH";
		} else if (DisplayMetrics.DENSITY_MEDIUM == displayMetrics.densityDpi) {
			return "DENSITY_MEDIUM";
		} else if (DisplayMetrics.DENSITY_LOW == displayMetrics.densityDpi) {
			return "DENSITY_LOW";
		} else if (DisplayMetrics.DENSITY_DEFAULT == displayMetrics.densityDpi) {
			return "DENSITY_DEFAULT";
		} else if (DisplayMetrics.DENSITY_TV == displayMetrics.densityDpi) {
			return "DENSITY_TV";
		}
		return "NOT_FOUND";
	}
	public int getDensityDpi(Context context) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.densityDpi;		
	}
	
	public int getDensityWidthPixels(Context context) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return (int) displayMetrics.widthPixels;
	}
	
	public int getDensityWidthPixels(Context context, int percentage) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return ((int) (float) ((displayMetrics.widthPixels * percentage) / 100));
	}
	
	public int getDensityHeightPixels(Context context, int percentage) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return ((int) (float) ((displayMetrics.heightPixels * percentage) / 100));
	}
	
	public int getDensityHeightPixels(Context context) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return (int) displayMetrics.heightPixels;
	}
	
	public void getInfoDensity(Context context) {		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		new UiConsoleLog().info("density", displayMetrics.density);
		new UiConsoleLog().info("density.dpi", this.getDensityDpiByString(context));
		new UiConsoleLog().info("density.widthPixels", displayMetrics.widthPixels);
		new UiConsoleLog().info("density.heightPixels", displayMetrics.heightPixels);
		new UiConsoleLog().info("density.xdpi", displayMetrics.xdpi);
		new UiConsoleLog().info("density.ydpi", displayMetrics.ydpi);
		new UiConsoleLog().info("density.widthPixels.50", this.getDensityWidthPixels(context, 50));
		new UiConsoleLog().info("density.heightPixels.50", this.getDensityHeightPixels(context, 50));		
	}
}