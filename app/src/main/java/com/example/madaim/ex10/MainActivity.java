package com.example.madaim.ex10;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends Activity implements fragA.OnFragmentInteractionListener,fragB.OnFragmentInteractionListener {
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            FragmentManager fm = getFragmentManager();
            if (savedInstanceState != null && fm.findFragmentByTag("AAA") != null) {
                return;
            }
            fm.beginTransaction().add(R.id.fragConatainer, new fragA(), "AAA").commit();
        }
    }

    @Override
    public void onClickEvent() {
        fragB fragB;
        cnt++;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragB = (fragB) getFragmentManager().findFragmentById(R.id.fragB);
        }
            else{
                fragB=new fragB();
                getFragmentManager().beginTransaction().add(R.id.fragConatainer,fragB).addToBackStack("BBB").commit();
                getFragmentManager().executePendingTransactions();
            }
      fragB.countChanged(cnt);
    }

        }
