package ru.kpfu.itis.quailly.app.ui.utils.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

typealias Action<T> = (T?) -> Unit

fun <T> LiveData<T>.doAfterNext(onNext: Action<T>): MutableLiveData<T> {
    val mutableLiveData: MediatorLiveData<T> = MediatorLiveData()
    mutableLiveData.addSource(this) {
        mutableLiveData.value = it
        onNext(it)
    }
    return mutableLiveData
}

fun List<LiveData<Boolean>>.isAllTrue(): LiveData<Boolean>  {
    val isAllValid = MediatorLiveData<Boolean>()
    this.forEach {
        isAllValid.addSource(it) {
            isAllValid.value = this.all { it.value ?: false }
        }
    }

    return isAllValid
}

fun <T, O> LiveData<T>.map(function: (T) -> O): LiveData<O> {
    return Transformations.map(this, function)
}

fun <T> LiveData<T>.skip(count:Int): LiveData<T> {
    val mutableLiveData: MediatorLiveData<T> = MediatorLiveData()
    var skippedCount = 0
    mutableLiveData.addSource(this) {
        if(skippedCount>=count) {
            mutableLiveData.value = it
        }
        skippedCount++
    }
    return mutableLiveData
}

fun <T> LiveData<T>.startWith(startingValue: T?): LiveData<T> {
    val finalLiveData = MediatorLiveData<T>()
    var startingData: LiveData<T>? = MutableLiveData(startingValue)
    finalLiveData.addSource(this) {
        if (null != startingData) {
            finalLiveData.removeSource(startingData!!)
            startingData = null
        }
        finalLiveData.value = it
    }
    finalLiveData.addSource(startingData!!) {
        finalLiveData.value = it
        finalLiveData.removeSource(startingData!!)
        startingData = null
    }
    return finalLiveData
}

fun <X, Y, R> zip(first: LiveData<X>, second: LiveData<Y>, zipFunction: (X?, Y?) -> R): MutableLiveData<R> {
    val finalLiveData: MediatorLiveData<R> = MediatorLiveData()

    val firstEmit: Emit<X?> = Emit()
    val secondEmit: Emit<Y?> = Emit()

    val combine: () -> Unit = {
        if (firstEmit.emitted && secondEmit.emitted) {
            val combined = zipFunction(firstEmit.value, secondEmit.value)
            firstEmit.reset()
            secondEmit.reset()
            finalLiveData.value = combined
        }
    }

    finalLiveData.addSource(first) { value ->
        firstEmit.value = value
        combine()
    }
    finalLiveData.addSource(second) { value ->
        secondEmit.value = value
        combine()
    }
    return finalLiveData
}

fun <X, Y, R> combineLatest(first: LiveData<X>, second: LiveData<Y>, combineFunction: (X?, Y?) -> R): MutableLiveData<R> {
    val finalLiveData: MediatorLiveData<R> = MediatorLiveData()

    val firstEmit: Emit<X?> = Emit()
    val secondEmit: Emit<Y?> = Emit()

    val combine: () -> Unit = {
        if (firstEmit.emitted && secondEmit.emitted) {
            val combined = combineFunction(firstEmit.value, secondEmit.value)
            finalLiveData.value = combined
        }
    }

    finalLiveData.addSource(first) { value ->
        firstEmit.value = value
        combine()
    }
    finalLiveData.addSource(second) { value ->
        secondEmit.value = value
        combine()
    }
    return finalLiveData
}

private class Emit<T> {

    internal var emitted: Boolean = false

    internal var value: T? = null
        set(value) {
            field = value
            emitted = true
        }

    fun reset() {
        value = null
        emitted = false
    }
}
