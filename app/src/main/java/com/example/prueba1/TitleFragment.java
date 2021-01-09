package com.example.prueba1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prueba1.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {
    private FragmentTitleBinding mBinding;
    public TitleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentTitleBinding.inflate(inflater,container,false);
        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.editTextName.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Hola, debes ingresar tu nombre", Toast.LENGTH_SHORT).show();
                } else {
                    //Entrega el nombre
                    Bundle bundle = new Bundle();
                    bundle.putString("clave1", mBinding.editTextName.getText().toString());
                    Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_titleFragment2_to_triviaFragment, bundle);


                }
            }
        });
    }
    }

    // addTriviaFragment(mBinding.editTextName.getText().toString());

//Bundle bundle = new Bundle();
// bundle.putString("clave1","name");
