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

public class UiExpandableGridView {
	public int getGridViewHeightWhenExpandable(int gridVieHeight,
												int gridViewSpace,
												int recordSize,
												int gridViewColumn) {
		new UiConsoleLog().info("height.divide=", String.valueOf((recordSize / gridViewColumn)));
		new UiConsoleLog().info("height.moduler=", String.valueOf(((recordSize % gridViewColumn) > 0) ? 1 : 0));
		new UiConsoleLog().info("height.recordSize=", String.valueOf(recordSize));	
		int fxHeight = (Integer) (gridVieHeight + gridViewSpace);
		int hdHeight = 1; // less then 3
		int bdyHeight = (recordSize / gridViewColumn);
		int tlHeight = (((recordSize % gridViewColumn) > 0) ? 1 : 0);
		return (recordSize > 0 && recordSize <= 3) ? (hdHeight * fxHeight) : ((bdyHeight + tlHeight) * fxHeight);
	}
}

