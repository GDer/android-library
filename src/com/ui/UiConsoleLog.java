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


package com.ui;

import java.util.Date;

import android.util.Log;

public class UiConsoleLog {

	public void info(String tag, Object msg) {
		Log.i("# "  + tag, "#" + new Date().getTime() + "#" + String.valueOf(msg)); // info	
	}
	
	public void verbose(String tag, Object msg) {
		Log.v("# "  + tag, "#" + new Date().getTime() + "#" + msg); // verbose		
	}
	
	public void error(String tag, Object msg) {
		Log.e("# "  + tag, "#" + new Date().getTime() + "#" + msg); // error		
	}	
	
	public void debug(String tag, Object msg) {
		Log.d("# "  + tag, "#" + new Date().getTime() + "#" + msg); // debug		
	}
	
	public void warning(String tag, Object msg) {
		Log.w("# "  + tag, "#" + new Date().getTime() + "#" + msg); // warning		
	}

}
