package com.example.prueba1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba1.databinding.FragmentWinnerBinding;


public class WinnerFragment extends Fragment {
    private FragmentWinnerBinding mBindig;
    private String winname;






    public WinnerFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            winname = getArguments().getString("clave2");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mBindig = FragmentWinnerBinding.inflate(inflater,container,false);
        return mBindig.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String ganador = getString(R.string.Ganador,winname);
        mBindig.tVGanador.setText(ganador);

        mBindig.buttonBackWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(mBindig.getRoot()).navigate(R.id.action_winnerFragment_to_titleFragment22);
            }
        });
    }
}