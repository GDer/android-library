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

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.ui.impl.IntentServiceImpl;

public abstract class BaseIntentService extends IntentService {

	protected abstract void onBaseIntentService(Intent intent);

	public BaseIntentService() {
		super("");
	}

	public Intent getBaseIntent(Context context, Class zlassIntentService) {
		Intent intent = new Intent(context, zlassIntentService);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra(String.format("%s.%s", IntentServiceImpl.TO, "TO"), baseFragmentActivityBean);
		return intent;
	}

	public void setBaseFragmentActivitySerializable(Intent intent) {
		baseFragmentActivityBean = (BaseFragmentActivityBean) intent.getExtras().getSerializable(String.format("%s.%s", IntentServiceImpl.TO, "TO"));
	}

	protected BaseFragmentActivityBean baseFragmentActivityBean;
}