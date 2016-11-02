package carlos.whatsapp_dmob.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import carlos.whatsapp_dmob.R;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mStrings;

    public MyAdapter(Context context, ArrayList<String> mStrings) {
        mContext = context;
        this.mStrings = mStrings;
    }

    public int getCount() {
        return mStrings.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null){
            if(getItemViewType(position) == 0)
                convertView = LayoutInflater.from(mContext).inflate(R.layout.row_whatsapp_right, parent, false);
            if(getItemViewType(position) == 1)
                convertView = LayoutInflater.from(mContext).inflate(R.layout.row_whatsapp_left, parent, false);
            if(getItemViewType(position) == 2)
                convertView = LayoutInflater.from(mContext).inflate(R.layout.row_whatsapp_date, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.text  = (TextView)  convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder)convertView.getTag();
        if(getItemViewType(position) == 0 || getItemViewType(position) == 1)
            viewHolder.text.setText(mStrings.get(position));
        if(getItemViewType(position) == 2){
            Date date = new Date();
            viewHolder.text.setText(date.toLocaleString());
        }

        return convertView;
    }

    public class ViewHolder{
        TextView text;
    }

    public Object getItem(int arg0) {
        return mStrings.get(arg0);
    }

    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3; // Count of different layouts
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

}

