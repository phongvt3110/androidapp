package vn.eas.app1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    EditText eduser,edpassword;
    Button btdangky,btdangnhap,btthoat,btnAutologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        ButtonControl();
    }

    private void ButtonControl() {
        btthoat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát không?");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        btdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edt_tk = (EditText)dialog.findViewById(R.id.edtext_user);
                final EditText ed_pass = (EditText)dialog.findViewById(R.id.edtext_password);
                Button button_nhuy = (Button)dialog.findViewById(R.id.btn_huy);
                Button button_dk = (Button)dialog.findViewById(R.id.btn_dangky);
                button_dk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eduser.setText(edt_tk.getText().toString().trim());
                        edpassword.setText(ed_pass.getText().toString().trim());
                        dialog.hide();
                    }
                });
                button_nhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eduser.getText().length() != 0 && edpassword.getText().length() != 0){
                    if(eduser.getText().toString().equals(" ") && edpassword.getText().toString().equals(" ")){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_LONG).show();
                        startApp();
                    } else {
                        Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Bạn chưa đăng nhập",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnAutologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startApp();
            }
        });
    }
    private void startApp(){
        Intent intent = new Intent(MainActivity.this,DangnhapActivity.class);
        startActivity(intent);
    }
    private void map(){
        eduser = (EditText)findViewById(R.id.edittextuser);
        edpassword = (EditText)findViewById(R.id.edittexpassword);
        btdangky = (Button)findViewById(R.id.buttondangky);
        btdangnhap = (Button)findViewById(R.id.buttondangnhap);
        btthoat = (Button)findViewById(R.id.buttonthoat);
        btnAutologin = (Button)findViewById(R.id.button_autologin);
    }
}
