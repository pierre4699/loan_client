package fr.pierre.loanclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMaterials();
    }

    public void listMaterials(){
        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.254.1/loan/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        materialsApi materialsApi = retrofit.create(materialsApi.class);


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
/*                    final int id_del = Material.getId();
                    final Button button = findViewById(R.id.button_id);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            deleteMaterial(id_del);
                        }
                    });*/

                }
            }

            @Override
            public void onFailure(Call<List<Material>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void createMaterial(String libelle){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.254.1/loan/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        materialsApi materialsApi = retrofit.create(materialsApi.class);

        Call<Material> call = materialsApi.createMaterial(libelle);

        call.enqueue(new Callback<Material>() {
            @Override
            public void onResponse(Call<Material> call, Response<Material> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

            }

            @Override
            public void onFailure(Call<Material> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void deleteMaterial(int id){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.254.1/loan/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        materialsApi materialsApi = retrofit.create(materialsApi.class);

        Call<Void> call = materialsApi.deleteMaterial(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void postRequest(View view) {

        TextView materialAdd = findViewById(R.id.materialAdd);
        String libelle = materialAdd.getText().toString();

        createMaterial(libelle);
    }
}
