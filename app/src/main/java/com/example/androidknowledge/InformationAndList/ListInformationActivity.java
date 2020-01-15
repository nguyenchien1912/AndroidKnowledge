package com.example.androidknowledge.InformationAndList;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.ListView.ListView1;
import com.example.androidknowledge.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;

public class ListInformationActivity extends BaseActivity {
    @BindView(R.id.name_list)
    EditText name;

    @BindView(R.id.checkbox_guy)
    RadioButton checkguy;

    @BindView(R.id.checkbox_girl)
    RadioButton checkgirl;

    @BindView(R.id.text_birth)
    TextView dateofbirth;

    @BindView(R.id.button_add)
    Button btnadd;

    @BindView(R.id.spinner_level)
    Spinner spin;

    @BindView(R.id.auto_text_place)
    AutoCompleteTextView autotextPlace;

    @BindView(R.id.lvInformation)
    ListView lv;

    private static ArrayList<String> information1s = new ArrayList<>();
    private static ArrayList<String> infostring = new ArrayList<>();
    private int i=0;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_information_vs_list;
    }

    @Override
    protected void setupListener() {
        HideTitle();
    }

    @Override
    protected void populateData() {
            spinner();
            place();
            date();
            addinfo();
    }

    private void lvinfo()
    {
        ArrayAdapter adapter= new ArrayAdapter(ListInformationActivity.this,android.R.layout.simple_expandable_list_item_1,information1s);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                tv.setText("position=" +position+"value="+arrData[position]);
//            }
//        });
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void spinner()
    {

        // Spinner

        String arr[] = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(arrayAdapter);
    }

    private void place()
    {

        //AutoCompleteTextView

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        autotextPlace.setAdapter(arrayAdapter);
        String []arrPlace = getResources().getStringArray(R.array.arrProvincial);

        arrayAdapter.addAll(arrPlace);
    }

    private void addinfo()
    {
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i+=1;
                String c = i + " - " + name.getText().toString() + "\n" ;
                if (checkguy.isChecked())
                    c+=" Guy " + dateofbirth.getText().toString()+" " + autotextPlace.getText().toString() + " " + spin.getSelectedItem().toString() ;
                else c+=" Girl " + dateofbirth.getText().toString()+" " + autotextPlace.getText().toString() + " " + spin.getSelectedItem().toString() ;
                information1s.add(c);
                lvinfo();
            }
        });
    }

    private void date()
    {

        Calendar now = Calendar.getInstance(); //lấy ngày tháng năm hiện tại
//        now.getTime().toString(); lấy toàn bộ thông tin , thứ ngày tháng năm giờ
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");// or ("hh/mm/ss") để định dạng ngày tháng năm theo dấu /

//        TimePickerDialog gần giống như DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(ListInformationActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,dayOfMonth); // set ngày tháng năm , sau khi lựa chọn
                dateofbirth.setText(simpleDateFormat.format(calendar.getTime()).toString());

            }
        },now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH));

        dateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hiển thị bảng ngày tháng năm
                datePickerDialog.show();
            }
        });
    }




























}
