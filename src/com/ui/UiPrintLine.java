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

import java.util.Arrays;
import java.util.List;

public class UiPrintLine {
	
	public void printList(List<Object[]> list) {
		if (null != list) {
			for (int ix = 0 ; ix < list.size(); ix++) {
				Object[] obj = (Object[]) list.get(ix);
				for (int ii = 0 ; ii < obj.length; ii++) {
					new UiConsoleLog().info("printList" + ix + " " + ii, (String) obj[ii]);
				}
			}
		}		
	}
	
	public void printListInteger(List<Integer> list) {
		if (null != list) {
			for (int ix = 0 ; ix < list.size(); ix++) {
				new UiConsoleLog().info("printListInteger" + ix , (Integer) list.get(ix));
			}
		}
	}
	
	public void printListObject(Object[] object) {	
		if (null != object) {
			new UiConsoleLog().info("printListObject", Arrays.toString(object));	
		}		       	
	}
	
	public void printListObject(List<Object[][]> list) {
		if (null != list) {
			int iy = 0;
			for (int ix = 0 ; ix < list.size(); ix++) {
				for (Object[] arr : list.get(ix)) {
					new UiConsoleLog().info("printListObject[][]" + ix + " " + iy, Arrays.toString(arr));
		            iy++;
		        }
			}
		}
	}
	
	public void printListObject(Object[][] obj) {
		if (null != obj) {
			int ix = 0;
			for (Object[] arr : obj) {
				new UiConsoleLog().info("printListObject" + ix , Arrays.toString(arr));
	            ix++;
	        }	
		}		
	}
}
