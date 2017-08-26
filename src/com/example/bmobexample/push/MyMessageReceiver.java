package com.example.bmobexample.push;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.bmob.push.PushConstants;
import com.jingkaihotel.R;
import com.jingkaihotel.activity.ActivityMsg;
import com.way.activity.MainActivity;


public class MyMessageReceiver extends BroadcastReceiver {

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		// 获取推送消息
		String message = intent
				.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING);
		//{"alert": "推送消息测试。。。。"}
		try {
			JSONObject obj = new JSONObject(message);
			message = obj.getString("alert");
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
				
		// 发送通知
		NotificationManager nm = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification n = new Notification();
		n.icon = R.drawable.ic_launcher;
		n.tickerText = "您有一条新消息";
		n.when = System.currentTimeMillis();
		//n.flags=Notification.FLAG_ONGOING_EVENT;  
		Intent i = new Intent();
		i.setClass(context, ActivityMsg.class);
		PendingIntent pi = PendingIntent
				.getActivity(context, 0, i, 0);
		n.setLatestEventInfo(context, "消息", message, pi);
		n.defaults |= Notification.DEFAULT_SOUND;
		n.flags = Notification.FLAG_AUTO_CANCEL;
		nm.notify(1, n);
		//这里保存消息.message
		SharedPreferences sp = context.getSharedPreferences("msg",
				Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("msg", message);
		editor.commit();
		//让主界面上的“收到的消息”改成，"收到的消息-有新消息查看"
		MainActivity.btn_msg.setText("收到的消息-有新消息查看");
	}

}
