package com.example.subject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> planeObservable = getPlaneObservable()
                .subscribeOn(Schedulers.io())
                .map(new Function<Plane, String>() {
                    @Override
                    public String apply(Plane plane) throws Exception {
                        System.out.println("Mapping");
                        return plane.toString();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());



       disposable.add(planeObservable.subscribe(s -> System.out.println("Subscriber 1 " + s)));
       disposable.add(planeObservable.subscribe(s -> System.out.println("Subscriber 2 " + s)));
       disposable.add(planeObservable.subscribe(s -> System.out.println("Subscriber 3 " + s)));


    }

    Observable<Plane> getPlaneObservable(){
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane("Airbus", 700));
        planes.add(new Plane("Mriya", 10000));
        planes.add(new Plane("An 140", 1000));

        return  Observable.fromIterable(planes);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}