package com.tanveershafeeprottoy.basedatabindingcomponents.viewmodels

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import com.tanveershafeeprottoy.basedatabindingcomponents.livedata.SingleLiveEvent

abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {
    var showProgressbar = ObservableBoolean(false)
    val errorThrown = ObservableBoolean(false)
    val throwableSingleLiveEvent: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun throwError(throwable: Throwable?) {
        showProgressbar.set(false)
        errorThrown.set(true)
        throwableSingleLiveEvent.value = throwable
    }
}