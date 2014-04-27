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

import com.ui.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class UiFragmentManager {
	
	public void eg(FragmentManager fragmentManager,
						BaseFragment baseFragment,	
						int fragmentId) {
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(fragmentId, baseFragment);
		fragmentTransaction.commit();	
	}
	
	public Fragment getFragment(FragmentManager fragmentManager, int fragmentId) {				
		return (BaseFragment) fragmentManager.findFragmentById(fragmentId);
	}
	
	public Fragment getFragmentAdd(FragmentManager fragmentManager,
									Fragment fragment,	
									int fragmentId) {
		return (Fragment) this.getFragmentAdd(fragmentManager, fragment, fragmentId);
	}
	
	public Fragment getFragmentAdd(FragmentManager fragmentManager,
										BaseFragment baseFragment,	
										int fragmentId) {
		BaseFragment isNullFragement = (BaseFragment) fragmentManager.findFragmentById(fragmentId);
		if (null == isNullFragement) {
			fragmentManager.beginTransaction().add(fragmentId, baseFragment).commit();					
		} else {
			fragmentManager.beginTransaction().attach(baseFragment).commit();						
		}			       
		return (Fragment) fragmentManager.findFragmentById(fragmentId);
	}
	
	public Fragment getFragmentReplace(FragmentManager fragmentManager,
										BaseFragment baseFragment,	
										int fragmentId) {		
		fragmentManager.beginTransaction().remove(baseFragment).commit();			
		fragmentManager.beginTransaction().add(fragmentId, baseFragment).commit();		
		return (Fragment) fragmentManager.findFragmentById(fragmentId);
	}
}