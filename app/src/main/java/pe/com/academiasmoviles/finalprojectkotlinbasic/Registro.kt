package pe.com.academiasmoviles.finalprojectkotlinbasic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class Registro : AppCompatActivity() {

    var listDevices = ArrayList<mobileDevice>()
    lateinit var edtModel : EditText
    lateinit var edtBrand : EditText
    lateinit var edtYear : EditText
    lateinit var edtPrice : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if(intent.extras == null){
            System.out.println("no valores para mostrar")
        }else {
            var bundle :Bundle = intent.extras
            listDevices= bundle.getParcelableArrayList("mobileList")

        }
        scrollView {
            verticalLayout {
            linearLayout {
                textView("Ingrese el modelo")
                 edtModel =editText {
                }
            }

            linearLayout {
                textView("Ingrese la marca")
                 edtBrand =editText()
            }
                    //.lparams(width = dip(50) , height  = dip(50))

            linearLayout {
                textView("Ingrese el año")
                 edtYear=editText {

                }
            }

            linearLayout {
                textView("Ingrese el el precio")
                 edtPrice=editText {

                }
            }

            var btnSave = button("Save"){
                onClick {
                    if (edtModel.text.toString().compareTo("") == 0) {
                        toast("Debe ingresar un modelo")
                    }else {
                        if (edtBrand.text.toString().compareTo("") == 0) {
                            toast("Debe ingresar el modelo del dispotivo")
                        }else {
                            if (edtYear.text.toString().compareTo("") == 0){
                                toast("Debe ingresar el año del dispotivo")
                            }else {
                                if (edtPrice.text.toString().compareTo("") == 0){
                                    toast("Debe ingresar un precio")
                                }else {
                                    var mobile = mobileDevice(edtModel.text.toString(),edtBrand.text.toString(),edtYear.text.toString().toInt(),edtPrice.text.toString().toDouble())
                                    if (listDevices.size < 1) {
                                        listDevices.add(mobile)
                                        toast("Se añadió un registro ,actualmente hay "+ listDevices.size + " registros.")
                                    }else{
                                        if(listDevices.size < 2) {
                                            if (mobile.model.compareTo(listDevices[0].model) == 0) {
                                                toast("Modelo repetido.Ingrese otro modelo por favor.")
                                            }else{
                                                listDevices.add(mobile)
                                                toast("Se añadió un registro ,actualmente hay "+ listDevices.size + " registros.")
                                            }

                                        }else{
                                            var sizeOfList = listDevices.size - 1
                                            for (j in 0..sizeOfList) {
                                                if (mobile.model.compareTo(listDevices[j].model) == 0) {
                                                    toast("Ya se añadió este modelo.Ingrese otro modelo por favor.")
                                                }else{
                                                    listDevices.add(mobile)
                                                    toast("Se añadió un registro ,actualmente hay " + listDevices.size + " registros.")
                                                }
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }








                }
            }

            var btnSearchByAttribute = button("Buscar"){
                onClick {
                    val  intent = Intent(baseContext,SearchingActivity::class.java)
                    intent.putExtra("mobileList",listDevices)
                    startActivity(intent)

                    //startActivity<SearchingActivity>("mobileList" to listDevices)
                }
            }
            }
        }

    }

}
