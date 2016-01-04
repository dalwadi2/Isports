package com.harshdalwadi.example.isports;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFrag extends Fragment {

    TextView contentTitle ,text;
    ImageView linkimg;
    public ContentFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View maview =  inflater.inflate(R.layout.fragment_content, container, false);

        contentTitle = (TextView) maview.findViewById(R.id.contenttitle);
        text = (TextView) maview.findViewById(R.id.contenttext);
        linkimg = (ImageView) maview.findViewById(R.id.link);

        linkimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(Intent.createChooser(i,"Select browser"));
            }
        });
        contentTitle.setText("Alan & Guys Hair");
        text.setText("We pamper and indulge our clients with the ultimate in hair and scalp care. Our talented professionals are not only well-trained but also dedicated to making your visit with us a positive experience.We pamper and indulge our clients with the ultimate in hair and scalp care. Our talented professionals are not only well-trained but also dedicated to making your visit with us a positive experience.We pamper and indulge our clients with the ultimate in hair and scalp care. Our talented professionals are not only well-trained but also dedicated to making your visit with us a positive experience.");



        return maview;
    }


}
