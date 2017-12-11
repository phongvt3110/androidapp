package vn.eas.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class DangnhapActivity extends AppCompatActivity {
    public GridView gridView;
    public Button btnSqlite,btnFirebase,btnRecyclerView;
    int[] hinh = {
      R.drawable.images,R.drawable.images_1,
            R.drawable.images_2,R.drawable.images_3,R.drawable.images_4,R.drawable.images_5,
            R.drawable.images_6,R.drawable.images_7,R.drawable.images_8,R.drawable.images_9,R.drawable.images_10,
            R.drawable.images_11,R.drawable.images12,R.drawable.images_13,R.drawable.images_14,R.drawable.images_15,R.drawable.images_16,
            R.drawable.images_17,R.drawable.images_18,R.drawable.images_19
    };
    String[] ten = new String[hinh.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        mapButton();
        gridView = (GridView)findViewById(R.id.gridviewid);
        for (int i = 0; i < hinh.length; i ++){
            ten[i] = "images_" + Integer.toString(i+1);
        }
        final GridViewAdapter gridViewAdapter = new GridViewAdapter(this,ten,hinh);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DangnhapActivity.this,gridViewAdapter.getcurrentName(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void mapButton(){
        btnSqlite  = (Button)findViewById(R.id.btn_sqlite);
        btnFirebase  = (Button)findViewById(R.id.btn_firebase);
        btnRecyclerView = (Button)findViewById(R.id.btn_recyclerView);

        btnFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangnhapActivity.this,Firebase_Activity.class);
                startActivity(intent);
            }
        });

        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangnhapActivity.this,RecycleviewActivity.class);
                startActivity(intent);
            }
        });
    }
}
