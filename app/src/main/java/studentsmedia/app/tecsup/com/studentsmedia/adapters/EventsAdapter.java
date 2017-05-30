package studentsmedia.app.tecsup.com.studentsmedia.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.activities.Galeria;
import studentsmedia.app.tecsup.com.studentsmedia.fragments.EventsFragment;
import studentsmedia.app.tecsup.com.studentsmedia.models.Event;

/**
 * Created by JShanksX13 on 2/04/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private Activity activity;

    private List<Event> events;

    public EventsAdapter(EventsFragment eventsFragment, List<Event> events) {this.events = new ArrayList<>(); }

    public EventsAdapter(Activity activity, List<Event> events) {this.events = events; this.activity = activity;}



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView picture;
        public TextView fullname;
        public TextView fecha;
        public TextView lugar;

        public ViewHolder(View itemView){
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            fecha = (TextView) itemView.findViewById(R.id.fecha_text);
            lugar = (TextView) itemView.findViewById(R.id.lugar_text);
        }
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder viewHolder, final int position) {
        final Event event = this.events.get(position);
        viewHolder.fullname.setText(event.getFullname());
        viewHolder.fecha.setText(event.getFecha());
        viewHolder.lugar.setText(event.getLugar());

        Context context = viewHolder.itemView.getContext();
        int idRes = context.getResources().getIdentifier(event.getPicture(), "drawable", context.getPackageName());
        viewHolder.picture.setImageResource(idRes);

        //ver su respectivo detalle
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Galeria.class);

                    intent.putExtra("ID", event.getId());
                    activity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.events.size();
    }

}
