package net.wasnot.wifitracker;

import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akihiroaida on 2014/07/16.
 */
public
class TestAdapter extends ArrayAdapter<ScanResult> {

    Resources mResources;
    List<ScanResult> mItems;
    LayoutInflater mInflater;
    int mResource;
    int mTextResId;

    public TestAdapter( Context context, int resourceId, int textViewResourceId, List<ScanResult> objects ) {
        super( context, resourceId, textViewResourceId, objects );
        mResources=context.getResources();
        mInflater = LayoutInflater.from( context );
        mResource = resourceId;
        mTextResId = textViewResourceId;
        mItems = objects;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId( int position ) {
        return getItem( position ).hashCode();
    }

//    @Override
//    public int getViewTypeCount() {
//        return 3;
//    }
//
//    @Override
//    public int getItemViewType( int position ) {
//        return position%3;
//    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        if( null == convertView ) {
            convertView = mInflater.inflate( mResource, parent, false );
        }

        TextView textView = (TextView) convertView.findViewById( mTextResId );
        ScanResult item = getItem(position);
        textView.setText( item.SSID+"\n"+item.level+"dBm" );

//        int type = getItemViewType( position );
//
//        ViewGroup.LayoutParams params = convertView.getLayoutParams();
//        if( type == 0 ) {
//            params.width =mResources.getDimensionPixelSize( R.dimen.item_size_1 );
//        } else if( type == 1 ) {
//            params.width = mResources.getDimensionPixelSize( R.dimen.item_size_2 );
//        } else {
//            params.width = mResources.getDimensionPixelSize( R.dimen.item_size_3 );
//        }

        return convertView;
    }
}
