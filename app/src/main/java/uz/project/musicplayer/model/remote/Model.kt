package uz.project.musicplayer.model.remote

import android.os.Parcel
import android.os.Parcelable

data class Model(
    var id: Int,
    var musicName: String? = null,
    var singer: String? = null,
    var img: Int? = null,
    var music: Int? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(id)
        p0?.writeInt(img!!)
        p0?.writeString(musicName)
        p0?.writeString(singer)
    }

    companion object CREATOR : Parcelable.Creator<Model> {
        override fun createFromParcel(parcel: Parcel): Model {
            return Model(parcel)
        }

        override fun newArray(size: Int): Array<Model?> {
            return arrayOfNulls(size)
        }
    }
}