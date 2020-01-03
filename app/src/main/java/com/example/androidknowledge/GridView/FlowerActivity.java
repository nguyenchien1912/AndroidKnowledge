package com.example.androidknowledge.GridView;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.androidknowledge.R;

import java.util.ArrayList;

    public class FlowerActivity extends AppCompatActivity {
        GridView gridView;
        ArrayList<Flower> flowerList;
        FlowerAdapter flowerAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grid_view);

            addControls();
            addEvent();
        }

        private void addControls() {

            gridView = (GridView) findViewById(R.id.screengridview);
            flowerList = new ArrayList<>();
            /**
             * @param MainActivity.this
             * @param R.layout.item
             * @param bookList
             * */
            flowerAdapter = new FlowerAdapter(FlowerActivity.this,R.layout.item_grid_view, flowerList);
            gridView.setAdapter(flowerAdapter);
        }

        private void addEvent() {
            createData();
        }

        /** Add data to bookList*/
        public void createData() {
            Flower flower = new Flower("giỏ hoa 1","120.000 vnđ",R.drawable.imagegridview1);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 2","130.000 vnđ",R.drawable.imagegridview2);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 3","90.000 vnđ",R.drawable.imagegridview3);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 4","100.000 vnđ",R.drawable.imagegridview4);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 5","170.000 vnđ",R.drawable.imagegridview5);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 6","190.000 vnđ",R.drawable.imagegridview6);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 7","200.000 vnđ",R.drawable.imagegridview7);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 8","210.000 vnđ",R.drawable.imagegridview8);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 9","89.000 vnđ",R.drawable.imagegridview9);
            flowerList.add(flower);
            flower = new Flower("giỏ hoa 10","154.000 vnđ",R.drawable.imagegridview10);
            flowerList.add(flower);
            flowerAdapter.notifyDataSetChanged();
        }
    }
