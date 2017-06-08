package studentsmedia.app.tecsup.com.studentsmedia.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import studentsmedia.app.tecsup.com.studentsmedia.R;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.ImageAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.adapters.MyFragmentStatePagerAdapter;
import studentsmedia.app.tecsup.com.studentsmedia.fragments.EventsFragment;
import studentsmedia.app.tecsup.com.studentsmedia.fragments.EventsGalleryFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculamos el Tablayout con el ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);

        // Añadimos un layout Adapter al ViewPager
        MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EventsFragment(), "EVENTOS");
        adapter.addFragment(new EventsGalleryFragment(), "GALERIA");
        viewPager.setAdapter(adapter);

        // Añadimos íconos y ocultamos el texto al tabLayout
//        tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_menu_call);
//        tabLayout.getTabAt(0).setText("");
//        tabLayout.getTabAt(1).setIcon(android.R.drawable.ic_menu_camera);
//        tabLayout.getTabAt(1).setText("");

    }

}
