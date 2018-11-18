package com.tanveershafeeprottoy.basedatabindingcomponents.viewmodels

import android.app.Application

abstract class BaseListAndroidViewModel<T>(application: Application) : BaseAndroidViewModel(application) {

    abstract fun getAll()

    abstract fun onNext(obj: T)
}