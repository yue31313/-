package com.way.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import com.jingkaihotel.R;
import com.jingkaihotel.activity.ActivityAboutMe;
import com.jingkaihotel.activity.ActivityCallWaiter;
import com.jingkaihotel.activity.ActivityEmail;
import com.jingkaihotel.activity.ActivityHotelAddress;
import com.jingkaihotel.activity.ActivityHotelAlbum;
import com.jingkaihotel.activity.ActivityHotelGoods;
import com.jingkaihotel.activity.ActivityHotelNote;
import com.jingkaihotel.activity.ActivityHotelWeiBo;
import com.jingkaihotel.activity.ActivityJianJia;
import com.jingkaihotel.activity.ActivityMsg;
import com.jingkaihotel.activity.ActivityQQ;
import com.jingkaihotel.activity.ActivitySheShi;
import com.jingkaihotel.activity.ActivityWeiXin;
import com.jingkaihotel.activity.ActivityYaoQing;
import com.jingkaihotel.activity.ActivityYiLong;
import com.jingkaihotel.activity.ActivityZiLiao;
import com.way.fragment.RecentChatFragment;
import com.way.fragment.SettingsFragment;
import com.way.slidingmenu.BaseSlidingFragmentActivity;
import com.way.slidingmenu.SlidingMenu;


public class MainActivity extends BaseSlidingFragmentActivity {

	private SlidingMenu mSlidingMenu;
	public static Button btn_msg ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initSlidingMenu();
		setContentView(R.layout.main_center_layout);
		initViews();

		// 初始化BmobSDK
		Bmob.initialize(this, "a475905c5503cac3d565d588796671ef");
		// 使用推送服务时的初始化操作
		BmobInstallation.getCurrentInstallation(this).save();
		// 启动推送服务
		BmobPush.startWork(this, "a475905c5503cac3d565d588796671ef");
		btn_msg = (Button) findViewById(R.id.btn_msg); 
	}

	private void initSlidingMenu() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int mScreenWidth = dm.widthPixels;// 获取屏幕分辨率宽度
		setBehindContentView(R.layout.main_left_layout);// 设置左菜单
		FragmentTransaction mFragementTransaction = getSupportFragmentManager()
				.beginTransaction();
		Fragment mFrag = new RecentChatFragment();
		//		Fragment mFrag  = null;
		mFragementTransaction.replace(R.id.main_left_fragment, mFrag);
		mFragementTransaction.commit();
		// customize the SlidingMenu
		mSlidingMenu = getSlidingMenu();
		mSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);// 设置是左滑还是右滑，还是左右都可以滑，我这里左右都可以滑
		mSlidingMenu.setShadowWidth(mScreenWidth / 40);// 设置阴影宽度
		mSlidingMenu.setBehindOffset(mScreenWidth / 8);// 设置菜单宽度
		mSlidingMenu.setFadeDegree(0.35f);// 设置淡入淡出的比例
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		mSlidingMenu.setShadowDrawable(R.drawable.shadow_left);// 设置左菜单阴影图片
		mSlidingMenu
				.setSecondaryShadowDrawable(R.drawable.shadow_right);// 设置右菜单阴影图片
		mSlidingMenu.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
		mSlidingMenu.setBehindScrollScale(0.333f);// 设置滑动时拖拽效果
	}

	private void initViews() {
		mSlidingMenu.setSecondaryMenu(R.layout.main_right_layout);
		FragmentTransaction mFragementTransaction = getSupportFragmentManager()
				.beginTransaction();
		Fragment mFrag = new SettingsFragment();
		mFragementTransaction
				.replace(R.id.main_right_fragment, mFrag);
		mFragementTransaction.commit();
	}

	/**关于-宾馆信息*/
	public void aboueMe(View v) {
		startActivity(new Intent(this, ActivityAboutMe.class));
	}

	/**邮箱*/
	public void huaFeiChongZhi(View v) {
		startActivity(new Intent(this, ActivityEmail.class));
	}

	/**资料集合*/
	public void weatherSearch(View v) {
		startActivity(new Intent(this, ActivityZiLiao.class));
	}

	/**宾馆QQ*/
	public void hotelNews(View v) {
		startActivity(new Intent(this, ActivityQQ.class));
	}

	/**宾馆微信*/
	public void autoChat(View v) {
		startActivity(new Intent(this, ActivityWeiXin.class));
	}

	/**手机入住立减13元*/
	public void jianJia(View v) {
		startActivity(new Intent(this, ActivityJianJia.class));
	}

	/**分享这个应用*/
	public void yaoQing(View v) {
		startActivity(new Intent(this, ActivityYaoQing.class));
	}

	/**收到的消息*/
	public void chouJiang(View v) {
		startActivity(new Intent(this, ActivityMsg.class));
		btn_msg.setText("收到的消息");
	}

	/**艺龙入住返现13元*/
	public void yiLong(View v) {
		startActivity(new Intent(this, ActivityYiLong.class));
	}

	/**宾馆新浪微博*/
	public void guaGuaKa(View v) {
		startActivity(new Intent(this, ActivityHotelWeiBo.class));
	}

	/**宾馆地址*/
	public void hotelWifi(View v) {
		startActivity(new Intent(this, ActivityHotelAddress.class));
	}

	/**入住须知*/
	public void hotelNote(View v) {
		startActivity(new Intent(this, ActivityHotelNote.class));
	}

	/**呼叫前台*/
	public void callWaiter(View v) {
		startActivity(new Intent(this, ActivityCallWaiter.class));
	}

	/**宾馆商品*/
	public void hotelGoods(View v) {
		startActivity(new Intent(this, ActivityHotelGoods.class));
	}

	/**相册*/
	public void hotelAlbum(View v) {
		startActivity(new Intent(this, ActivityHotelAlbum.class));
	}

	/**酒店设施及交通位置*/
	public void sheShi(View v) {
		startActivity(new Intent(this, ActivitySheShi.class));
	}
}
