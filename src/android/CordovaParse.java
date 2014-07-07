package com.ccsoft.plugin;

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
			Log.i(TAG, "Installation Id: " + id);
			callbackContext.success(id);
			return true;
    	}
    	
    	if (action.equals("setKeyValue")) {
			if(args.length() >= 2) { 
				ParseInstallation inst = ParseInstallation.getCurrentInstallation();
				String key = args.getString(0);
				String value = args.getString(1);
				inst.put(key, value);
				inst.saveEventually();
				Log.i(TAG, "Saved key: " + key + " and value: " + value);
					
				callbackContext.success("");
			} else {
				callbackContext.error("invalid number of params passed");
			}
				
			return true;
    	}
    	
        return false;
    }
}
