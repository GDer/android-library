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

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class UiAnimation {
	public final float fromAlpha = 0.0f;
	public final float toAlpha = 1.0f;
	
	public void loadAnimation(Context context, 
								View view,
								int animId,
								int durationMillis) {
		Animation animation = AnimationUtils.loadAnimation(context, animId);
		animation.setDuration(durationMillis);
		view.startAnimation(animation);
	}
	
//	public void fade(View view, 
//					float fromAlpha, 
//					float toAlpha,
//					int duration) {
//		Animation animation = new AlphaAnimation(fromAlpha, toAlpha);  		
//		animation.setDuration(3000);				
//		view.startAnimation(animation);		
//	}
	
}
