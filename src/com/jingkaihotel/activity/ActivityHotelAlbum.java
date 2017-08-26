/**
 * @作者： 韩梦飞沙  2015年3月26日
 */
package com.jingkaihotel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.jingkaihotel.R;


/**
 * @作者  韩梦飞沙  2015年3月26日 下午1:16:19 
 * 联系：QQ:313134555 CSDN: http://blog.csdn.net/yue31313
 * 代码说明：宾馆相册
 */
public class ActivityHotelAlbum extends Activity {

	GridView gridView;
	MyAdapter adapter;
	static int[] resoureId = { R.drawable.biaozhundachuang01,
			R.drawable.biaozhundachuang02,
			R.drawable.biaozhunshuangren01,
			R.drawable.biaozhunshuangren02,
			R.drawable.diannaodachuang01,
			R.drawable.diannaodachuang02,
			R.drawable.diannaodachuang03,
			R.drawable.diannaoshuangren01,
			R.drawable.diannaoshuangren02,
			R.drawable.diannaoshuangren03, R.drawable.xiyvjian, };
	static String[] desc = { "标准大床房01", "标准大床房02", "标准双人房01", "标准双人房02",
			"电脑大床房01", "电脑大床房02", "电脑大床房03", "电脑双人房01", "电脑双人房02",
			"电脑双人房03", "洗浴间" };

	/* 
	 * @作者  韩梦飞沙  2015年3月26日 下午1:23:16 
	 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 所属类：ActivityAboutMe
	 * 代码说明：
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_hotel_album);
		gridView = (GridView) findViewById(R.id.gridView);
		adapter = new MyAdapter();
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			Intent intent;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				intent = new Intent(ActivityHotelAlbum.this,
						ActivityShowPhoto.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}

		});
		super.onCreate(savedInstanceState);
	}

	public class MyAdapter extends BaseAdapter {

		LayoutInflater inflater;
		ImageView imageView;
		TextView textView;

		/**
		* 构造函数
		*/
		public MyAdapter() {
			inflater = LayoutInflater.from(ActivityHotelAlbum.this);
		}

		/* 
		 * @作者  韩梦飞沙  2015年3月27日 上午11:09:57 
		 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
		 * @see android.widget.Adapter#getCount()
		 * 所属类：Adapter
		 * 代码说明：
		 */
		@Override
		public int getCount() {
			return resoureId.length;
		}

		/* 
		 * @作者  韩梦飞沙  2015年3月27日 上午11:09:57 
		 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
		 * @see android.widget.Adapter#getItem(int)
		 * 所属类：Adapter
		 * 代码说明：
		 */
		@Override
		public Object getItem(int position) {
			return position;
		}

		/* 
		 * @作者  韩梦飞沙  2015年3月27日 上午11:09:57 
		 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
		 * @see android.widget.Adapter#getItemId(int)
		 * 所属类：Adapter
		 * 代码说明：
		 */
		@Override
		public long getItemId(int position) {
			return position;
		}

		/* 
		 * @作者  韩梦飞沙  2015年3月27日 上午11:09:57 
		 * 联系：Email:313134555@qq.com CSDN: http://blog.csdn.net/yue31313
		 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 * 所属类：Adapter
		 * 代码说明：
		 */
		@Override
		public View getView(int position, View convertView,
				ViewGroup parent) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_photo,
						null);
			}
			imageView = (ImageView) convertView
					.findViewById(R.id.imageView);
			imageView.setImageResource(resoureId[position]);
			textView = (TextView) convertView
					.findViewById(R.id.textView);
			textView.setText(desc[position]);
			return convertView;
		}

	}
}
