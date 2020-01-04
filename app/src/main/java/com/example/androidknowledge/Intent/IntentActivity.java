package com.example.androidknowledge.Intent;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.R;

import butterknife.BindView;

import static com.example.androidknowledge.constant.REQUESTCODE;
import static com.example.androidknowledge.constant.RESULTCODE;
import static com.example.androidknowledge.constant.RETURNDATA;
import static com.example.androidknowledge.constant.SENDDATA;

public class IntentActivity extends BaseActivity {
    @BindView(R.id.name_intent)
    EditText name;

    @BindView(R.id.sdt_intent)
    EditText sdt;

    @BindView(R.id.showmessage)
    TextView showmessege;

    @BindView(R.id.btn_sendinfo)
    Button btnSend;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_intent_send_data;
    }

    @Override
    protected void setupListener() {

    }

    @Override
    protected void populateData() {
        SendInfo();
    }

    private void SendInfo() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(name.getText().toString(),sdt.getText().toString());
                Intent intent = new Intent();
                intent.setClass(IntentActivity.this,DataActivity.class);
                intent.putExtra(SENDDATA,user);
                startActivityForResult(intent,REQUESTCODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUESTCODE && resultCode == RESULTCODE)
        {
            String s = data.getStringExtra(RETURNDATA);
            showmessege.setText(s);
        }
    }
}
