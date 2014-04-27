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

import android.app.Dialog;
import android.content.Context;

public class UiDialog {

	public UiDialog() {
	}

	public Dialog uiShow(Context context, String title) {
		Dialog dialog = new Dialog(context);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setCancelable(true);
		dialog.setTitle(((CharSequence) (title != null && title.length() > 0 ? ((CharSequence) (title)) : "No Record Found.")));
		dialog.show();
		return dialog;
	}
}