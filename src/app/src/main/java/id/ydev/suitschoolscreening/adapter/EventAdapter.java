package id.ydev.suitschoolscreening.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.ydev.suitschoolscreening.ProfileActivity;
import id.ydev.suitschoolscreening.R;
import id.ydev.suitschoolscreening.model.Event;

/**
 * Created by cahya on 21/02/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private List<Event> eventList;

    public EventAdapter(Context context, List<Event> eventList){
        this.context=context;
        this.eventList=eventList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.event_item,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event=eventList.get(position);
        holder.nama.setText(event.getNama());
        holder.tanggal.setText(event.getTanggal());
        holder.image.setImageResource(event.getImage());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nama;
        TextView tanggal;
        public EventViewHolder(View itemView) {
            super(itemView);

            nama=(TextView)itemView.findViewById(R.id.nama);
            tanggal=(TextView)itemView.findViewById(R.id.tanggal);
            image=(ImageView)itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, ProfileActivity.class);
                    intent.putExtra("nama_event", nama.getText().toString());
                    context.startActivity(intent);
                }
            });
        }
    }
}
