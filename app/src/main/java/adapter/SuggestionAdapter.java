package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.genbuzz.merygoesshopping.R;
import java.util.ArrayList;
import java.util.List;
import model.Suggestion;

/***
 * Created by Ivan on 27/04/2016.
 */

public class SuggestionAdapter extends ArrayAdapter<Suggestion>{

    private Context context;
    private int resource, txtViewResourceId;
    private List<Suggestion> items, tempItems, suggestions;

    public SuggestionAdapter(Context context, int resource, int textViewResourceId, List<Suggestion> items) {
        super(context, resource, textViewResourceId, items);
        this.context = context;
        this.resource = resource;
        this.txtViewResourceId = textViewResourceId;
        this.items = items;
        tempItems = new ArrayList<Suggestion>(items); // this makes the difference.
        suggestions = new ArrayList<Suggestion>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_suggestion, parent, false);
        }
        Suggestion suggestion = items.get(position);
        if (suggestion != null) {
            TextView lblName = (TextView) view.findViewById(R.id.row_suggestion_txt_view_name);
            if (lblName != null)
                lblName.setText(suggestion.getName());
        }
        return view;
    }

    /**
     * Custom Filter implementation for custom suggestions we provide.
     */
    Filter nameFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            String str = ((Suggestion) resultValue).getName();
            return str;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (Suggestion suggestion : tempItems) {
                    if (suggestion.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        suggestions.add(suggestion);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<Suggestion> filterList = (ArrayList<Suggestion>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (Suggestion suggestion : filterList) {
                    add(suggestion);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
