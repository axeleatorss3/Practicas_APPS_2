package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class FRAG_LIST extends Fragment {
String [] datos = {"enero","febrero","marzo","abril","junio","julio","agosto","septiembe","octubre","noviembre","diciembre","lol","lel","juas"};
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
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_f_r_a_g__l_i_s_t, container, false);
        //aqui la lista
        ListView listView;
        listView = frameLayout.findViewById(R.id.list_view_datos);
        listView.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                datos
        ));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                main.onMessageFromFragToMAain("lista",datos[i]);
            }
        });
        return frameLayout;
    }
}