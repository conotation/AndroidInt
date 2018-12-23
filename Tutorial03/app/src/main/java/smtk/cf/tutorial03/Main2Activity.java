package smtk.cf.tutorial03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                finish();
                break;
        }
    }
}
