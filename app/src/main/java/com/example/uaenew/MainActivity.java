package com.example.uaenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ProgressDialog progress;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = new ProgressDialog(this);
        progress.setMessage("Loading.....!");
        progress.show();
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setItemViewCacheSize(50);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<UAEData>> call = service.getAllData();
        call.enqueue(new Callback<List<UAEData>>() {
            @Override
            public void onResponse(Call<List<UAEData>> call, Response<List<UAEData>> response) {
                progress.dismiss();
                Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
               // generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<UAEData>> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<UAEData> body) {

        adapter = new Adapter(body,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}