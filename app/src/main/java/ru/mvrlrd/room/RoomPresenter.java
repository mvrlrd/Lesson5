package ru.mvrlrd.room;

import android.util.Log;
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

    public void getData(){
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(users ->{
            Log.d(TAG,"getData: "+users+" "+Thread.currentThread().getName());
        }, throwable -> {
            Log.d(TAG,"getData: "+throwable);
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
