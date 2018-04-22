package com.nimtego.tcal.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nimtego.tcal.R;
import com.nimtego.tcal.model.ProjectProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        MyListAdapter myListAdapter = new MyListAdapter(getActivity(),
                R.layout.my_list_project_item, projectArray);
        setListAdapter(myListAdapter);
    }
    public class MyListAdapter extends ArrayAdapter<String> {

        private Context mContext;

        public MyListAdapter(Context context, int textViewResourceId,
                             String[] objects) {
            super(context, textViewResourceId, objects);
            mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // return super.getView(position, convertView, parent);

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = null;
            if (inflater != null) {
                row = inflater.inflate(R.layout.my_list_project_item, parent,
                        false);
            }
            String name = mProjectProvider.getProjectList().get(position).getNameProject();
            Date create = mProjectProvider.getProjectList().get(position).getCreateDate();
            Date change = mProjectProvider.getProjectList().get(position).getChangeDate();
            TextView nameProject = (TextView) row.findViewById(R.id.name_project_edit_text_blank);
            nameProject.setText(name);
            TextView createData = (TextView) row.findViewById(R.id.create_data_edit_text);
            createData.setText(create.toString());
            TextView changeData = (TextView) row.findViewById(R.id.change_data_edit_text);
            changeData.setText(change.toString());

            return row;
        }
    }
}

