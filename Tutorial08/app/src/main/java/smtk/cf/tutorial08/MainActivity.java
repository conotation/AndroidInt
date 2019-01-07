package smtk.cf.tutorial08;

import android.Manifest;
import android.content.Context;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private String fFilename;
    private ListView lv;
    private Context context = this;

    private List<String> fItem   = null;
    private List<String> fPath = null;
    private String mRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
    private TextView tvPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,
                REQUIRED_PERMISSIONS,
                PERMISSIONS_REQUEST_CODE);

        tvPath = findViewById(R.id.tvPath);
        lv = findViewById(R.id.lvFileControl);
        getDir(mRoot);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File file = new File(fPath.get(position));

                if (file.isDirectory()) {
                    if (file.canRead())
                        getDir(fPath.get(position));
                    else {
                        Toast.makeText(context, "No files in this folder.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    fFilename = file.getName();
                    Log.i("Test", "ext:" + fFilename.substring(fFilename.lastIndexOf('.') + 1, fFilename.length()));
                }
            }
        });
    }

    private void getDir(String dirPath){
        tvPath.setText(String.format("Location %s", dirPath));

        fItem = new ArrayList<>();
        fPath = new ArrayList<>();

        File f = new File(dirPath);
        File[] files = f.listFiles();

        if(!dirPath.equals(mRoot)){
            fItem.add("../");
            fPath.add(f.getParent());
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            fPath.add(file.getAbsolutePath());

            if (file.isDirectory())
                fItem.add(file.getName() + "/");
            else
                fItem.add(file.getName());
        }

        ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fItem);
        lv.setAdapter(fileList);
    }
}


/*
  http://www.androidside.com/bbs/board.php?bo_table=B56&wr_id=31381
 */