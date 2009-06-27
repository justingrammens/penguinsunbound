/**
 * Created by Justin Grammens
 * Copyright Localtone Interactive. All Rights Reserved.
 */

package com.localtone.penguinsunbound;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class PenguinsUnbound extends TabActivity {

	TabHost mTabHost;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent websiteItent = new Intent(this, Website.class);
		websiteItent.putExtra("link", "http://www.penguinsunbound.org/");
		
		Intent RssFeedList = new Intent(this, RssFeedList.class);
		RssFeed.loadFeedList();
		
		mTabHost = getTabHost();
		
		mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator(
		"Website").setContent(websiteItent));
		
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("RSS Feed")
				.setContent(RssFeedList));
		
		mTabHost.setCurrentTab(0);
	}
	
}