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

package com.ui.io;

import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

// http://stackoverflow.com/questions/477572/strange-out-of-memory-issue-while-loading-an-image-to-a-bitmap-object/823966#823966
// http://stackoverflow.com/questions/11681274/get-bitmap-width-and-height-without-loading-to-memory
// http://developer.android.com/reference/android/graphics/BitmapFactory.Options.html#inJustDecodeBounds

public class IOImage {
	
	public Drawable getResourcesImage(Resources resources, int drawableId) {
		return (Drawable) resources.getDrawable(drawableId);
	}
	
	public Bitmap getAssertImage(Context context, 
								String path, 
								String fileName,
								int width,
								int height) {
		try {
			InputStream inputStream = context.getAssets().open(String.format("%s/%s", path, fileName));
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			BitmapFactory.Options options = new BitmapFactory.Options(); 
			options.inPurgeable = true;
			bitmap = (Bitmap) Bitmap.createScaledBitmap(bitmap, width, height, false);
			inputStream.close();
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public Bitmap getAssertImage(Context context, 
									String path, 
									String fileName) {
		try {
			InputStream inputStream = context.getAssets().open(String.format("%s/%s", path, fileName));
			BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
			bitmapOptions.inPurgeable = true;
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, bitmapOptions);
			int imageWidth = bitmapOptions.outWidth;
			int imageHeight = bitmapOptions.outHeight;
			inputStream.close();
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}	
}
