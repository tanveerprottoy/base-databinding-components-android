package com.tanveershafeeprottoy.basedatabindingcomponents.interfaces

import androidx.databinding.ObservableBoolean
import com.tanveershafeeprottoy.basedatabindingcomponents.livedata.SingleLiveEvent

interface BaseViewModel {
    val showProgressbar: ObservableBoolean
    val errorThrown: ObservableBoolean
    val throwableSingleLiveEvent: SingleLiveEvent<Throwable?>

    fun throwError(throwable: Throwable?)
}