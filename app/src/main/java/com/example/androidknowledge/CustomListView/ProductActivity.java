package com.example.androidknowledge.CustomListView;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.androidknowledge.R;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ListView lvProduct;
    ArrayList<Product> productList;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        addControls();
        addEvent();
    }

    private void addControls() {

        lvProduct = (ListView) findViewById(R.id.lvProductList);
        productList = new ArrayList<>();
        /**
         * @param MainActivity.this
         * @param R.layout.item
         * @param bookList
         * */
        productAdapter = new ProductAdapter(ProductActivity.this,R.layout.item_custom, productList);
        lvProduct.setAdapter(productAdapter);
    }

    private void addEvent() {
        createData();
    }

    /** Add data to bookList*/
    public void createData() {
        Product product = new Product(R.drawable.imagecustom1,"Hoa 1","100.000 vnđ");
        productList.add(product);
        product = new Product(R.drawable.imagecustom2,"Hoa 2","200.000 vnđ");
        productList.add(product);
        product = new Product(R.drawable.imagecustom3,"Hoa 3","300.000 vnđ");
        productList.add(product);
        product = new Product(R.drawable.imagecustom4,"Hoa 4","350.000 vnđ");
        productList.add(product);
        product = new Product(R.drawable.imagecustom5,"Hoa 5","400.000 vnđ");
        productList.add(product);
        productAdapter.notifyDataSetChanged();
    }
}