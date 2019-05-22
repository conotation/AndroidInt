package smtk.cf.a0_sharedpref_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn_back);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String pw = i.getStringExtra("pw");

        tv.setText(String.format("ID: %s, PW: %s", id, pw));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                finish();
            }
        });

    }
}
