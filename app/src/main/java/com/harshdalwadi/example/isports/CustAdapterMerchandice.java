package com.harshdalwadi.example.isports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Harsh on 02-01-2016.
 */
public class CustAdapterMerchandice extends BaseAdapter {
    String[] result;
    Context context;
    String[] sinpri;
    int[] imageId;
    private final String[] myprice;
    String[] quntity1;
    private static LayoutInflater inflater = null;
    String doller = "$", day = "d ago";

    public CustAdapterMerchandice(Context mainActivity, String[] namess, int[] images, String[] myprice) {
        // TODO Auto-generated constructor stub
        result = namess;
        context = mainActivity;
        imageId = images;
        this.myprice = myprice;

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

        TextView tv, price;
        ImageView img;

        Holder(View v) {
            tv = (TextView) v.findViewById(R.id.myname12);
            img = (ImageView) v.findViewById(R.id.myimage21);
            price = (TextView) v.findViewById(R.id.myprice1111);
        }

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = null;

        final View row;

        if (convertView == null) {
            row = inflater.inflate(R.layout.singlelay_merchandies, null);
            holder = new Holder(row);

            row.setTag(holder);
        } else {
            row = convertView;
            holder = (Holder) row.getTag();
        }

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.price.setText(doller + myprice[position]);
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