package studentsmedia.app.tecsup.com.studentsmedia.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import java.util.List;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.EventsAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.models.Event;
import studentsmedia.app.tecsup.com.studentsmedia.repositories.EventRepository;

/**
 * Created by JShanksX13 on 2/04/2017.
 */

public class EventsActivity extends AppCompatActivity{

    private RecyclerView eventsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        //Cambiar pantalla
        Button event = (Button) findViewById(R.id.button_eventGal);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsActivity.this, EventsGalleryActivity.class));
            }
        });

        eventsList = (RecyclerView) findViewById(R.id.eventos_list);

        eventsList.setLayoutManager(new GridLayoutManager(this, 2));
        eventsList.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));

        List<Event> events = EventRepository.getEvents();
        eventsList.setAdapter(new EventsAdapter(events));
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}