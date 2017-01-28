package app.travelling.srw;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 04/06/2016.
 */
public class ListDestinationAdapter extends BaseAdapter {

    private Context Cwisata;
    private List<Destination> Destinationlist;

    public ListDestinationAdapter(Context cwisata, List<Destination> destinationlist) {
        Cwisata = cwisata;
        Destinationlist = destinationlist;
    }

    @Override
    public int getCount() {
        return Destinationlist.size();
    }

    @Override
    public Object getItem(int position) {
        return Destinationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Destinationlist.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(Cwisata, R.layout.item_listview, null);
        TextView destinationName = (TextView)v.findViewById(R.id.textView_Destinasi);
        TextView destinationCategory = (TextView)v.findViewById(R.id.textView_Kategori);
        TextView destinationDescription = (TextView)v.findViewById(R.id.textView_Deskripsi);
        TextView destinationPrice = (TextView)v.findViewById(R.id.textView_Harga);
        TextView destinationFacility = (TextView)v.findViewById(R.id.textView_Fasilitas);
        TextView destinationDistance = (TextView)v.findViewById(R.id.textView_Jarak);
        destinationName.setText(Destinationlist.get(position).getName());
        destinationCategory.setText(Destinationlist.get(position).getCategory());
        destinationDescription.setText(Destinationlist.get(position).getDescription());
        destinationPrice.setText(Destinationlist.get(position).getPrice());
        destinationFacility.setText(Destinationlist.get(position).getFacility());
        destinationDistance.setText(Destinationlist.get(position).getDistance());

        return v;
    }
}
