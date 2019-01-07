package smtk.cf.a0_listview_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    Main2Adapter ma;
    ListView lv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.lv);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        ma = new Main2Adapter();

        ma.addContent("김민석", "010-6697-5335", "07/02", 1);
        ma.addContent("홍길동", "010-1234-5678", "01/01", 2);
        ma.addContent("고길동", "010-8762-1234", "01/03", 3);
        ma.addContent("석민김", "010-5335-7966", "02/07", 4);

        lv.setAdapter(ma);
    }
}
