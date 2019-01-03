package smtk.cf.tutorial07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    List<String> l;
    MainAdapter ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ma = new MainAdapter();

        for(int i = 0; i<10; i++){
            ma.addItem("#88ff22", String.format("data%d", i));
        }

        lv.setAdapter(ma);

    }
}
