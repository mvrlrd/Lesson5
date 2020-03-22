package ru.mvrlrd.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name, surname;
    public int age;

    @NonNull
    @Override
    public String toString() {
        return "User{"+
                "id="+id+
                ", name="+name+
                ", surname="+surname+
                ", age="+age+
                "}";
    }
}
