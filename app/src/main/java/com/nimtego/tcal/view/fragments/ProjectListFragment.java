package com.nimtego.tcal.view.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.nimtego.tcal.R;
import com.nimtego.tcal.model.ProjectProvider;

public class ProjectListFragment extends ListFragment {

    private final String TAG = "ProjectListFragment";
    private ProjectProvider mProjectProvider;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.v(TAG, "onActivityCreated");
        init();

    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project_blank, null);
    }
    private void init() {
        mProjectProvider = ProjectProvider.getProjectProvider();
        String[] projectArray = mProjectProvider.arrayNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, projectArray);
        setListAdapter(adapter);
    }
}
