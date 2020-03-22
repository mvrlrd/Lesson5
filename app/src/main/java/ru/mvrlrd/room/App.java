package ru.mvrlrd.room;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class App extends Application {

    private static  AppDataBase appDataBase;

    @Override
    public void onCreate(){
        super.onCreate();

        appDataBase = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "room_database").build();
    }

    public static AppDataBase getAppDataBase(){
        return appDataBase;
    }

}
