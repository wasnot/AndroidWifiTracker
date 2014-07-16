package net.wasnot.wifitracker.utils;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by akihiroaida on 2014/07/16.
 */
public class WifiUtil {

    public static void test(Context con) {
        WifiManager m = (WifiManager) con.getSystemService(Context.WIFI_SERVICE);
        m.startScan();
    }
}
