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

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.ui.UiDensity;
import com.ui.UiWindow;
import com.ui.base.sql.BaseSqlLiteHelper;
import com.ui.impl.IntentServiceImpl;

// Referenced classes of package com.ui.base:
//            BaseFragmentActivityBean, BaseSharePreference, BaseObjectFragmentActivity, BaseView

public abstract class BaseFragmentActivity extends FragmentActivity {

	public BaseFragmentActivity() {
	}

	protected BaseFragmentActivityBean baseFragmentActivityBean;
	protected BaseView baseView;
	public BaseSqlLiteHelper baseSqlLiteHelper;
	
	public abstract BaseObjectFragmentActivity baseOnCreateFragmentActivity(BaseObjectFragmentActivity baseobjectfragmentactivity);
	public abstract void setSqlHelper();
	public abstract BaseFragmentActivityBean setFragmentActivityBean();
	public abstract void setBaseView();
	public abstract void setAuth();

	public void setParentFragmentActivityBean(BaseFragmentActivityBean baseFragmentActivityBean) {
		BaseFragmentActivityBean baseFragmentActivityBeanIntent = (BaseFragmentActivityBean) 
		this.getIntent().getExtras().getSerializable(String.format("%s.%s", IntentServiceImpl.TO, "TO"));
		this.baseFragmentActivityBean = baseFragmentActivityBeanIntent;
		this.baseFragmentActivityBean.setAuth((new BaseSharePreference()).isAuth(getBaseContext()));
		this.baseFragmentActivityBean.setOrientedColumn("ORIENTATION_PORTRAIT".equals(baseFragmentActivityBeanIntent.getOriented()) ? 2 : 3);
	}

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		this.setParentFragmentActivityBean(baseFragmentActivityBean);
		new UiWindow().hideOnScreenKeyBoard(this);
		new UiDensity().getInfoDensity(this);
		this.setSqlHelper();
		this.setFragmentActivityBean();
		this.setBaseView();
		this.setAuth();
		this.baseOnCreateFragmentActivity(new BaseObjectFragmentActivity(bundle));
		baseSqlLiteHelper.close();
	}


}