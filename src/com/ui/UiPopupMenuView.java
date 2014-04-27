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

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;
import java.util.List;

public class UiPopupMenuView extends View {

	public UiPopupMenuView(Context context) {
		super(context);
	}

	public PopupMenu showPopupParent(View view, List list) {
		PopupMenu popupMenu = new PopupMenu(getContext(), view);
		for (int ix = 0; ix < list.size(); ix++)
			popupMenu.getMenu().addSubMenu(
					Integer.valueOf((String) ((Object[]) list.get(ix))[0]).intValue(),
					Integer.valueOf((String) ((Object[]) list.get(ix))[1]).intValue(),
					Integer.valueOf((String) ((Object[]) list.get(ix))[2]).intValue(),
					(String) ((Object[]) list.get(ix))[3]);

		return popupMenu;
	}
}