package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et_address,et_name,et_phone;
Button bt_add,bt_delete,bt_reset,bt_update;
MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.et_name);
        et_phone=findViewById(R.id.et_phone);
        et_address=findViewById(R.id.et_address);
        bt_add=findViewById(R.id.bt_add);
        bt_delete=findViewById(R.id.bt_delete);
        bt_reset=findViewById(R.id.bt_reset);
        bt_update=findViewById(R.id.bt_update);
        myDatabase=new MyDatabase(this);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et_name.getText().toString();
                String phone=et_phone.getText().toString();
                String address=et_address.getText().toString();
                if (name.length() ==0 ||phone.length()==0||address.length()==0) toastMess();
                else {
                    Student student=new Student(name,phone,address);
                    myDatabase.insert(student);
                    toastMessForData(student);
                }
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et_name.getText().toString();
                if (name.length() ==0 ) toastMess();
                else {
                    Student student=new Student(name);
                    myDatabase.delete(student);
                    Toast.makeText(getApplicationContext(),"Data "+student.getName()
                            +"Deleted",Toast.LENGTH_LONG);

                }
            }
        });
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et_name.getText().toString();
                String phone=et_phone.getText().toString();
                String address=et_address.getText().toString();
                if (name.length() ==0 ||phone.length()==0||address.length()==0) toastMess();
                else {
                    Student student=new Student(name,phone,address);
                    myDatabase.update(student);
                    Toast.makeText(getApplicationContext(),"All Data "+student.getName()
                            +"updated",Toast.LENGTH_LONG);                }
            }
        });
        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               long num=myDatabase.gatStudentCount();
                Toast.makeText(getApplicationContext(),"Number of Data is"+num,Toast.LENGTH_LONG);
            }
        });

    }

    void toastMess(){
        Toast.makeText(getApplicationContext(),"Please Enter All Data",Toast.LENGTH_LONG);
    }
    void toastMessForData(Student student){
        Toast.makeText(getApplicationContext(),"Id for this student" +
               student.getId()+ "You Added "+student.getName()+" "
                +student.getPhone() +" "+ student.getAddress(),Toast.LENGTH_LONG);
    }
}
