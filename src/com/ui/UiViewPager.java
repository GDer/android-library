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

public class UiViewPager {
	public static final int FIELD_HEAD = 1;
	public static final int FIELD_BODY = 2;
	public static final int FIELD_TAIL = 3;
	
	public static final String FIELD_FIRST = "FIELD_FIRST";
	public static final String FIELD_LAST = "FIELD_LAST";
	
	public int pagerNavCurrent(int position, int length) { // 1, 2, 3		
		int head = ((0 == position) && (0 == length)) ? this.FIELD_HEAD : 0;
		int body = (((0 < position) && (position < length)) && ((0 != position) && (0 != length))) ? this.FIELD_BODY : 0;
		int tail = (position == length) ? this.FIELD_TAIL : 0; 		
		int sum = (int) (head + body + tail);
		sum = ((sum >= 1) && (sum <= 3)) ? sum : 1;
		return (int) (head + body + tail);		
	}
	
	public String pagerImages(int position, int length) { // first last		
		int pager = this.pagerNavCurrent(position, length);
		return ((1 == pager) || (2 == pager)) ? this.FIELD_FIRST : this.FIELD_LAST; 
	}
			
}
