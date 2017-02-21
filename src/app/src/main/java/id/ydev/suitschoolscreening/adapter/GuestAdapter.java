package id.ydev.suitschoolscreening.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.ydev.suitschoolscreening.GuestActivity;
import id.ydev.suitschoolscreening.ProfileActivity;
import id.ydev.suitschoolscreening.R;
import id.ydev.suitschoolscreening.model.Guest;

/**
 * Created by cahya on 21/02/17.
 */

public class GuestAdapter extends BaseAdapter {
    private Context context;
    private List<Guest> guestList;

    public GuestAdapter(Context context, List<Guest> guestList) {
        this.context = context;
        this.guestList = guestList;
    }

    @Override
    public int getCount() {
        return guestList.size();
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
        final Guest guest=guestList.get(position);
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.guest_item,parent,false);
        }
        ImageView imageContainer=(ImageView)convertView.findViewById(R.id.image);
        TextView namaContainer=(TextView)convertView.findViewById(R.id.nama);

        imageContainer.setImageResource(guest.getImage());
        namaContainer.setText(guest.getNama());

        String[] strings=guest.getBirthDate().split("-");
        final int tanggal=Integer.parseInt(strings[2]);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ProfileActivity.class);
                intent.putExtra("nama_guest",guest.getNama());
                intent.putExtra("tanggal",tanggal);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
