package smtk.cf.a0_listview_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    MainAdapter ma;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });
        ma = new MainAdapter();

        ma.addItem("#884422", String.format("data 1번"));
        ma.addItem("#444444", String.format("data 2번"));
        ma.addItem("#44ff22", String.format("data 3번"));
        ma.addItem("#ffff22", String.format("data 4번"));
        ma.addItem("#8833bb", String.format("data 5번"));

        lv.setAdapter(ma);
    }
}
