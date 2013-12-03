package com.mk.a2dp.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiStateChangeReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		try{
			WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
			int iWifiState = wifiManager.getWifiState();
			
			if(!com.mk.a2dp.billingUtil.CheckTrial.shouldLaunch(context, com.mk.a2dp.billingUtil.CheckTrial.fullVersionUri)){
				
				
				if(intent.getAction().equals("android.net.wifi.STATE_CHANGE") ||
						intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")){ 

					
					if((iWifiState  == WifiManager.WIFI_STATE_ENABLED)
							/*&& (IsThreadRunning.equalsIgnoreCase(com.mk.iPlayer.Audio.Data.AudioData.AIRPLAY_OFF))*/){
						com.mk.a2dp.billingUtil.CheckTrial.notifyTrialExpired(context);
					}
				}
			}
				
		}
		catch(Exception e)
		{
			Log.e("iPlay","WifiStateChangeReceiver Error");
		}
	}

}
