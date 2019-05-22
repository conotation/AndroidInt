package smtk.cf.a0_sharedpref_ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText edtID, edtPW;
    Button btnLogin, btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtID = findViewById(R.id.edt_ID);
        edtPW = findViewById(R.id.edt_PW);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                String id = edtID.getText().toString();
                String pw = edtPW.getText().toString();
                i.putExtra("id", id);
                i.putExtra("pw", pw);
                startActivity(i);
                finish();
            }
        });

        btnJoin = findViewById(R.id.btn_join);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(i);
                finish();
            }
        });

        pref = getSharedPreferences("data", MODE_PRIVATE);
        String id = pref.getString("id", "");
        String pw = pref.getString("pw", "");

        if (!id.isEmpty())
            edtID.setText(id);

        if (!pw.isEmpty())
            edtPW.setText(pw);

    }
}
