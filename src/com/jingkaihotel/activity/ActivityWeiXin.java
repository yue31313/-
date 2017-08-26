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
 * @作者  韩梦飞沙  2015年3月26日 下午3:00:03 
 * 联系：Email:313134555@qq.com 
 * CSDN: http://blog.csdn.net/yue31313
 * 代码说明：微信
 */
public class ActivityWeiXin extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_wei_xin);
		super.onCreate(savedInstanceState);
	}
	public void copyUrl(View view){
		// 得到剪贴板管理器  
		ClipboardManager cmb = (ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);  
		cmb.setText("濮阳京开宾馆微信号：jingkaihotel");  
		Toast.makeText(this, "已复制", 0).show();
	}
}
