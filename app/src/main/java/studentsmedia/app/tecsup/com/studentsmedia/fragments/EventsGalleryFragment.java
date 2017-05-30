package studentsmedia.app.tecsup.com.studentsmedia.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.activities.Galeria;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.EventsGalAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.models.EventGal;
import studentsmedia.app.tecsup.com.studentsmedia.repositories.EventRepository;

public class EventsGalleryFragment extends Fragment {

    private RecyclerView eventsGalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_events_gallery, container, false);


        eventsGalList = (RecyclerView) view.findViewById(R.id.eventosGallery_list);

        eventsGalList.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<EventGal> eventsGal = EventRepository.getEventsGal();
        eventsGalList.setAdapter(new EventsGalAdapter(eventsGal));

        return view;



    }

}
