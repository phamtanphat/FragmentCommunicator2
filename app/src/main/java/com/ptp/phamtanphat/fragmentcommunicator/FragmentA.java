package com.ptp.phamtanphat.fragmentcommunicator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by KhoaPhamPC on 14/4/2018.
 */

public class FragmentA extends Fragment {

    View view;
    TextView txtA;
    EditText edtA;
    Button btnA;
    SendData sendData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a,container,false);
        txtA = view.findViewById(R.id.textviewtitleA);
        edtA = view.findViewById(R.id.edittextA);
        btnA = view.findViewById(R.id.buttonA);

        sendData = (SendData) getActivity();
        //Truyen du lieu vao cho function nhung chua dinh nghia function nay de lam
        sendData.RetriveData("Chao Main Activity");

//        Bundle bundle = getArguments();
//        String data = bundle.getString("MainSendData");
//        Log.d("BBB",data);

        return view;
    }
    public void HoldData(String text){
        String a = text;
        Log.d("BBB",a);
    }
    public void GetRatingbar(float v){
        edtA.setText(String.valueOf(v));
    }
}
