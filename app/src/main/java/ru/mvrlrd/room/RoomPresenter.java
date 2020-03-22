package ru.mvrlrd.room;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomPresenter {

    private static final String TAG = "RoomPresenter";
    private UserDao userDao;

    public RoomPresenter(){
        userDao = App.getAppDataBase().userDao();
    }

    public void putData(){
        User user = new User();
        user.name = "Igor";
        user.surname = "Bel";
        user.age = 12;

        Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(id ->{
            Log.d(TAG,"putData: "+id);
        },throwable -> {
            Log.d(TAG,"putData: "+throwable);
        });
    }
    public void putListData(){
        User user1 = new User();
        user1.name = "Igor";
        user1.surname = "Bel";
        user1.age = 12;

        User user2 = new User();
        user2.name = "Vasya";
        user2.surname = "Bel";
        user2.age = 11;

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Disposable disposable = userDao.insertList(userList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(id ->{
            Log.d(TAG,"putListData: "+id);
        },throwable -> {
            Log.d(TAG,"putListData: "+throwable);
        });
    }
    public void getData(){
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(users ->{
            Log.d(TAG,"getData: "+users+" "+Thread.currentThread().getName());
        }, throwable -> {
            Log.d(TAG,"getData: "+throwable);
        });
    }

    public void updateData(){
        User user2 = new User();
        user2.name = "Masha";
        user2.surname = "Bel";
        user2.age = 3;
        user2.id=1;
        Disposable disposable = userDao.update(user2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(id ->{
            Log.d(TAG,"update: "+id);
        }, throwable -> {
            Log.d(TAG,"update: "+throwable);
        });
    }

    public void deleteData(){
        User user = new User();
        user.id = 3;
        Disposable disposable = userDao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(id ->{
            Log.d(TAG,"deleteData: "+id);
        }, throwable -> {
            Log.d(TAG,"deleteData: "+throwable);
        });
    }
}
