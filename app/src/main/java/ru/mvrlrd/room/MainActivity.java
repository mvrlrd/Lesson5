package ru.mvrlrd.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RoomPresenter roomPresenter;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        roomPresenter = new RoomPresenter();

    }

    public void putData1(View view){
        roomPresenter.putData();
    }
    public void getData1(View view){
        roomPresenter.getData();
    }
    public void deleteData1(View view){
        roomPresenter.deleteData();
    }

    public void putListData1(View view){
        roomPresenter.putListData();
    }
    public void updateData(View view){
        roomPresenter.updateData();
    }

}
