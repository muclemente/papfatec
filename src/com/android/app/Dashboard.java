package com.android.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

public class Dashboard extends Activity implements OnClickListener{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dash);
		
		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ButtonAdapter(this));
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}

class ButtonAdapter extends BaseAdapter {
    private Context mContext;

    public ButtonAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageButton buttonView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	buttonView = new ImageButton(mContext);
        	buttonView.setLayoutParams(new GridView.LayoutParams(130, 200 ));
        } else {
        	buttonView = (ImageButton) convertView;
        }

        buttonView.setImageResource(mThumbIds[position]);
        return buttonView;
    }

    // references to our images
    private Integer[] mThumbIds = {
    		R.drawable.circulo, R.drawable.circulo,
    		R.drawable.circulo, R.drawable.circulo
    };
}
