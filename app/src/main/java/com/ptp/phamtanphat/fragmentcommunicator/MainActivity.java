package com.ptp.phamtanphat.fragmentcommunicator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SendData{

    TextView txtMain;
    SeekBar seekBar;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        fragmentManager = getFragmentManager();
        txtMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendDataFragmentDifferentNull();
            }
        });
    }

    private void anhxa() {
        txtMain = findViewById(R.id.textviewMain);
        seekBar = findViewById(R.id.seekbarmain);
    }

    // Cach 1 : Truyen du lieu tu activity sang fragment(Fragment chua co tren activity)
    public void SendDataActivityToFragment(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putString("MainSendData","Chao fragment A");
        fragmentA.setArguments(bundle);
        fragmentTransaction.replace(R.id.linearlayout,fragmentA);
        fragmentTransaction.commit();
    }
    // Cach 2 : Truyen du lieu tu activity sang fragment(Fragment nam tren activity)
    public void SendDataFragmentDifferentNull(){
        //kiem tra coi fragment co tren acitivity khong
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentById(R.id.fragmenta);
        if (fragmentA != null){
            fragmentA.HoldData("Chao Fragment A");
        }
    }
    // Cach 3 : Truyen du lieu tu fragment sang activity(Fragment nam tren activity)
    @Override
    public void RetriveData(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
