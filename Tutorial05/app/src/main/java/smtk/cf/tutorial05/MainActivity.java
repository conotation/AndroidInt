package smtk.cf.tutorial05;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int REQ_1 = 101, REQ_2 = 102;
    TextView tv1, tv2;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView5);
        tv2 = findViewById(R.id.textView6);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SubActivity.class);
                startActivityForResult(i, REQ_1);
                tv1.setText("");
                tv2.setText("");
            }
        });

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Sub2Activity.class);
                startActivityForResult(i, REQ_2);
                tv1.setText("");
                tv2.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQ_1:
                    tv1.setText("" + data.getIntExtra("data", 0));   // getStringExtra(key)
                    tv2.setText("" + requestCode);
                    break;
                case REQ_2:
                    tv1.setText(data.getStringExtra("data"));   // getIntExtra(key, default value)
                    tv2.setText("" + requestCode);
                    break;
            }
        }
    }
}
