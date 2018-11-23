package com.tanveershafeeprottoy.basedatabindingcomponents.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.tanveershafeeprottoy.basedatabindingcomponents.interfaces.BaseViewModel
import com.tanveershafeeprottoy.basedatabindingcomponents.livedata.SingleLiveEvent

abstract class BaseViewModel : ViewModel(), BaseViewModel {
    override val showProgressbar = ObservableBoolean(false)
    override val errorThrown = ObservableBoolean(false)
    override val throwableSingleLiveEvent: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    override fun throwError(throwable: Throwable?) {
        showProgressbar.set(false)
        errorThrown.set(true)
        throwableSingleLiveEvent.value = throwable
    }
}