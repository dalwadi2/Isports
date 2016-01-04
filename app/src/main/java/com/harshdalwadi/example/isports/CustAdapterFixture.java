package com.harshdalwadi.example.isports;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Harsh on 02-01-2016.
 */
public class CustAdapterFixture extends BaseAdapter {


    private final Context context;
    private final int[] img1;
    private final int[] img2;
    private final String[] team1;
    private final String[] team2;
    private final String[] time;
    private static LayoutInflater lay;

    public CustAdapterFixture(Context context, int[] img1, int[] img2, String[] team1, String[] team2, String[] time) {

        this.context = context;
        this.img1 = img1;
        this.img2 = img2;
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        lay = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return team1.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        final View myview;
        if (convertView == null) {
            myview = lay.inflate(R.layout.singlrlay_fixture, null);
            holder = new ViewHolder(myview);

            myview.setTag(holder);
        } else {
            myview = convertView;
            holder = (ViewHolder) myview.getTag();
        }

        holder.myteam1.setImageResource(img1[position]);
        holder.myteam2.setImageResource(img2[position]);
        holder.myteamtxt1.setText(team1[position]);
        holder.myteamtxt2.setText(team2[position]);
        holder.mytime.setText(time[position]);

        myview.setId(position);
        final int aa = myview.getId();
        myview.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "position : " + aa, Toast.LENGTH_SHORT).show();
            }
        });
        return myview;
    }

    public class ViewHolder {
        TextView myteamtxt1, myteamtxt2, mytime;
        ImageView myteam1, myteam2;

        ViewHolder(View v) {
            myteamtxt1 = (TextView) v.findViewById(R.id.teamtxt1);
            myteamtxt2 = (TextView) v.findViewById(R.id.teamtxt2);
            mytime = (TextView) v.findViewById(R.id.time1);
            myteam1 = (ImageView) v.findViewById(R.id.team1);
            myteam2 = (ImageView) v.findViewById(R.id.team2);
        }
    }
}
