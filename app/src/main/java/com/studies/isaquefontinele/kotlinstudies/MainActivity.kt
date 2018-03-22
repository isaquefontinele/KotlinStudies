package com.studies.isaquefontinele.kotlinstudies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private var big: Boolean = true
    private lateinit var subscription: Subscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val observable = Observable
                .just(1, 2, 3, 4, 5)
                .filter { integer ->
                    //check if the number is odd? If the number is odd return true, to emmit that object.
                    integer!! % 2 != 0
                }


        val observer = object : Observer<Int> {
            override fun onCompleted() {
                println("All data emitted.")
            }

            override fun onError(e: Throwable) {
                println("Error received: " + e.message)
            }

            override fun onNext(integer: Int?) {
                println("New data received: " + integer!!)
            }
        }

        val onNextAction = Action1<Int> { s ->
            //This is eqivelent to onNext()
            println(s)
        }

        subscription = observable
                .subscribeOn(Schedulers.io())               //observable will run on IO thread.
                .observeOn(AndroidSchedulers.mainThread())  //Observer will run on main thread.
                .subscribe(observer)                        //subscribe the observer

        var user: User = User()

    }


    override fun onDestroy() {
        super.onDestroy()
        subscription.unsubscribe()
    }
    fun changeMario(view: View) {
//        if (big) image_mario.setImageResource(R.drawable.marioSmall) else image_mario.setImageResource(R.drawable.marioBig)

        big = if (big) {
            image_mario.setImageResource(R.drawable.mario_small)
            false
        } else {
            image_mario.setImageResource(R.drawable.mario_big)
            true
        }

    }
}
