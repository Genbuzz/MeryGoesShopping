package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

/***
 * Created by Ivan on 27/04/2016.
 */

public class SuggestionAdapter extends ArrayAdapter<String> implements Filterable {

    private ArrayList<String> fullStringList;
    private ArrayList<String> originalValues;
    private ArrayFilter arrayFilter;

    public SuggestionAdapter(Context context, int resource,
                             int textViewResourceId, ArrayList<String> fullList) {

        super(context, resource, textViewResourceId, fullList);
        this.fullStringList = fullList;
        originalValues = new ArrayList<>(fullList);

    }

    @Override
    public int getCount() {
        return fullStringList.size();
    }

    @Override
    public String getItem(int position) {
        return fullStringList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public Filter getFilter() {
        if (arrayFilter == null) {
            arrayFilter = new ArrayFilter();
        }
        return arrayFilter;
    }


    /**
     *
     */
    private class ArrayFilter extends Filter {

        private Object lock = null;

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (originalValues == null) {
                synchronized (lock) {
                    originalValues = new ArrayList<>(fullStringList);
                }
            }

            if (prefix == null || prefix.length() == 0) {
                synchronized (lock) {
                    ArrayList<String> list = new ArrayList<>(
                            originalValues);
                    results.values = list;
                    results.count = list.size();
                }
            } else {
                final String prefixString = prefix.toString().toLowerCase();

                ArrayList<String> values = originalValues;
                int count = values.size();

                ArrayList<String> newValues = new ArrayList<>(count);

                for (int i = 0; i < count; i++) {
                    String item = values.get(i);
                    if (item.toLowerCase().contains(prefixString)) {
                        newValues.add(item);
                    }

                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.values != null) {
                fullStringList = (ArrayList<String>) results.values;
            } else {
                fullStringList = new ArrayList<>();
            }
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }

}
