package de.com.view;

import android.content.Context;
import android.widget.ArrayAdapter;


import java.util.HashMap;
import java.util.List;

import de.com.models.Flight;

public class FlightArrayAdapter extends ArrayAdapter<Flight> {

    HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();

    public FlightArrayAdapter(Context context, int resource, List<Flight> objects) {
        super(context, resource, objects);

        for (int i = 0; i < objects.size(); ++i) {
            flights.put(i, objects.get(i));
        }
    }

   @Override
   public Flight getItem(int position){
       return flights.get(position);
   }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
