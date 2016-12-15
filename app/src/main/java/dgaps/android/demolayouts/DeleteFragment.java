package dgaps.android.demolayouts;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DeleteFragment extends Fragment {
    ListView itemsList;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        itemsList = (ListView) view.findViewById(R.id.itemsList);
        List<String> fileNames = new ArrayList<>();
        List<String> date = new ArrayList<>();
        date.add("10/9/16");
        date.add("1/9/15");
        date.add("11/10/15");
        date.add("10/9/16");
        date.add("10/9/16");
        date.add("10/9/16");
        fileNames.add("File 1");
        fileNames.add("File 2");
        fileNames.add("File 3");
        fileNames.add("File 4");
        fileNames.add("File 5");
        fileNames.add("File 6");
        myArrayAdapter arrayAdapter = new myArrayAdapter(getActivity(), fileNames, date);
        itemsList.setAdapter(arrayAdapter);
        return view;
    }


    class myArrayAdapter extends ArrayAdapter {

        List<String> files;
        Context context;
        List<String> date;

        public myArrayAdapter(Context context, List<String> files, List<String> date) {
            super(context, R.layout.row_item_delete, files);
            this.context = context;
            this.files = files;
            this.date = date;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.row_item_delete, parent, false);
            TextView tvFileName = (TextView) view.findViewById(R.id.tvFileName);
            TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvDate.setText(date.get(position));
            tvFileName.setText(files.get(position));
            return view;
        }
    }

}
