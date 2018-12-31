package smtk.cf.tutorial06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Button btn;
    EditText edt_id, edt_pw;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn = findViewById(R.id.btn_login);

        pref = getSharedPreferences("data", MODE_PRIVATE);
        editor = pref.edit();


        Intent i = getIntent();
        flag = (i.getIntExtra("sign", 1) == 1);
        if (flag) {
            btn.setText("sign in");
        } else {
            btn.setText("sign up");
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();

                if (flag) { // up
                    if (pref.getString("id", "").equals(id) && pref.getString("pw", "").equals(pw)) {
                        Toast.makeText(Main2Activity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(Main2Activity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }
                } else {    // in
                    if (pref.getString("id", "").equals(id)) {
                        Toast.makeText(Main2Activity.this, "아이디 중복", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    editor.putString("id", id);
                    editor.putString("pw", pw);
                    editor.apply();

                    Toast.makeText(Main2Activity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
