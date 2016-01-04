package com.harshdalwadi.example.isports;

/**
 * Created by Dalwadi on 21-09-2015.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    String[] result;
    Context context;

    String[] sinpri;
    int[] imageId;
    String[] quntity1;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Context mainActivity, String[] prgmNameList, int[] images, String[] distance, String[] place) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        sinpri = place;
        quntity1 = distance;
        context = mainActivity;

        imageId = images;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {

        TextView tv, add, singelprice;
        ImageView img;
        ImageButton plus, minus;

        Holder(View v) {
            tv = (TextView) v.findViewById(R.id.mytext);
            img = (ImageView) v.findViewById(R.id.myimage);
            add = (TextView) v.findViewById(R.id.madd);
            singelprice = (TextView) v.findViewById(R.id.dist);
        }

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = null;

        final View row;

        if (convertView == null) {
            row = inflater.inflate(R.layout.single_item_lay, null);
            holder = new Holder(row);

            row.setTag(holder);
        } else {
            row = convertView;
            holder = (Holder) row.getTag();
        }

        holder.singelprice.setText(String.valueOf(sinpri[position]));
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.add.setText(String.valueOf(quntity1[position]));

        holder.add.setId(position);
        row.setId(position);
        final String myItemName = result[position];

        //final int totalsum = holder.add.getId();
        final int im2 = row.getId();

        row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(context,second.class);
                context.startActivity(i);

                Toast.makeText(context, im2 + " You Clicked " + myItemName, Toast.LENGTH_LONG).show();

            }
        });

        return row;

    }


}