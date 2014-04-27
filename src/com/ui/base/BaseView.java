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
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.PopupMenu;

public class BaseView extends View {
	public FragmentManager fragmentManager;
	public int layoutId;
	public PopupMenu popUpView;

	public BaseView(Context context,
					FragmentManager fragmentManager) {
		super(context);
		this.fragmentManager = fragmentManager;
	}

	public FragmentManager getFragmentManager() {
		return fragmentManager;
	}

	public void setFragmentManager(FragmentManager fragmentManager) {
		this.fragmentManager = fragmentManager;
	}

	public int getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(int layoutId) {
		this.layoutId = layoutId;
	}

	public PopupMenu getPopUpView() {
		return popUpView;
	}

	public void setPopUpView(PopupMenu popUpView) {
		this.popUpView = popUpView;
	}
}