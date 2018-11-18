package com.tanveershafeeprottoy.basedatabindingcomponents.viewmodels

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry

open class BaseObservableViewModel : BaseViewModel(), Observable {
    private val propertyChangeRegistry: PropertyChangeRegistry = PropertyChangeRegistry()

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        propertyChangeRegistry.remove(callback)
    }

    /**
     * Notifies observers that all properties of this instance have changed.
     */
    fun notifyChange() {
        propertyChangeRegistry.notifyCallbacks(this, 0, null)
    }

    /**
     * Notifies observers that a specific property has changed. The getter for the
     * property that changes should be marked with the @Bindable annotation to
     * generate a field in the BR class to be used as the fieldId parameter.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    fun notifyPropertyChanged(fieldId: Int) {
        propertyChangeRegistry.notifyCallbacks(this, fieldId, null)
    }
}