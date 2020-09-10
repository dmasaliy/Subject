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

public class SixActivity extends AppCompatActivity {

CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        Observable<Plane2> planeObservable = getPlaneObservable()
                .subscribeOn(Schedulers.io())
                .map(new Function<Plane, Plane2>() {
                    @Override
                    public Plane2 apply(Plane plane) throws Exception {
                        return new Plane2(plane.getBrand(), plane.getMaxSpeed(), 100);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());

        disposable.add(planeObservable.subscribe(s -> System.out.println("Subscriber 1 " + s.toString())));
        disposable.add(planeObservable.subscribe(s -> System.out.println("Subscriber 2 " + s.toString())));
        disposable.add(planeObservable.subscribe(s -> System.out.println("Subscriber 3 " + s.toString())));

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