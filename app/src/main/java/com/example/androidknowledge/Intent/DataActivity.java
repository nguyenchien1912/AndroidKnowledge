package com.example.androidknowledge.Intent;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.R;

import java.util.ArrayList;

import butterknife.BindView;

import static com.example.androidknowledge.Constant.RESULTCODE;
import static com.example.androidknowledge.Constant.RETURNDATA;
import static com.example.androidknowledge.Constant.SENDDATA;

public class DataActivity extends BaseActivity {
    @BindView(R.id.lv_danhba)
    ListView lvdanhba;

    @BindView(R.id.messege)
    EditText datamessege;

    @BindView(R.id.send_messege)
    Button btnsend;

    private static ArrayList<String> arrData = new ArrayList<>();
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_intent_take_return_data;
    }

    @Override
    protected void setupListener() {
        HideTitle();
    }

    @Override
    protected void populateData() {
        addDanhba();
        ReturnMessege();
    }

    private void ReturnMessege() {
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(RETURNDATA,datamessege.getText().toString());
                setResult(RESULTCODE,intent);
                finish();
            }
        });
    }

    private void addDanhba() {
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra(SENDDATA);
        arrData.add(user.toString());
        ArrayAdapter arrayAdapter = new ArrayAdapter(DataActivity.this,android.R.layout.simple_expandable_list_item_1,arrData);
        lvdanhba.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
}
