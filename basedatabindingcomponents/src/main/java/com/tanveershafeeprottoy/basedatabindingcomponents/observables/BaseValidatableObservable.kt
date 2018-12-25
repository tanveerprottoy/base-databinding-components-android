package com.tanveershafeeprottoy.basedatabindingcomponents.observables

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean

/**
 * Created by Tanveer Shafee Prottoy on 12/25/18.
 */

open class BaseValidatableObservable : BaseObservable() {
    var isValidInput: ObservableBoolean = ObservableBoolean(false)
}