package com.example.androidknowledge;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.androidknowledge.GridView.FlowerActivity;
import com.example.androidknowledge.InformationAndList.ListInformationActivity;
import com.example.androidknowledge.ListView.ListView1;
import com.example.androidknowledge.CustomListView.ProductActivity;
import com.example.androidknowledge.TabHost.TabHostActivity;

import butterknife.BindView;

public class ViewManage extends BaseActivity {

    @BindView(R.id.listitem)
    Button listview;

    @BindView(R.id.customview)
    Button customview;

    @BindView(R.id.gridview)
    Button gridview;

    @BindView(R.id.list_information)
    Button listinformation;

    @BindView(R.id.tabhost)
    Button tabhost;

    @BindView(R.id.tablayout)
    Button tablayout;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_view_advanced;
    }

    @Override
    protected void setupListener() {
        HideTitle();
        ListView();
        CustomView();
        GridView();
        ListInformation();
        TabHost();
    }

    @Override
    protected void populateData() {

    }

    private void ListView()
    {
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(ViewManage.this, ListView1.class));
            }
        });
    }

    private void CustomView()
    {
        customview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewManage.this, ProductActivity.class));
            }
        });
    }

    private void GridView()
    {
        gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewManage.this, FlowerActivity.class));
            }
        });
    }
    private void ListInformation()
    {
        listinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewManage.this, ListInformationActivity.class));
            }
        });
    }
    private void TabHost()
    {
        tabhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewManage.this, TabHostActivity.class));
            }
        });
    }

}
