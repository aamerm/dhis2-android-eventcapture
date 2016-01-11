package org.hisp.dhis.android.eventcapture.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import org.hisp.dhis.client.sdk.ui.R;
import org.hisp.dhis.client.sdk.ui.fragments.AbsSelectorFragment;
import org.hisp.dhis.client.sdk.ui.fragments.PickerFragment;

public class SelectorFragment extends AbsSelectorFragment implements ISelectorView, View.OnClickListener {
    public static final String TAG = SelectorFragment.class.getSimpleName();
    private FrameLayout mPickerFrameLayout;
    private PickerFragment mPickerFragment;
    private ISelectorPresenter mSelectorPresenter;
    private FloatingActionButton mFloatingActionButton;


    public SelectorFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSelectorPresenter = new SelectorPresenter(this);
        mSelectorPresenter.onCreate();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        mFloatingActionButton.setOnClickListener(this);
        PickerFragment pickerFragment = (PickerFragment) mSelectorPresenter.createPickerFragment();
        attachFragment(R.id.pickerFragment, pickerFragment, PickerFragment.TAG);
    }



    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public PickerFragment getPickerFragment() {
        return mPickerFragment = (PickerFragment) getFragmentManager().findFragmentByTag(PickerFragment.TAG);
    }

    @Override
    public void attachFragment(int resId, Fragment fragment, String tag) {
        mNavigationHandler.addFragmentToLayout(resId, fragment, tag);
    }

    @Override
    public void onClick(View v) {
        Log.d("FloatingActcionButton", "onClick");
        // Add new event for orgUnit and program

    }
}