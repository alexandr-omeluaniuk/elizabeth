package com.example.elizabeth.util

import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData


class POJOLiveData<T : BaseObservable> : MutableLiveData<T>() {
    override fun setValue(value: T?) {
        super.setValue(value)

        //listen to property changes
        value!!.addOnPropertyChangedCallback(callback)
    }

    var callback: Observable.OnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
        override  fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            System.out.println("V: " + value);
            //Trigger LiveData observer on change of any property in object
            value = value
        }
    }
}