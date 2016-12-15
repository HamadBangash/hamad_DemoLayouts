package dgaps.android.demolayouts;

import android.content.Context;
import android.net.Uri;
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


public class ViewFragment extends Fragment {
    ListView itemsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_view, container, false);
        itemsList = (ListView) view.findViewById(R.id.itemsList);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add("Photo");
        fileNames.add("Movie");
        fileNames.add("Song");
        myArrayAdapter arrayAdapter = new myArrayAdapter(getActivity(), fileNames);
        itemsList.setAdapter(arrayAdapter);
        return view;
    }

    class myArrayAdapter extends ArrayAdapter {

        List<String> files;
        Context context;

        public myArrayAdapter(Context context, List<String> files) {
            super(context, R.layout.row_item_view, files);
            this.context = context;
            this.files = files;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.row_item_view, parent, false);
            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            tvName.setText(files.get(position).toString());
            return view;
        }
    }


}
