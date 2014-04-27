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

import java.io.Serializable;

public abstract class BaseJsonComparableBean implements Serializable, Comparable {

	public abstract void baseCompareTo(Object object);
	public String SORT_BY_ASC = "SORT_BY_ASC";
	public String SORT_BY_DESC = "SORT_BY_DESC";
	
	public String searchBy;
	public String sortBy;
	
	public String id01;
	public String id02;
	
	public String az;
	public int azIndex;
	public String[] groupAZ;
	
	public String getCharAt(Object text, Object id) {
		return (String) String.format("%s#%s", String.valueOf(text).charAt(0), String.valueOf(id));
	}
	
	public String getCharAt(Object text) {
		return String.valueOf(String.valueOf(text).charAt(0));
	}
	
	public boolean isChar(Object text, String aChar) {
		return (boolean) String.valueOf(String.valueOf(text).charAt(0)).equals(aChar);
	}
	
	public int orderBy(String orderBy, int index) {
		return (this.equals(SORT_BY_DESC)) ? this.orderByDesc(index) : this.orderByAsc(index);
	}
	
	public int orderByAsc(int index) {
		return (index * (-1));
	}
	
	public int orderByDesc(int index) {
		return (index * (1));
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	
	public String getId01() {
		return id01;
	}

	public void setId01(String id01) {
		this.id01 = id01;
	}

	public String getId02() {
		return id02;
	}

	public void setId02(String id02) {
		this.id02 = id02;
	}
	
	public String getAz() {
		return az;
	}

	public void setAz(String az) {
		this.az = az;
	}
	
	public int getAzIndex() {
		return azIndex;
	}

	public void setAzIndex(int azIndex) {
		this.azIndex = azIndex;
	}
	
	public String[] getGroupAZ() {
		return groupAZ;
	}

	public void setGroupAZ(String[] groupAZ) {
		this.groupAZ = groupAZ;
	}

	@Override
	public int compareTo(Object object) {
		this.baseCompareTo(object);
		return (this.sortBy.equals(SORT_BY_DESC)) ? this.getId01().compareTo(this.getId02()) * (1): this.getId01().compareTo(this.getId02()) * (-1);
	}
	
}