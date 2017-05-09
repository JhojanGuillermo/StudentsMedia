package studentsmedia.app.tecsup.com.studentsmedia.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.EventsGalAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.models.EventGal;
import studentsmedia.app.tecsup.com.studentsmedia.repositories.EventRepository;

public class EventsGalleryActivity extends AppCompatActivity {

    private RecyclerView eventsGalList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_gallery);

        //Cambiar pantalla
        Button eventGal = (Button) findViewById(R.id.button_event);
        eventGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsGalleryActivity.this, EventsActivity.class));
            }
        });

        eventsGalList = (RecyclerView) findViewById(R.id.eventosGallery_list);

        eventsGalList.setLayoutManager(new LinearLayoutManager(this));

        List<EventGal> eventsGal = EventRepository.getEventsGal();
        eventsGalList.setAdapter(new EventsGalAdapter(eventsGal));
    }
}
