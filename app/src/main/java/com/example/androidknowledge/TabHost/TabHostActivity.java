package com.example.androidknowledge.TabHost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.R;

import butterknife.BindView;

public class TabHostActivity extends BaseActivity {
    @BindView(R.id.tabhost)
    TabHost tabHost;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_tab_host;
    }

    @Override
    protected void setupListener() {

    }

    @Override
    protected void populateData() {
        tabHost.setup();
        creattab1();
        creattab2();
        creattab3();
    }

    private void creattab1()
    {
        // tạo đối tượng 1 tab, có id là tab1
        //thiết lập tiêu đề cho tab
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");

        //thiết lập nội dung layout
        tab1.setContent(R.id.tab1);

//        tab1.setIndicator("use more");
        tab1.setIndicator("",getResources().getDrawable(R.drawable.icon_facebook));

        tabHost.addTab(tab1);
    }
     private void creattab2()
     {
         // tạo đối tượng 1 tab, có id là tab2
         TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");

        //thiết lập nội dung layout
         tab2.setContent(R.id.tab2);

         //thiết lập tiêu đề cho tab
//         tab2.setIndicator("private");
         tab2.setIndicator("",getResources().getDrawable(R.drawable.icon_google));

         tabHost.addTab(tab2);
     }
    private void creattab3()
    {
        // tạo đối tượng 1 tab, có id là tab3
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        //thiết lập nội dung layout
        tab3.setContent(R.id.tab3);

        //thiết lập tiêu đề cho tab
//        tab3.setIndicator("other");
        tab3.setIndicator("",getResources().getDrawable(R.drawable.icon_admin));

        tabHost.addTab(tab3);
    }
}
