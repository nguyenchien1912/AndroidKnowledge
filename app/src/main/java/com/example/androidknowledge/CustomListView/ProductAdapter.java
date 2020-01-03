package com.example.androidknowledge.CustomListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidknowledge.R;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    Activity context;
    int resource;
    List<Product> objects;
    /**
     * @param context
     * @param resource
     * @param objects
     * */
    public ProductAdapter(Activity context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        TextView name = (TextView) customView.findViewById(R.id.name);
        TextView price = (TextView) customView.findViewById(R.id.price);
        ImageView img = (ImageView) customView.findViewById(R.id.image);
        /** Set data to custumView*/
        final Product product = this.objects.get(position);
        name.setText(product.getName());
        price.setText(product.getPrice());
        img.setImageResource(product.getImage());
        /**Set Event Onclick*/

        return customView;
    }
    /** Show mesage*/

}

