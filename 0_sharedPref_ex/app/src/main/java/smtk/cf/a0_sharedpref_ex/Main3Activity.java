package smtk.cf.a0_sharedpref_ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText edtID, edtPW;
    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtID = findViewById(R.id.edt_ID);
        edtPW = findViewById(R.id.edt_PW);
        btnJoin = findViewById(R.id.btn_join);

        pref = getSharedPreferences("data", MODE_PRIVATE);
        editor = pref.edit();

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                String pw = edtPW.getText().toString();

                editor.putString("id", id);
                editor.putString("pw", pw);
                editor.apply();

                Toast.makeText(Main3Activity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
