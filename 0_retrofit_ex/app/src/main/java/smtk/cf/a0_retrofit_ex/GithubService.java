package smtk.cf.a0_retrofit_ex;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface GithubService {

    @GET("files/{file}")
    Call<List<Item>> repoContributors(
            @Path("file") String file
    );

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://precs.ivyro.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
