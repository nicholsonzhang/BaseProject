package com.user.base.mine;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.user.base.R;

/**
 * Created by user on 2017/10/30.
 */

public class TestFragment extends Fragment {
    private static final String TAG = TestFragment.class.getName();
    private String mLabel;

    public static TestFragment newInstance(String label) {
        TestFragment testFragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("label", label);
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG,"onAttach ");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate ");

        Bundle bundle = getArguments();
        if (bundle != null) {
            mLabel = bundle.getString("label");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView ");

        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.label);
        textView.setText(mLabel);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG,"onHiddenChanged "+hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG,"setUserVisibleHint "+isVisibleToUser);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart ");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume ");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause ");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onStop ");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"onDestroyView ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy ");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG,"onDetach ");

    }
}
