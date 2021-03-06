package studentsmedia.app.tecsup.com.studentsmedia.repositories;

import java.util.ArrayList;
import java.util.List;

import studentsmedia.app.tecsup.com.studentsmedia.models.Event;
import studentsmedia.app.tecsup.com.studentsmedia.models.EventGal;

/**
 * Created by JShanksX13 on 2/04/2017.
 */

public class EventRepository {

    private static List<Event> events;

    static {
        events = new ArrayList<>();
        events.add( new Event(100, "Fiesta de Inauguracion", "16/04/2017", "Tecsup","asdasdasd", "fiesta") );
        events.add( new Event(200, "Bienvenida a Cachimbos", "10/03/2017", "Tecsup","asdsadsddd", "bienvenida") );

    }

    public static List<Event> listEvents() {
        return events;
    }

    public static Event getEvents(int id) {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    //Galeria

    private static List<EventGal> eventsGal;

    static {
        eventsGal = new ArrayList<>();
        eventsGal.add( new EventGal(100, "Fiesta de Inauguracion", "16/04/2017", "fiesta"));
        eventsGal.add( new EventGal(200, "Cachimbos", "10/03/2017", "bienvenida"));
    }

    public  static List<EventGal> getEventsGal(){ return eventsGal;}
}
