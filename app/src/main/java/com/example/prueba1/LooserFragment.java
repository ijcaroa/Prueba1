package com.example.prueba1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba1.databinding.FragmentLooserBinding;


public class LooserFragment extends Fragment {


    private FragmentLooserBinding mBinding;
    private String loosername;
    public LooserFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            loosername = getArguments().getString("clave3");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentLooserBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String perdedor = getString(R.string.Perdedor,loosername);
        mBinding.tVPerdedor.setText(perdedor);

        mBinding.buttonBackLoser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_looserFragment_to_titleFragment22);
            }
        });
    }
}