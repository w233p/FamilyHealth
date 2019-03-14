package com.example.msi.familyhealth.View.DataFragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msi.familyhealth.R;

public class Fragment_auto extends Fragment {
    /**
     * 仪器上传界面的Fragment
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_auto, container, false);
    }
}
