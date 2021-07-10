package com.example.totalrecallkotlin.mocks

import android.os.Parcel
import android.os.Parcelable

class ParcelableData(var s: String, var i: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(s)
        parcel.writeInt(i)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ParcelableData> {
        override fun createFromParcel(parcel: Parcel): ParcelableData {
            return ParcelableData(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableData?> {
            return arrayOfNulls(size)
        }
    }

}