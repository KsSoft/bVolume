package com.mk.a2dp.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartupIntentReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		try{
				
				if(!com.mk.a2dp.billingUtil.CheckTrial.shouldLaunch(context, com.mk.a2dp.billingUtil.CheckTrial.fullVersionUri)){
					com.mk.a2dp.billingUtil.CheckTrial.notifyTrialExpired(context);
				}
				
				
			}
			catch(Exception e)
			{
				Log.e("iPlay","StartupIntentReceiver Error");
			}	
	    
		}

}
