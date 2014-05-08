package code;
import java.util.ArrayList;
  

import com.co2mpare.R;
  

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
  
public class ListAdapter extends BaseAdapter {
    private static ArrayList<Route> searchArrayList;
  
    private LayoutInflater mInflater;
  
    public ListAdapter(Context context, ArrayList<Route> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }
  
    public int getCount() {
        return searchArrayList.size();
    }
  
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }
  
    public long getItemId(int position) {
        return position;
    }
  

    
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtvehicle = (TextView) convertView.findViewById(R.id.vehicle);
            holder.txtmoney = (TextView) convertView.findViewById(R.id.money);
            holder.txtco2 = (TextView) convertView.findViewById(R.id.co2);
            holder.txttime = (TextView) convertView.findViewById(R.id.time);
            holder.txtdistance = (TextView) convertView.findViewById(R.id.distance);
         
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        Log.e("Test: ",searchArrayList.get(position).getLength()+"");
        
        holder.txtvehicle.setText(searchArrayList.get(position).getType());
        holder.txtco2.setText(searchArrayList.get(position).getCO2()+" g/km");
        holder.txtmoney.setText(searchArrayList.get(position).getCosts()+" EUR");
        holder.txttime.setText(searchArrayList.get(position).getDuration()+" sec");
        holder.txtdistance.setText(searchArrayList.get(position).getLength()+" m");
  
        return convertView;
    }
  
    static class ViewHolder {
        TextView txtvehicle;
        TextView txtmoney;
        TextView txtco2;
        TextView txttime;
        TextView txtdistance;
    }
}