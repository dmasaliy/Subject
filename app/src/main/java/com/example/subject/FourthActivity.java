package com.example.subject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

public class FourthActivity extends AppCompatActivity {
CompositeDisposable disposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        BehaviorSubject<Plane> behaviorSubject = BehaviorSubject.create();

        behaviorSubject.onNext(new Plane("Airbus", 700));
        behaviorSubject.onNext(new Plane("Fiya", 1000));
        disposable.add(behaviorSubject.subscribe(plane -> System.out.println("Subscriber 1 " + plane)));
        behaviorSubject.onNext(new Plane("Mriya", 1000));
        disposable.add(behaviorSubject.subscribe(plane -> System.out.println("Subscriber 2 " + plane)));
      
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}