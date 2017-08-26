/**
 * @作者： 韩梦飞沙  2015年3月26日
 */
package com.jingkaihotel.activity;

import java.util.Iterator;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.jingkaihotel.R;
import com.way.activity.MainActivity;


/**
 * @作者  韩梦飞沙  2015年3月26日 下午1:16:19 
 * 联系：QQ:313134555 CSDN: http://blog.csdn.net/yue31313
 * 代码说明：消息
 */
public class ActivityMsg extends Activity {
	TextView textView;
	/* 
	 * @作者  韩梦飞沙  2015年3月26日 下午1:23:16 
	 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 所属类：ActivityAboutMe
	 * 代码说明：
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_msg);
		textView = (TextView) findViewById(R.id.textView);
		//从偏好设置里读取消息.消息内容，和时间.
		SharedPreferences sp = getSharedPreferences("msg",
				Context.MODE_PRIVATE);
		String msg = sp.getString("msg", "暂没有消息");
		textView.setText(msg);
		super.onCreate(savedInstanceState);
	}
}
