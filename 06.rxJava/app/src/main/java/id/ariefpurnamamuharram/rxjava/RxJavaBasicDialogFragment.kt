package id.ariefpurnamamuharram.rxjava

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_reactive.*

class RxJavaBasicDialogFragment : DialogFragment() {
    private lateinit var mDisposable: Disposable
    private var mResult: String = ""

    companion object {
        fun newInstance(): RxJavaBasicDialogFragment {
            return RxJavaBasicDialogFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodsObservable = getFoodsObservable()
        val foodsObserver = getFoodsObserver()

        foodsObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(foodsObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_reactive, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        mDisposable.dispose()
    }

    private fun getFoodsObservable(): Observable<String> {
        return Observable.just("Apple", "Bacon", "Cacao", "Dumpling", "Finish")
    }

    private fun getFoodsObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
                Log.i("onComplete", "DONE!!")
                resultTextView.text = mResult
            }

            override fun onSubscribe(d: Disposable) {
                Log.i("onSubscribe", d.toString())
                mDisposable = d
            }

            override fun onNext(t: String) {
                Log.i("onNext", t)
                mResult += "$t, "
            }

            override fun onError(e: Throwable) {
                Log.i("onError", e.toString())
            }

        }
    }
}