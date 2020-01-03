package com.example.androidknowledge.NotificationWindow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidknowledge.R;

public class Information extends AppCompatActivity {
    private static EditText name, cardId, addinfo;
    private static RadioButton intermediate, college, university;
    private static CheckBox readBook, readNewspaper, readCoding;
    private static Button sendinfo;
    private static String Sname,ScardId,Saddinfo,Sintermediate,Scollege,Suniversity,Sreadbook,Sreadnewspaper,Sreadcoding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        findid();
        sendinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takevalue();
                final AlertDialog.Builder builder = new AlertDialog.Builder(Information.this);
                builder.setTitle("Personal Information");
                builder.setMessage(Sname+ScardId+
                        Sintermediate+Scollege+
                        Suniversity+Sreadbook+
                        Sreadnewspaper+Sreadcoding+
                        "---------------------------------"+
                        '\n'+"Addtional Information"+'\n'+
                        Saddinfo +'\n'+
                        "---------------------------------");
                builder.setPositiveButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }

        });

    }
    private void takevalue()
    {
        Sname = name.getText().toString()+'\n';
        ScardId = cardId.getText().toString()+'\n';
        Saddinfo = addinfo.getText().toString()+'\n';
        if (intermediate.isChecked())
            Sintermediate = intermediate.getText().toString()+'\n';
        else Sintermediate ="";

        if(college.isChecked())
            Scollege = college.getText().toString()+'\n';
        else Scollege ="";

        if(university.isChecked())
            Suniversity = university.getText().toString()+'\n';
        else Suniversity="";

        if(readBook.isChecked())
            Sreadbook = readBook.getText().toString()+'-';
        else Sreadbook = "";

        if(readNewspaper.isChecked())
            Sreadnewspaper = readNewspaper.getText().toString()+'-';
        else Sreadnewspaper="";

        if(readCoding.isChecked())
            Sreadcoding = readCoding.getText().toString()+'\n';
        else Sreadcoding="\n";
        Saddinfo = addinfo.getText().toString();
    }


    private void findid()
    {
        name = (EditText) findViewById(R.id.fullname);
        cardId = (EditText) findViewById(R.id.cardID);
        addinfo = (EditText) findViewById(R.id.addinfo);
        intermediate = (RadioButton) findViewById(R.id.intermediate);
        college = (RadioButton) findViewById(R.id.college);
        university = (RadioButton) findViewById(R.id.university);
        readBook = (CheckBox) findViewById(R.id.readbook);
        readNewspaper = (CheckBox) findViewById(R.id.readnewspaper);
        readCoding = (CheckBox) findViewById(R.id.readcoding);
        sendinfo = (Button) findViewById(R.id.sendinformation);

    }
}

