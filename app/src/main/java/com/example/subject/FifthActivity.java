package com.example.subject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.UnicastSubject;

public class FifthActivity extends AppCompatActivity {
CompositeDisposable disposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

//        AsyncSubject<Plane> asyncSubject = AsyncSubject.create();
//
//        asyncSubject.onNext(new Plane("Airbus", 700));
//        asyncSubject.onNext(new Plane("Fiya", 1000));
//        asyncSubject.onNext(new Plane("Mriya", 1000));
//        asyncSubject.onComplete();
//        disposable.add(asyncSubject.subscribe(plane -> System.out.println("Subscriber 1 " + plane)));
//        disposable.add(asyncSubject.subscribe(plane -> System.out.println("Subscriber 2 " + plane)));

        UnicastSubject<Plane> subject = UnicastSubject.create();
        subject.onNext(new Plane("Mriay" , 1000));
        subject.onNext(new Plane("Briay" , 000));
        disposable.add(subject.subscribe(plane -> System.out.println("Subscriber 1 " + plane)));
        subject.onNext(new Plane("Friay" , 00));
        disposable.add(subject.subscribe(plane -> System.out.println("Subscriber 2 " + plane)));
        subject.onNext(new Plane("Mra", 900));

    }
}