package vn.eas.app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by phongvt on 5/24/17.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private String[] tenLogo;
    private int[] hinhLogo;

    public GridViewAdapter(Context context, String[] tenLogo, int[] hinhLogo) {
        this.context = context;
        this.tenLogo = tenLogo;
        this.hinhLogo = hinhLogo;
    }

    @Override
    public int getCount() {
        return tenLogo.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.gridview_layout,null);
        TextView textView = (TextView)convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
        textView.setText(tenLogo[position]);
        imageView.setImageResource(hinhLogo[position]);
        return convertView;
    }
    public String getcurrentName(int position){
        return tenLogo[position];
    }
}
