package com.tanveershafeeprottoy.basedatabindingcomponents.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.tanveershafeeprottoy.basedatabindingcomponents.livedata.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    var showProgressbar = ObservableBoolean(false)
    val errorThrown = ObservableBoolean(false)
    val throwableSingleLiveEvent: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun throwError(throwable: Throwable?) {
        showProgressbar.set(false)
        errorThrown.set(true)
        throwableSingleLiveEvent.value = throwable
    }
}