package smtk.cf.tutorial06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.show_id_pw);

        pref = getSharedPreferences("data", MODE_PRIVATE);
        editor = pref.edit();

        if(!pref.getString("id", "").isEmpty()){
            tv.setText(String.format("ID: %s\nPW: %s", pref.getString("id", ""), pref.getString("pw", "")));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sin:  // sign in = 1
                Intent in = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(in);
                finish();
                break;
            case R.id.sup:  // sign up = 0
                Intent up = new Intent(getApplicationContext(), Main2Activity.class);
                up.putExtra("sign", 0);
                startActivity(up);
                finish();
                break;
        }
    }
}
