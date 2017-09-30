package pe.com.academiasmoviles.finalprojectkotlinbasic

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by USUARIO on 20/08/2017.
 */
class mobileDevice(model:String ,brand:String , year:Int,price:Double) : Parcelable{
    var model:String
    var brand:String
    var year:Int
    var price:Double

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(model)
        parcel.writeString(brand)
        parcel.writeInt(year)
        parcel.writeDouble(price)
    }
    constructor(parcel: Parcel) : this(
            model = parcel.readString(),
            brand = parcel.readString(),
            year = parcel.readInt(),
            price = parcel.readDouble())


    init {
    this.model = model
    this.brand = brand
    this.year = year
    this.price = price
    }



    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<mobileDevice> {
        override fun createFromParcel(parcel: Parcel): mobileDevice {
            return mobileDevice(parcel)
        }

        override fun newArray(size: Int): Array<mobileDevice?> {
            return arrayOfNulls(size)
        }
    }
}