package com.example.carolinebudwell.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public  class firstFragment extends Fragment {


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public firstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_first, container, false);
        Button button = (Button) view.findViewById(R.id.Bbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), display.class);
                EditText editText = (EditText) view.findViewById(R.id.Input);
                DatabaseHelper helper = new DatabaseHelper(getActivity());
                String message = helper.searchPass(editText.getText().toString());
                intent.putExtra("Response", message);
                startActivity(intent);
            }
        });

        return view;

    }

}
