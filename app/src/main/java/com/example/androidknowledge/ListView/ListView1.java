package com.example.androidknowledge.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.R;

import java.util.ArrayList;

import butterknife.BindView;

public class ListView1 extends BaseActivity {

    @BindView(R.id.lv1)
    ListView lv;

    @BindView(R.id.posandvalue)
    TextView tv;
    private static String[] arrData={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    @Override
    protected int getLayoutRes() {
        return R.layout.list_view;
    }

    @Override
    protected void setupListener() {
        ArrayAdapter adapter= new ArrayAdapter(ListView1.this,android.R.layout.simple_expandable_list_item_1,arrData);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText("position=" +position+"value="+arrData[position]);
            }
        });
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void populateData() {
        HideTitle();
    }
}
