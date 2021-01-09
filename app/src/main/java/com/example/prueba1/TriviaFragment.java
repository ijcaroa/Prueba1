package com.example.prueba1;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.prueba1.databinding.FragmentTriviaBinding;


public class TriviaFragment extends Fragment {

    

    private FragmentTriviaBinding mBinding;
    private boolean choice;
    private String message;
    public TriviaFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            message = getArguments().getString("clave1");
        }

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentTriviaBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Recibe el nombre
        Log.d("message", message);
        String saludo = getString(R.string.saludo,message);
        mBinding.tvSaludo.setText(saludo);
        mBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            int index = mBinding.radioGroup.indexOfChild(mBinding.radioGroup.findViewById(checkedId));
            if (index == 3) {
                choice = true;
            } else {
                choice = false;
                }
            }
        });
        mBinding.buttonEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (choice){
                //puse el bundle
                Bundle bundle = new Bundle();
                bundle.putString("clave2", message);
                Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_triviaFragment_to_winnerFragment2,bundle);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("clave3", message);
                Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_triviaFragment_to_looserFragment3,bundle);
            }

            }
        });

    }

}