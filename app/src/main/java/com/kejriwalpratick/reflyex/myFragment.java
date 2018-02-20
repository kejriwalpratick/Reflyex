package com.kejriwalpratick.reflyex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class myFragment extends Fragment {


    private String des;
    private int image;
    private int image2;
    private int image3;

    public static myFragment newInstance(String desc, int resImage,int i2,int i3) {
        myFragment fragment = new myFragment();
        Bundle args = new Bundle();
        args.putInt("image", resImage);
        args.putInt("image2", i2);
        args.putInt("image3", i3);
        args.putString("title", desc);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = getArguments().getInt("image", 0);
        des = getArguments().getString("title");
        image2=getArguments().getInt("image2",0);
        image3 = getArguments().getInt("image3",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraglayout, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.textView22);
        tvLabel.setText(des);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView6);
        imageView.setImageResource(image);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView212);
        imageView2.setImageResource(image2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView7);
        imageView3.setImageResource(image3);

        return view;
    }
}