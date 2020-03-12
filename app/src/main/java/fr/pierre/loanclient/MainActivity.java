package fr.pierre.loanclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private materialsApi materialsApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.254.1/loan/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        materialsApi materialsApi = retrofit.create(materialsApi.class);

        createMaterial();

        Call<List<Material>> call = materialsApi.getMaterials();

        call.enqueue(new Callback<List<Material>>() {
            @Override
            public void onResponse(Call<List<Material>> call, Response<List<Material>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Material> Materials = response.body();
                for (Material Material: Materials){
                    String content = "";
                    content += "ID: " + Material.getId() + "\n";
                    content += "Libelle: " + Material.getLibelle() + "\n\n";
                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Material>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
    private void createMaterial(){

        textViewResult = findViewById(R.id.text_view_result);
        Material material = new Material("Test");

        Call<Material> call = materialsApi.createMaterial(material);

        call.enqueue(new Callback<Material>() {
            @Override
            public void onResponse(Call<Material> call, Response<Material> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Material materialResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + materialResponse.getId() + "\n";
                content += "Libelle: " + materialResponse.getLibelle() + "\n\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Material> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
