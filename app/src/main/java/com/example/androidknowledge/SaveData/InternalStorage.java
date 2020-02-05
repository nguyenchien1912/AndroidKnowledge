package com.example.androidknowledge.SaveData;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.BindView;

public class InternalStorage extends BaseActivity {

    @BindView(R.id.spinner_account)
    Spinner spinner;

    @BindView(R.id.user_account)
    EditText user;

    @BindView(R.id.pass_account)
    EditText pass;

    @BindView(R.id.note_account)
    EditText note;

    @BindView(R.id.add_account)
    Button add;

    @BindView(R.id.lv_account)
    ListView lv_account;

    private String filename = "account.txt";
    private String[] account_type = {"Facebook","Google","khác"};
    private ArrayList<String> arrAccount = new ArrayList<>();
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_save_data;
    }

    @Override
    protected void setupListener() {

        setSpinner();
        addAccount();

    }

    @Override
    protected void populateData() {
        HideTitle();
    }

    private void setSpinner()
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,account_type);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(arrayAdapter);
        readData();
    }

    private void addAccount()
    {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AccountPerson accountPerson = new AccountPerson(spinner.getSelectedItem().toString() + "  " +note.getText().toString(),user.getText().toString(),pass.getText().toString());
                arrAccount.add(accountPerson.toString());
                setLv_account();
                String s = accountPerson + "\n";
                writeData(s);
            }
        });

    }
    private void setLv_account()
    {
        ArrayAdapter adapter= new ArrayAdapter(InternalStorage.this,android.R.layout.simple_expandable_list_item_1,arrAccount);
        deleteAccount();
        lv_account.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void deleteAccount() {
        lv_account.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dialogDelete(position);
                return false;
            }
        });
    }

    private void dialogDelete(int position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(InternalStorage.this);
        builder.setTitle("You are delete account?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrAccount.remove(position);
                setLv_account();
                ghidedata(arrAccount);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private void writeData(String s)
    {

        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(s.getBytes());
            outputStream.close();
            Toast.makeText(this,"save data successfully",Toast.LENGTH_LONG).show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    private void ghidedata(ArrayList<String> arrAccount)
    {
        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            int t = arrAccount.size();
            for(int i=0;i<t;i++)
            {
                outputStream.write(arrAccount.get(i).getBytes());
                outputStream.write("\n".getBytes());
            }
            outputStream.close();
            Toast.makeText(this,"save data successfully",Toast.LENGTH_LONG).show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void readData()
    {
        try {
            FileInputStream in = this.openFileInput(filename);

            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            StringBuffer buffer = new StringBuffer();
            String line = null;
            String acc="";
            int i =1;
            while((line= br.readLine())!= null)  {
                buffer.append(line).append("\n");
                if(i%3!=0)
                {
                    acc += line + "\n";
                }
                else {

                    acc += line ;
                    arrAccount.add(acc);
                    acc = "";
                }
                i++;
            }
//            buffer.toString() chính là chuỗi String thu đc toàn bộ từ file
            setLv_account();
        } catch (Exception e) {
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
