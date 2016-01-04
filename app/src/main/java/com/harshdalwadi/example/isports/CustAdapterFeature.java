package com.harshdalwadi.example.isports;

/**
 * Created by Harsh on 01-01-2016.
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

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustAdapterFeature extends BaseAdapter {

    String[] result;
    Context context;
    String[] sinpri;
    int[] imageId;
    private final String[] myprice;
    private final String[] myfound;
    String[] quntity1;
    private static LayoutInflater inflater = null;
    String  doller = "$", day = "d ago";

    public CustAdapterFeature(Context mainActivity, String[] prgmNameList, int[] images, String[] distance, String[] discrate, String[] myprice, String[] myfound) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        sinpri = discrate;
        quntity1 = distance;
        context = mainActivity;
        imageId = images;
        this.myprice = myprice;
        this.myfound = myfound;

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

        TextView tv, plcaname, discount, price, found;
        ImageView img;
        ImageButton plus, minus;

        Holder(View v) {
            tv = (TextView) v.findViewById(R.id.myname);
            img = (ImageView) v.findViewById(R.id.myimage1);
            plcaname = (TextView) v.findViewById(R.id.place1);
            discount = (TextView) v.findViewById(R.id.disc111);
            price = (TextView) v.findViewById(R.id.price111);
            found = (TextView) v.findViewById(R.id.found111);

        }

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = null;

        final View row;

        if (convertView == null) {
            row = inflater.inflate(R.layout.singlelay_feature, null);
            holder = new Holder(row);

            row.setTag(holder);
        } else {
            row = convertView;
            holder = (Holder) row.getTag();
        }

         holder.discount.setText(String.valueOf(sinpri[position]));
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.plcaname.setText(String.valueOf(quntity1[position]));
        holder.price.setText(doller + myprice[position]);
        holder.found.setText(myfound[position]+day);
        holder.plcaname.setId(position);
        row.setId(position);
        final String myItemName = result[position];

        //final int totalsum = holder.plcaname.getId();
        final int im2 = row.getId();

        row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*Intent i = new Intent(context,second.class);
                context.startActivity(i);
*/
                Toast.makeText(context, im2 + " You Clicked " + myItemName, Toast.LENGTH_LONG).show();

            }
        });

        return row;

    }


}