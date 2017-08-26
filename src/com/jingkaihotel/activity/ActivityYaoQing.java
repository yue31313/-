/**
 * @作者： 韩梦飞沙  2015年3月26日
 */
package com.jingkaihotel.activity;

import com.jingkaihotel.R;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * @作者  韩梦飞沙  2015年3月26日 下午1:16:19 
 * 联系：QQ:313134555 CSDN: http://blog.csdn.net/yue31313
 * 代码说明：分享这个APP
 */
public class ActivityYaoQing extends Activity {
	/* 
	 * @作者  韩梦飞沙  2015年3月26日 下午1:23:16 
	 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 所属类：ActivityAboutMe
	 * 代码说明：
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_yao_qing);
		super.onCreate(savedInstanceState);
	}
	public void copyUrl(View view){
		// 得到剪贴板管理器  
		ClipboardManager cmb = (ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);  
		cmb.setText("濮阳京开宾馆应用官网：http://jingkaihotel.bmob.cn");  
		Toast.makeText(this, "已复制", 0).show();
	}
}
