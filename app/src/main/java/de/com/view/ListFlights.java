package com.view;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.flightright.flights.R;
import com.models.ClaimCheckResult;
import com.models.Flight;
import com.services.ClaimCheckService;
import com.services.FlightScanService;
import com.services.hardcoded.HardCodedClaimCheck;
import com.services.hardcoded.HardCodedFlightScan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListFlights extends ActionBarActivity {

    FlightScanService flightScanService = new HardCodedFlightScan();
    ClaimCheckService claimCheckService = new HardCodedClaimCheck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_flights);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_flights, menu);
        return true;
    }

    public void scanForFlights(View view) {

        Button findButton = (Button) view;
        findButton.setText("Scanning for flights...");
        findButton.setEnabled(false);

        ListView listView = (ListView) findViewById(R.id.listView);
        final List<Flight> flights = flightScanService.findFlights();
        final FlightArrayAdapter ad = new FlightArrayAdapter(this, android.R.layout.simple_list_item_1, flights);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final Flight item = (Flight) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                // flights.remove(item);
                                //ad.notifyDataSetChanged();
                                //view.setAlpha(1);
                                ClaimCheckResult claimCheckResult = claimCheckService.runClaimCheck(item);
                                item.flightNumber = Integer.toString(claimCheckResult.amountClaimed);
                            }
                        });
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }


}
