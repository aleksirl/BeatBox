package com.bignerdranch.android.beatbox



private const val WAV = ".wav"
class Sound (val assetsPath: String){

    val name = assetsPath.split("/").last().removeSuffix(WAV)

}