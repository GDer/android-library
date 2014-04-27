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


package com.ui.base;

import android.content.Context;
import com.ui.UiSharePreference;

public class BaseSharePreference {

	public final static String KEY_LOGIN_EMAIL = "KEY_LOGIN_EMAIL";
	public final static String KEY_LOGIN_PASSWORD = "KEY_LOGIN_PASSWORD";
	public final static String KEY_LOGIN_AUTH = "KEY_LOGIN_AUTH";
	
	public void setAuth(Context context, String email, String password) {
		new UiSharePreference().add(context, this.KEY_LOGIN_EMAIL, email);
		new UiSharePreference().add(context, this.KEY_LOGIN_PASSWORD, password);
		new UiSharePreference().add(context, this.KEY_LOGIN_AUTH, (null == email  && null == password) ? "0" : "1");
	}
	
	public boolean isAuth(Context context) {	
		String auth = (String) new UiSharePreference().getString(context, this.KEY_LOGIN_AUTH, null);	
		return ("1".equals(auth)) ? true : false; 
	}

	public void removeUser(Context context) {
		new UiSharePreference().remove(context, this.KEY_LOGIN_EMAIL);
		new UiSharePreference().remove(context, this.KEY_LOGIN_PASSWORD);		
		new UiSharePreference().remove(context, this.KEY_LOGIN_AUTH);		
	}
	
	public void clearAll(Context context) {
		new UiSharePreference().clearAll(context);		
	}

}
