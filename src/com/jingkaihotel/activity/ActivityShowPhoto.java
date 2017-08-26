/**
 * @作者： 韩梦飞沙  2015年3月26日
 */
package com.jingkaihotel.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jingkaihotel.R;


/**
 * @作者  韩梦飞沙  2015年3月26日 下午1:16:19 
 * 联系：QQ:313134555 CSDN: http://blog.csdn.net/yue31313
 * 代码说明：显示图片
 */
public class ActivityShowPhoto extends Activity {
	private LayoutInflater inflater; 
	private List<View> views = new ArrayList<View>(); 
	ViewPager viewPager;
	private PagerAdapter adapter = new PagerAdapter(){
		View view;
		ImageView imageView;
		TextView textView;
		@Override
		public int getCount() {
			return ActivityHotelAlbum.resoureId.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		/** 
         * 销毁当前page的相隔2个及2个以上的item时调用 
         */  
        @Override  
        public void destroyItem(ViewGroup container, int position, Object object) {  
            container.removeView((View) object); // 将view 类型 的object熊容器中移除,根据key  
        }  
  
        /** 
         * 当前的page的前一页和后一页也会被调用，如果还没有调用或者已经调用了destroyItem 
         */  
        @Override  
        public Object instantiateItem(ViewGroup container, int position) {  
            View view = views.get(position);  
            imageView = (ImageView) view
					.findViewById(R.id.imageView);
			imageView.setImageResource(ActivityHotelAlbum.resoureId[position]);
			textView = (TextView) view
					.findViewById(R.id.textView);
			textView.setText(ActivityHotelAlbum.desc[position]);
            container.addView(view);  
            return views.get(position); // 返回该view对象，作为key  
        }  
	};
	/* 
	 * @作者  韩梦飞沙  2015年3月26日 下午1:23:16 
	 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 所属类：ActivityAboutMe
	 * 代码说明：
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_show_photo);
		 inflater = getLayoutInflater();  
		 for (int i = 0; i < ActivityHotelAlbum.resoureId.length; i++) {  
	            View view = inflater.inflate(R.layout.item_photo_viewpaper, null);  
	            views.add(view);  
	     }  
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(getIntent().getIntExtra("position", 0));
		super.onCreate(savedInstanceState);
	}
}
