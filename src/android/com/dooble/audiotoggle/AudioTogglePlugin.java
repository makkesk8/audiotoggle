package com.dooble.audiotoggle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;

public class AudioTogglePlugin extends CordovaPlugin {
	public static final String ACTION_SET_AUDIO_MODE = "setAudioMode";
	
	@Override
	public boolean execute(String action, JSONArray args, 
			CallbackContext callbackContext) throws JSONException {	
		if (action.equals(ACTION_SET_AUDIO_MODE)) {
			if (!setAudioMode(args.getString(0))) {
				callbackContext.error("Invalid audio mode");
				return false;
			}
			
			return true;
		}
		
		callbackContext.error("Invalid action");
		return false;
	}
	
	public boolean setAudioMode(String mode) {
	    AudioManager audiMgr = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
	    
	    if (mode.equals("earpiece")) {
	    	audiMgr.setMode(AudioManager.STREAM_MUSIC);
		audiMgr.setSpeakerphoneOn(false);
	        return true;
	    } else if (mode.equals("speaker")) {        
	    	audiMgr.setMode(AudioManager.STREAM_MUSIC);
		audiMgr.setSpeakerphoneOn(true);
	        return true;
	    }
	    
	    return false;
	}

}
