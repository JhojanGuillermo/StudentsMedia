package studentsmedia.app.tecsup.com.studentsmedia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.ImageAdapter;

public class Galeria extends AppCompatActivity {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        if (this.getIntent().getExtras() != null){
            Bundle bundle = this.getIntent().getExtras();
            id = bundle.getInt("ID");
        }

        //llamara al servicio por ID o buscar en tu lista el objeto por ese ID
        //Galeria de fotos
        TextView textView = (TextView) findViewById(R.id.titulo);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        textView.setText("Galeria " + id);

        gridView.setAdapter(new ImageAdapter(this));

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
