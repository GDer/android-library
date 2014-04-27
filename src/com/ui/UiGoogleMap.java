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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class UiGoogleMap {
	private List latLng;
	private List title;
	
	public UiGoogleMap() {
		this.latLng = new ArrayList();
		this.title = new ArrayList();
	}

	public void addMarkerWithMoveAnimateCamera(GoogleMap googleMap) {
		if (latLng.size() > 0) {
			for (int ix = 0; ix < latLng.size(); ix++) {
				googleMap.addMarker((new MarkerOptions()).position((LatLng) latLng.get(ix)).title((String) title.get(ix)));
			}
			googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((LatLng) latLng.get(0), 15F));
			googleMap.animateCamera(CameraUpdateFactory.zoomTo(10F), 2000, null);
		}
	}

	public List getLatLng() {
		return latLng;
	}

	public void setLatLng(List latLng) {
		this.latLng = latLng;
	}

	public List getTitle() {
		return title;
	}

	public void setTitle(List title) {
		this.title = title;
	}
}