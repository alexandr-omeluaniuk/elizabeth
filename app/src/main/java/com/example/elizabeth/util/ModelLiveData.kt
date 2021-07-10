package com.example.elizabeth.util

import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData


class ModelLiveData<T : BaseObservable> : MutableLiveData<T>() {
    override fun setValue(value: T?) {
        super.setValue(value)
        //listen to property changes
        value!!.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                //Trigger LiveData observer on change of any property in object
                setValue(getValue())
            }
        })
    }
}