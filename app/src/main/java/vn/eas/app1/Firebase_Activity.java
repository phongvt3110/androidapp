package vn.eas.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.realtime.util.StringListReader;

import java.util.ArrayList;

public class Firebase_Activity extends AppCompatActivity {

    public Button btn_createFirebaseData,btn_readFirebaseData;
    public ListView listViewFirebase;
    private static Firebase myfirebase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        mapControls();

    }
    private final Firebase getFirebaseInstance(){
        if(myfirebase == null){
            Firebase.setAndroidContext(this);
            myfirebase = new Firebase("https://blistering-torch-8603.firebaseio.com/");
        }
        return myfirebase;
    }
    private void createDataFirebase(Firebase firebase){
        for (int i = 0; i < 20; i++){
            firebase.child("DevPro").child(String.valueOf(i)).setValue("Value " + i);
        }
    }
    private void mapControls(){
        btn_createFirebaseData = (Button)findViewById(R.id.btn_createdata);
        btn_readFirebaseData = (Button)findViewById(R.id.btn_readdatafirebase);
        listViewFirebase = (ListView)findViewById(R.id.lvFirebase);

        btn_createFirebaseData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDataFirebase(getFirebaseInstance());
                Monhoc monh = new Monhoc("Android",9000000);
                Toast.makeText(Firebase_Activity.this,monh.getMonhoc() + " " + monh.getHocphi()+ "has been written on your Firebase data",Toast.LENGTH_SHORT).show();
                getFirebaseInstance().child("Learning").child("Programming").setValue(monh);
            }
        });

        btn_readFirebaseData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> lvname = new ArrayList<String>();
                final ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,lvname);
                listViewFirebase.setAdapter(adapter);
                getFirebaseInstance().child("DevPro").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        lvname.add(dataSnapshot.getValue().toString());
//                        Log.e("onChildAdded", dataSnapshot.getValue().toString());
//                        adapter.add(dataSnapshot.getValue().toString());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        Toast.makeText(Firebase_Activity.this,"Your firebase data has been changed: " + dataSnapshot.getValue().toString() + " s: " + s + "datasnapshot.getkey(): " + dataSnapshot.getKey(),Toast.LENGTH_SHORT).show();
                        if(s == null){
                            Toast.makeText(Firebase_Activity.this,"Your key is null", Toast.LENGTH_SHORT).show();
                        }else if(s.equals("1")){
                            Toast.makeText(Firebase_Activity.this,"Your key is key 1", Toast.LENGTH_SHORT).show();
                        }
                        if(s.equals("0")){
                            Toast.makeText(Firebase_Activity.this,"  Your key is:  " + s, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }
        });
    }
}
