package com.bignerdranch.android.beatbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(private val beatBox: BeatBox): BaseObservable() {
    fun onButtonClicked(){
        sound?.let {
            beatBox.play(it)
        }
    }

    var sound: Sound? = null
    set(sound) {
        field = sound
        notifyChange()
    }

    @get:Bindable
    val title: String?
    get() = sound?.name

    @set:Bindable
    var rate: Int? = 0
        set(value) {
            field = value
            value?.let {
                BeatBox.soundRate = it/100f
            }

        }
    @Bindable
    var seekBarValue: Int = 50
        set(value) {
            field = value
            rate = value+50
            notifyPropertyChanged(BR.viewModel)
        }
}