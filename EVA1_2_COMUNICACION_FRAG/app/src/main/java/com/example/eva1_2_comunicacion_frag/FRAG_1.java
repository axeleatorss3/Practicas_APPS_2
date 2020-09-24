package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FRAG_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FRAG_1 extends Fragment {
    TextView  textViewDatos;
    MainActivity main;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout;
        linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_f_r_a_g_1, container, false);
        Button btnDatos = linearLayout.findViewById(R.id.btnDatos);
        textViewDatos = linearLayout.findViewById(R.id.txtData);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                main.onMessageFromFragToMAain("data","mensaje del fragmento datos");
            }
        });
        return linearLayout;
    }
    public void onMessageFromMainToFrag( String param){
        textViewDatos.setText(param);

    }
}