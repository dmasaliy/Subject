package com.example.subject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class ThirdActivity extends AppCompatActivity {
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        PublishSubject<Plane> planePublishSubject = PublishSubject.create();

        planePublishSubject.onNext(new Plane("Airbus", 700));
        disposable.add(planePublishSubject.subscribe(plane -> System.out.println("Subscriber 1 " + plane)));
        planePublishSubject.onNext(new Plane("Mriya", 1000));
        disposable.add(planePublishSubject.subscribe(plane -> System.out.println("Subscriber 1 " + plane)));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
