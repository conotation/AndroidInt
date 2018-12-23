package smtk.cf.tutorial05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sub2Activity extends AppCompatActivity {
    final int REQ_OK = 200;
    Button btn;
    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        edt1 = findViewById(R.id.editText);

        btn = findViewById(R.id.button_sub2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("data", edt1.getText().toString());
                setResult(REQ_OK, i);
                finish(); // MainActivity 호출 후 Activity 자신을 종료
            }
        });

    }
}
