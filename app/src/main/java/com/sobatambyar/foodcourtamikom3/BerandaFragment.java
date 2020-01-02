package com.sobatambyar.foodcourtamikom3;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment  {

 CardView cardView;

    public BerandaFragment() {
        // Required empty public constructor


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        CardView button = (CardView) view.findViewById(R.id.card1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("AAA", "BBB");
                startActivity(new Intent(getActivity(), MenuResto.class));
                Log.d("AAA", "BBB");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }


}
