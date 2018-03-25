package hiennguyen.me.weatherapp.domain.interactor

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions
import io.reactivex.rxkotlin.subscribeBy


abstract class UseCase<T: Any, Params> {

    protected val mDisposables: CompositeDisposable = CompositeDisposable()

    open fun buildUseCaseSingle(params: Params? = null): Single<T> {
        TODO()
    }

    open fun buildUseCaseObservable(params: Params? = null): Observable<T> {
        TODO()
    }

    open fun singleSubscribeWith(onSuccess: (T) -> Unit, onError: (Throwable) -> Unit, params: Params? = null) {
        val single: Single<T> = buildUseCaseSingle(params)
        mDisposables.add(single.subscribe(onSuccess, onError))
    }

    open fun observableSubscribeWith(onNext: (T) -> Unit, onError: ((Throwable) -> Unit) = {},
                                     onComplete: (() -> Unit) = {}, params: Params? = null) {
        val observable = buildUseCaseObservable(params)
        mDisposables.add(observable.subscribe(onNext, onError, onComplete))
    }

    fun dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose()
        }
    }


}
