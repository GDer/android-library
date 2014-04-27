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
package com.ui.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import android.content.Context;

public class IOFile {
	
	public boolean isFileExist(Context context, String path, String fileName) {		 
		return (boolean) ((File) context.getFileStreamPath(String.format("%s/%s", path, fileName))).exists();		
	}
	
	public boolean isFileAssetOpen(Context context, String path, String fileName) {	// isFileExist 		
		try {			
			return (0 < this.getAssertFile(context, path, fileName).trim().length()) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public String getTextByInputStream(InputStream inputStream) throws Exception {			
		Writer writer = new StringWriter();
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        int ix;
        char[] buffer = new char[2048];
        while ((ix = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, ix);                
        }
		return writer.toString();			
	}
	
	public String getAssertFile(Context context, String path, String fileName) {
		InputStream inputStream = null;
		String result = "";
		try {
			inputStream = (InputStream) context.getAssets().open(String.format("%s/%s", path, fileName));
			result = (String) this.getTextByInputStream(inputStream);	
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public String getFile(Context context, String path, String fileName) {
		InputStream inputStream = null;
		String result = "";
		try {
			inputStream = (InputStream) new BufferedInputStream(new FileInputStream(new File(context.getFilesDir(), String.format("%s/%s", path, fileName))));
			result = (String) this.getTextByInputStream(inputStream);
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public static final int CONTEXT_MODE_APPEND = Context.MODE_APPEND;
	public static final int CONTEXT_MODE_ENABLE_WRITE_AHEAD_LOGGING = Context.MODE_ENABLE_WRITE_AHEAD_LOGGING;	
	public static final int CONTEXT_MODE_MULTI_PROCESS = Context.MODE_MULTI_PROCESS;	
	public static final int CONTEXT_MODE_PRIVATE = Context.MODE_PRIVATE;
	public static final int CONTEXT_MODE_WORLD_READABLE = Context.MODE_WORLD_READABLE;	
	public static final int CONTEXT_MODE_WORLD_WRITEABLE = Context.MODE_WORLD_WRITEABLE;	
	public void saveFile(Context context, int mode, String path, String fileName, String data) throws FileNotFoundException, IOException {
		FileOutputStream fileOutputStream = null;		
		try {
			fileOutputStream = (FileOutputStream) context.openFileOutput(String.format("%s/%s", path, fileName), mode);
			fileOutputStream.write(data.getBytes());
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
