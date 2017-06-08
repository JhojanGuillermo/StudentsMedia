package studentsmedia.app.tecsup.com.studentsmedia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studentsmedia.app.tecsup.com.studentsmedia.ApiService;
import studentsmedia.app.tecsup.com.studentsmedia.ApiServiceGenerator;
import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.ImageAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.models.Event;

public class Galeria extends AppCompatActivity {

    private static final String TAG = Galeria.class.getSimpleName();


    private int id;
    private String titulo;

    private String fecha;

    private String lugar;

    private String descripcion;

    private String imagen;

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

//        TextView titEvent = (TextView) findViewById(R.id.titulo_text);
//            titEvent.setText(event.getTitulo());
//        TextView fechEvent = (TextView) findViewById(R.id.fechaText);
//            fechEvent.setText(event.getFecha());
//        TextView lugEvent = (TextView) findViewById(R.id.lugarText);
//            lugEvent.setText(event.getLugar());
//        TextView descEvent = (TextView) findViewById(R.id.descripcion_text);
//            descEvent.setText(event.getDescripcion());
//        ImageView img = (ImageView) findViewById(R.id.portada_img);
//        int idPortada = this.getResources().getIdentifier(event.getImagen(), "drawable", this.getPackageName());
//        img.setImageResource(idPortada);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), studentsmedia.app.tecsup.com.studentsmedia.activities.FullImageActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });

        initialize();
    }
    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<Event> call = service.getEvent(id);

        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        Event event = response.body();
                        Log.d(TAG, "eventos: " + event);

                        //Noticia noticia = NoticiaRepository.getNoticias(id);

                        TextView titEvent = (TextView) findViewById(R.id.titulo_text);
                        titEvent.setText(event.getTitulo());
                        TextView fechEvent = (TextView) findViewById(R.id.fechaText);
                        fechEvent.setText(event.getFecha());
                        ImageView img = (ImageView) findViewById(R.id.portada_img);
                        Picasso.with(Galeria.this).load("https://usuarios-api-martincs27.c9users.io/images/eventos/"+ event.getImagen()).into(img);
                        TextView lugEvent = (TextView) findViewById(R.id.lugarText);
                        lugEvent.setText(event.getLugar());
                        TextView descEvent = (TextView) findViewById(R.id.descripcion_text);
                        descEvent.setText(event.getDescripcion());

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Galeria.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Galeria.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}


