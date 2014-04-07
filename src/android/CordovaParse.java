package com.ccsoft.plugin;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.parse.ParseInstallation;

public class CordovaParse extends CordovaPlugin {
	
	private final String TAG = "CordovaParse";
	
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	Log.i(TAG, "action:" + action);

    	if (action.equals("getInstallationId")) {
			String id = ParseInstallation.getCurrentInstallation().getInstallationId();
			Log.d("Parse.com Plugin", "Installation Id: " + id);
			callbackContext.success(id);
			return true;
    	}
    	
    	if (action.equals("setKeyValue")) {
			if(args.length() >= 2) { 
				ParseInstallation inst = ParseInstallation.getCurrentInstallation();
				String key = args.getString(0);
				String value = args.getString(1);
				inst.add(key, value);
				inst.saveEventually();
				Log.d("Parse.com Plugin", "Saved key: " + key + " and value: " + value);
					
				callbackContext.success("");
				return true;
			}
    	}
    	
        return false;
    }
}