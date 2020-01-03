package com.example.androidknowledge.GridView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidknowledge.R;

import java.util.List;


public class FlowerAdapter extends ArrayAdapter<Flower> {
    Activity context;
    int resource;
    List<Flower> objects;
    /**
     * @param context
     * @param resource
     * @param objects
     * */
    public FlowerAdapter(Activity context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= this.context.getLayoutInflater();
        View gridView = inflater.inflate(this.resource,null);

        TextView nameflower = (TextView) gridView.findViewById(R.id.name_flower);
        TextView priceflower = (TextView) gridView.findViewById(R.id.price_flower);
        ImageView imageflower = (ImageView) gridView.findViewById(R.id.image_grid_view);
        /** Set data to custumView*/
        final Flower flower = this.objects.get(position);
        nameflower.setText(flower.getName());
        priceflower.setText(flower.getPrice());
        imageflower.setImageResource(flower.getImage());
        /**Set Event Onclick*/

        return gridView;
    }
    /** Show mesage*/


}
