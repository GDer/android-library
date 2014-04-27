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

import java.io.Serializable;
import java.util.List;

public class BaseFragmentActivityBean implements Serializable {
	public boolean isAuth;
	public String fr;
	public String to;
	public String oriented;
	public int orientedColumn;
	public int id;
	public int refId;
	
	private List<Object[]> featureBeanList;
	private List<Object[]> categoryBeanList;
	private List<Object[][]> azBeanList;
	private String[] azIndex ;
	
	public BaseFragmentActivityBean() {
		
	}
	
	public BaseFragmentActivityBean(boolean isAuth,
									String fr,
									String to,
									String oriented,
									int orientedColumn) {	
		this.isAuth = isAuth;
		this.fr = fr;
		this.to = to;
		this.oriented = oriented;		
		this.orientedColumn = orientedColumn;
	}
	
	
	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getOriented() {
		return oriented;
	}

	public void setOriented(String oriented) {
		this.oriented = oriented;
	}

	public int getOrientedColumn() {
		return orientedColumn;
	}

	public List<Object[]> getFeatureBeanList() {
		return featureBeanList;
	}

	public void setFeatureBeanList(List<Object[]> featureBeanList) {
		this.featureBeanList = featureBeanList;
	}

	public List<Object[]> getCategoryBeanList() {
		return categoryBeanList;
	}

	public void setCategoryBeanList(List<Object[]> categoryBeanList) {
		this.categoryBeanList = categoryBeanList;
	}

	public List<Object[][]> getAzBeanList() {
		return azBeanList;
	}

	public void setAzBeanList(List<Object[][]> azBeanList) {
		this.azBeanList = azBeanList;
	}

	public String[] getAzIndex() {
		return azIndex;
	}

	public void setAzIndex(String[] azIndex) {
		this.azIndex = azIndex;
	}

	public void setOrientedColumn(int orientedColumn) {
		this.orientedColumn = orientedColumn;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(String.format("id=%s \n", this.id));
		stringBuffer.append(String.format("refId=%s \n", this.refId));
		stringBuffer.append(String.format("isAuth=%s \n", this.isAuth));
		stringBuffer.append(String.format("to=%s \n", this.to));
		stringBuffer.append(String.format("fr=%s \n", this.fr));
		stringBuffer.append(String.format("oriented=%s \n", this.oriented));
		stringBuffer.append(String.format("orientedColumn=%s \n", this.orientedColumn));
		return stringBuffer.toString();
	}


}