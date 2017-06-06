package studentsmedia.app.tecsup.com.studentsmedia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.ImageAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.models.Event;
import studentsmedia.app.tecsup.com.studentsmedia.repositories.EventRepository;

public class Galeria extends AppCompatActivity {

    private int id;
    private String fullname;

    private String fecha;

    private String lugar;

    private String descripcion;

    private String picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        if (this.getIntent().getExtras() != null){
            Bundle bundle = this.getIntent().getExtras();
            id = bundle.getInt("ID");
//            fullname = bundle.getString("TituloEvent");
//            fecha = bundle.getString("FechaEvent");
//            lugar = bundle.getString("LugarEvent");
//            descripcion = bundle.getString("DescEvent");
            //picture = bundle.getString("ImageEvent");
        }

        //llamara al servicio por ID o buscar en tu lista el objeto por ese ID
        //Galeria de fotos
//        TextView titEvent = (TextView) findViewById(R.id.titulo_text);
//            titEvent.setText(fullname);
//        TextView fechEvent = (TextView) findViewById(R.id.fechaText);
//            fechEvent.setText(fecha);
//        TextView lugEvent = (TextView) findViewById(R.id.lugarText);
//            lugEvent.setText(lugar);
//        TextView descEvent = (TextView) findViewById(R.id.descripcion_text);
//            descEvent.setText(descripcion);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        //textView.setText("Galeria " + id);

        gridView.setAdapter(new ImageAdapter(this));

        Event event = EventRepository.getEvents(id);
        TextView titEvent = (TextView) findViewById(R.id.titulo_text);
            titEvent.setText(event.getFullname());
        TextView fechEvent = (TextView) findViewById(R.id.fechaText);
            fechEvent.setText(event.getFecha());
        TextView lugEvent = (TextView) findViewById(R.id.lugarText);
            lugEvent.setText(event.getLugar());
        TextView descEvent = (TextView) findViewById(R.id.descripcion_text);
            descEvent.setText(event.getDescripcion());
        ImageView img = (ImageView) findViewById(R.id.portada_img);
        int idPortada = this.getResources().getIdentifier(event.getPicture(), "drawable", this.getPackageName());
        img.setImageResource(idPortada);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), studentsmedia.app.tecsup.com.studentsmedia.activities.FullImageActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}
