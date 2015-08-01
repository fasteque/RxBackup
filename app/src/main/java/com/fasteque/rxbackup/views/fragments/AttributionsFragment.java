package com.fasteque.rxbackup.views.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.fasteque.rxbackup.R;

/**
 * Created by danielealtomare on 01/08/15.
 * Project: RxBackup
 */
public class AttributionsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.attributions);
    }
}
