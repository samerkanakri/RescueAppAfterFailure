package com.sam.amman.rescue.Normal_Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.sam.amman.rescue.Adapters.Preferences;
import com.sam.amman.rescue.R;

public class Settings extends Fragment {

    View v;
    Switch rememberme;
    Preferences pref;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean switched;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_settings,container,false);
        rememberme = (Switch) v.findViewById(R.id.remembermeSwitch);


        pref = new Preferences(getActivity());
        switched = pref.getRemmeber();

        Log.e("checked",switched+"");
        rememberme.setChecked(switched);
//        rememberme.setChecked(sharedPreferences.getBoolean("checked",false));
//        rememberme.setChecked(checkPref());

        rememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Preferences pref = new Preferences(getActivity());
                    pref.setRememberMe(true);
                }else{
                    Preferences pref = new Preferences(getActivity());
                    pref.setRememberMe(false);
                }
            }
        });


        return v;
    }


    public boolean checkPref(){
        if(pref.getRemmeber()){
            return pref.getRemmeber();
        }else {
            return false;
        }
    }
}