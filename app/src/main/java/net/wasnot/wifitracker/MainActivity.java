package net.wasnot.wifitracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.widget.HListView;


public class MainActivity extends Activity {

    @InjectView(R.id.textView)
    public TextView textView;
    @InjectView(R.id.listView)
    public HListView listView;

    private WifiReceiver mReceiver;
    private WifiManager mWifiManager;
    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mReceiver = new WifiReceiver();
        IntentFilter filter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(mReceiver, filter);
        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mWifiManager.startScan();

//        List<String> items = new ArrayList<String>();
//        for( int i = 0; i < 50; i++ ) {
//            items.add( String.valueOf( i ) );
//        }

        mAdapter = new TestAdapter(this, R.layout.item_wifi, R.id.textView,
                mWifiManager.getScanResults());
        listView.setHeaderDividersEnabled(true);
        listView.setFooterDividersEnabled(true);

        listView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class WifiReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context c, Intent intent) {
            StringBuilder sb = new StringBuilder();
            List<ScanResult> wifiList = mWifiManager.getScanResults();
//            for (int i = 0; i < wifiList.size(); i++) {
//                sb.append(new Integer(i + 1).toString() + ".");
//                sb.append((wifiList.get(i)).toString());
//                sb.append("\n");
//            }
//            textView.setText(sb);
            mAdapter.mItems = wifiList;
            mAdapter.notifyDataSetChanged();
        }
    }
}
