package smtk.cf.a0_retrofit_ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        final TextView tv = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GithubService githubService
                        = GithubService.retrofit
                        .create(GithubService.class);

                Call<List<Item>> call = githubService
                        .repoContributors("MOCK_DATA.json");

                call.enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                        //tv.setText(response.body().toString());
                        if(response.isSuccessful()){
                            tv.setText(response.body().toString());
                        } else {
                            try {
                                tv.setText(response.errorBody().string());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });


            }
        });

    }

}
