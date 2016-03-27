package com.example.winxintab03;

import java.util.ArrayList;
import java.util.List;


import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener
{
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments;
	
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFrd;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSettings;
	
	private ImageButton mImgWeixin;
	private ImageButton mImgFrd;
	private ImageButton mImgAddress;
	private ImageButton mImgSettings;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		setContentView(R.layout.activity_main);
		initview();
		initEvent();
	}

	private void initEvent()
	{
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			mTabWeixin.setOnClickListener(this);
			mTabFrd.setOnClickListener(this);
			mTabAddress.setOnClickListener(this);
			mTabSettings.setOnClickListener(this);
	
	}

	private void initview()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		
		// TODO Auto-generated method stub
		mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);
		
		mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_image);
		mImgFrd= (ImageButton) findViewById(R.id.id_tab_frd_image);
		mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_image);
		mImgSettings = (ImageButton) findViewById(R.id.id_tab_settings_image);
		
	   mFragments = new ArrayList<Fragment>();
	   Fragment mTab01 = new WeixinFragment();
	   Fragment mTab02 = new FrdFragment();
	   Fragment mTab03 = new AddressFragment();
	   Fragment mTab04 = new SettingsFragment();
	   mFragments.add(mTab01);
	   mFragments.add(mTab02);
	   mFragments.add(mTab03);
	   mFragments.add(mTab04);
	   
	   mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
	{
		
		@Override
		public int getCount()
		{
			// TODO Auto-generated method stub
			return mFragments.size();
		}
		
		@Override
		public Fragment getItem(int arg0)
		{
			// TODO Auto-generated method stub
			return mFragments.get(arg0);
		}
	};
		
	mViewPager.setAdapter(mAdapter);
	
	mViewPager.setOnPageChangeListener(new OnPageChangeListener()
	{
		
		@Override
		public void onPageSelected(int arg0)
		{
			// TODO Auto-generated method stub
			int currentItem =  mViewPager.getCurrentItem();
			setTab(currentItem);
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0)
		{
			// TODO Auto-generated method stub
			
		}
	});
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.id_tab_weixin:
			setSelect(0);
			
			break;
		case R.id.id_tab_frd:
			setSelect(1);
			
			break;
		case R.id.id_tab_address:
			setSelect(2);
			
			break;
		case R.id.id_tab_settings:
			setSelect(3);
			
			break;
		}
		
		
		
	}
	
	private void setSelect(int i)
	{

		setTab(i);
		mViewPager.setCurrentItem(i);
	}

	private void setTab(int i)
	{
		resetImg();
		//把图片设置成亮的并设置内容区域
		switch (i)
		{
		case 0:
			mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
		
			mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			mImgAddress.setImageResource(R.drawable.tab_address_pressed);	
			break;
		case 3:
			mImgSettings.setImageResource(R.drawable.tab_settings_pressed);		
			break;
		}
	};
	
	
	private void resetImg()
	{
		// TODO Auto-generated method stub
		mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
		mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
		mImgAddress.setImageResource(R.drawable.tab_address_normal);
		mImgSettings.setImageResource(R.drawable.tab_settings_normal);
	};
	
}
