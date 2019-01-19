package com.android.mentarey.mytestapplication.utils

import android.support.v7.widget.SearchView
import io.reactivex.subjects.PublishSubject

object RxSearchObservable {

    fun fromView(searchView: SearchView): PublishSubject<String> {

        val subject = PublishSubject.create<String>()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(submit: String): Boolean {
                return true
            }

            override fun onQueryTextChange(text: String): Boolean {
                subject.onNext(text)
                return true
            }
        })

        return subject
    }
}