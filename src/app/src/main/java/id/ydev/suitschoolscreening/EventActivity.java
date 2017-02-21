package id.ydev.suitschoolscreening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ydev.suitschoolscreening.adapter.EventAdapter;
import id.ydev.suitschoolscreening.model.Event;

public class EventActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager lm;
    private EventAdapter adapter;
    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        eventList=new ArrayList<>();
        eventList.add(new Event(R.drawable.dummy,"abc event","15 Sept 2014"));
        eventList.add(new Event(R.drawable.dummy,"def event","16 Sept 2014"));
        eventList.add(new Event(R.drawable.dummy,"ghi event","17 Sept 2014"));
        eventList.add(new Event(R.drawable.dummy,"jkl event","18 Sept 2014"));

        recyclerView=(RecyclerView)findViewById(R.id.event_recyclerview);
        lm=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(lm);
        adapter=new EventAdapter(this,eventList);
        recyclerView.setAdapter(adapter);
    }
}
