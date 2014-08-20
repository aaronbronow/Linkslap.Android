package Linkslap.Android.Communication.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public final class Storage {
	 public static final String PREFS_NAME = "Linkslap.preferences";
	 
	 public static Context Context;
	 
	 public static String GetInstallationId() {
		 String installationId = Load("InstallationId");
		 
		 if (installationId == null || installationId == "")
		 {
			 installationId = UUID.randomUUID().toString();
			 Save("InstallationId", installationId);
		 }
		 
		 return installationId;
	 }
	 
	 public static void ClearAll() {
		 File fileDirectory = Storage.Context.getFilesDir();
		 File[] files = fileDirectory.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {			
				if (filename.startsWith("NewUser") || filename.startsWith("InstallationId")) {
					return false;
				}
				
				return filename.endsWith(".setting") ;
			}
		});
		 
		 for (File file : files) {
			 file.delete();
		 }
	 }
	 
	 public static Boolean Clear(String key) {
		 if (key == null || key == "") {
			 return false;
		 }
		 
		 key = key + ".setting";
		 
		 if (!fileExistance(key)) {
			 return true;
		 }
		 
		 File file = Storage.Context.getFileStreamPath(key);
		 file.delete();
		 
		 return true;
	 }
	 
	 public static <T> Boolean Save(String key, T value) {
		 try {
			final Gson gson = new Gson();
			String output = gson.toJson(value, new TypeToken<T>(){}.getClass());
			FileOutputStream fileOutputStream = Storage.Context.openFileOutput(key + ".setting", android.content.Context.MODE_PRIVATE);
			fileOutputStream.write(output.getBytes());
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (Exception e) {
			return false;
		}
		 
		return true;
	 }
	 
	 public static <T> T Load(String key) {
        InputStream inputStream = null;
        
         key = key + ".setting";
		 if (!fileExistance(key))
		 {
			 return null;
		 }
        
        try{
        	inputStream = Storage.Context.openFileInput(key);
        } catch(final Exception e){
        	return null;
        }
		 
		 try {
            if (inputStream != null) {
                final Gson gson = new Gson();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                return gson.fromJson(reader, new TypeToken<T>(){}.getType());
            }
        } catch (final Exception e) {
        }
        return null;
    }
	 
	 private static boolean fileExistance(String fname){
	    File file = Storage.Context.getFileStreamPath(fname);
	    return file.exists();
	}
}
