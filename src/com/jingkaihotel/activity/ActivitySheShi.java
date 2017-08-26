/**
 * @作者： 韩梦飞沙  2015年3月26日
 */
package com.jingkaihotel.activity;

import com.jingkaihotel.R;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * @作者  韩梦飞沙  2015年3月26日 下午1:16:19 
 * 联系：QQ:313134555 CSDN: http://blog.csdn.net/yue31313
 * 代码说明：酒店设施
 */
public class ActivitySheShi extends Activity {
	 String url = "http://mp.weixin.qq.com/s?__biz=MzAwMzM3OTU3Mg==&mid=203986668&idx=1&sn=863bc8f6528744e2812b44d4fdb15711#rd";
		WebView webView;
	/* 
	 * @作者  韩梦飞沙  2015年3月26日 下午1:23:16 
	 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 所属类：ActivityAboutMe
	 * 代码说明：
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 //设置窗口风格为进度条
     getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_she_shi);
		webView = (WebView) this.findViewById(R.id.webView);
		 WebSettings settings = webView.getSettings();
	        settings.setSupportZoom(true);          //支持缩放
	        settings.setBuiltInZoomControls(true);  //启用内置缩放装置
	        settings.setJavaScriptEnabled(true);    //启用JS脚本
	                         
	        webView.setWebViewClient(new WebViewClient() {
	            //当点击链接时,希望覆盖而不是打开新窗口
	            @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                view.loadUrl(url);  //加载新的url
	                return true;    //返回true,代表事件已处理,事件流到此终止
	            }
	        });
	                         
	        //点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
	        webView.setOnKeyListener(new View.OnKeyListener() {
	            @Override
	            public boolean onKey(View v, int keyCode, KeyEvent event) {
	                if (event.getAction() == KeyEvent.ACTION_DOWN) {
	                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
	                        webView.goBack();   //后退
	                        return true;    //已处理
	                    }
	                }
	                return false;
	            }
	        });
	                         
	        webView.setWebChromeClient(new WebChromeClient() {
	            //当WebView进度改变时更新窗口进度
	            @Override
	            public void onProgressChanged(WebView view, int newProgress) {
	                //Activity的进度范围在0到10000之间,所以这里要乘以100
	            	ActivitySheShi.this.setProgress(newProgress * 100);
	            }
	        });
	        webView.loadUrl(url);  //加载url
         webView.requestFocus(); //获取焦点            
	       
		super.onCreate(savedInstanceState);
	}
}
