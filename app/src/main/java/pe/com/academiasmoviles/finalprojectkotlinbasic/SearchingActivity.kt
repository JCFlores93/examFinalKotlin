package pe.com.academiasmoviles.finalprojectkotlinbasic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onCheckedChange
import org.jetbrains.anko.sdk25.coroutines.onClick

class SearchingActivity : AppCompatActivity() {
    lateinit var listToShow : ArrayList<mobileDevice>
    lateinit var txtSearchResult :TextView
    lateinit var edtToSearch : EditText
    lateinit var checkBoxModel :CheckBox
    lateinit var checkBoxBrand :CheckBox
    lateinit var checkBoxYear :CheckBox
    lateinit var checkBoxPrice :CheckBox
    lateinit var constantToSearch : String
    lateinit var txtRequest:TextView
    lateinit var btnSearch : Button
    lateinit var btnEdit : Button
    lateinit var txtModel: TextView
    lateinit var edtModel: EditText
    lateinit var txtBrand: TextView
    lateinit var edtBrand: EditText
    lateinit var txtYear: TextView
    lateinit var edtYear: EditText
    lateinit var txtPrice: TextView
    lateinit var edtPrice: EditText
    lateinit var btnSave:Button
    lateinit var btnCancelEdit:Button
    lateinit var btnCloseActivity:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle :Bundle = intent.extras
        if(bundle == null){
            System.out.println("no valores para mostrar")
        }else {
            listToShow= bundle.getParcelableArrayList("mobileList")

        }


        scrollView {
            verticalLayout {
                txtRequest = textView("Buscar por :")
                edtToSearch = editText {
                    hint = "Ingrese una palabra para buscar"
                }
                linearLayout {
                    checkBoxModel = checkBox {
                        text = "Modelo"
                    }

                    checkBoxBrand = checkBox {
                        text = "Marca"
                    }

                    checkBoxYear = checkBox {
                        text = "Year"
                    }

                    checkBoxPrice = checkBox {
                        text = "Price"
                    }
                }

                checkBoxModel.onCheckedChange { buttonView, isChecked ->
                    if (isChecked) {
                        checkBoxBrand.isEnabled = false
                        checkBoxYear.isEnabled = false
                        checkBoxPrice.isEnabled = false
                        constantToSearch = "MODEL"
                        txtRequest.text = "Se buscara el modelo especificado"
                    } else {
                        checkBoxBrand.isEnabled = true
                        checkBoxYear.isEnabled = true
                        checkBoxPrice.isEnabled = true
                    }
                }

                checkBoxBrand.onCheckedChange { buttonView, isChecked ->
                    if (isChecked) {
                        checkBoxModel.isEnabled = false
                        checkBoxYear.isEnabled = false
                        checkBoxPrice.isEnabled = false
                        constantToSearch = "BRAND"
                        txtRequest.text = "Se buscaran todos los modelos con la marca"

                    } else {
                        checkBoxModel.isEnabled = true
                        checkBoxYear.isEnabled = true
                        checkBoxPrice.isEnabled = true
                    }
                }

                checkBoxYear.onCheckedChange { buttonView, isChecked ->
                    if (isChecked) {
                        checkBoxModel.isEnabled = false
                        checkBoxBrand.isEnabled = false
                        checkBoxPrice.isEnabled = false
                        constantToSearch = "YEAR"
                        txtRequest.text = "Se buscaran todos los modelos del ano :"

                    } else {
                        checkBoxModel.isEnabled = true
                        checkBoxBrand.isEnabled = true
                        checkBoxPrice.isEnabled = true
                    }
                }

                checkBoxPrice.onCheckedChange { buttonView, isChecked ->
                    if (isChecked) {
                        checkBoxBrand.isEnabled = false
                        checkBoxYear.isEnabled = false
                        checkBoxModel.isEnabled = false
                        constantToSearch = "PRICE"
                        txtRequest.text = "Se buscaran todos los modelos con el precio :"


                    } else {
                        checkBoxBrand.isEnabled = true
                        checkBoxYear.isEnabled = true
                        checkBoxModel.isEnabled = true
                    }
                }

                btnSearch = button("Search") {
                    onClick {
                        var valueToSearch = edtToSearch.text.toString()
                        if (valueToSearch.compareTo("") == 0) {
                            txtModel.visibility = View.GONE
                            edtModel.visibility = View.GONE
                            txtBrand.visibility = View.GONE
                            edtBrand.visibility = View.GONE
                            txtYear.visibility = View.GONE
                            edtYear.visibility = View.GONE
                            txtPrice.visibility = View.GONE
                            edtPrice.visibility = View.GONE
                            txtSearchResult.visibility = View.VISIBLE
                            toast("El campo a buscar esta vacio")
                            var sizeOfList = listToShow.size - 1
                            for (j in 0..sizeOfList) {
                                append("Dispositivo N°" + (j + 1) + "\n" +
                                        "Modelo :" + listToShow[j].model + "\n" +
                                        "Marca:" + listToShow[j].brand + "\n" +
                                        "Año:" + listToShow[j].year.toString() + "\n" +
                                        "Precio:" + listToShow[j].price.toString() + "\n")
                            }
                        } else {


                            if (constantToSearch.compareTo("MODEL") == 0) {
                                txtSearchResult.text = ""
                                var sizeOfList = listToShow.size - 1
                                for (j in 0..sizeOfList) {
                                    if (valueToSearch.compareTo(listToShow[j].model) == 0) {
                                        txtSearchResult.append("Dispositivo N°" + (j + 1) + "\n" +
                                                "Modelo :" + listToShow[j].model + "\n" +
                                                "Marca:" + listToShow[j].brand + "\n" +
                                                "Año:" + listToShow[j].year.toString() + "\n" +
                                                "Precio:" + listToShow[j].price.toString() + "\n")
                                    }else{
                                        toast("No se encontró el valor")
                                    }


                                }

                            } else {
                                if (constantToSearch.compareTo("BRAND") == 0) {
                                    txtSearchResult.text = ""
                                    var sizeOfList = listToShow.size - 1
                                    for (j in 0..sizeOfList) {
                                        if (valueToSearch.compareTo(listToShow[j].brand) == 0) {
                                            txtSearchResult.append("Dispositivo N°" + (j + 1) + "\n" +
                                                    "Modelo :" + listToShow[j].model + "\n" +
                                                    "Marca:" + listToShow[j].brand + "\n" +
                                                    "Año:" + listToShow[j].year.toString() + "\n" +
                                                    "Precio:" + listToShow[j].price.toString() + "\n")
                                        }else{
                                            toast("No se encontró el valor")
                                        }

                                    }

                                } else {
                                    if (constantToSearch.compareTo("YEAR") == 0) {
                                        txtSearchResult.text = ""
                                        var sizeOfList = listToShow.size - 1
                                        for (j in 0..sizeOfList) {
                                            if (valueToSearch.compareTo(listToShow[j].year.toString()) == 0) {
                                                txtSearchResult.append("Dispositivo N°" + (j + 1) + "\n" +
                                                        "Modelo :" + listToShow[j].model + "\n" +
                                                        "Marca:" + listToShow[j].brand + "\n" +
                                                        "Año:" + listToShow[j].year.toString() + "\n" +
                                                        "Precio:" + listToShow[j].price.toString() + "\n")
                                            }else{
                                                toast("No se encontró el valor")
                                            }

                                        }

                                    } else {
                                        if (constantToSearch.compareTo("PRICE") == 0) {
                                            txtSearchResult.text = ""
                                            var sizeOfList = listToShow.size - 1
                                            for (j in 0..sizeOfList) {
                                                if (valueToSearch.compareTo(listToShow[j].price.toString()) == 0) {
                                                    txtSearchResult.append("Dispositivo N°" + (j + 1) + "\n" +
                                                            "Modelo :" + listToShow[j].model + "\n" +
                                                            "Marca:" + listToShow[j].brand + "\n" +
                                                            "Año:" + listToShow[j].year.toString() + "\n" +
                                                            "Precio:" + listToShow[j].price.toString() + "\n")
                                                }else{
                                                    toast("No se encontró el valor")
                                                }

                                            }

                                        }
                                    }
                                }

                            }
                        }
                    }
                }


                btnEdit = button("Editar") {
                    onClick {
                        txtSearchResult.visibility = View.GONE
                        var valueToSearch = edtToSearch.text.toString()
                        txtModel.visibility = View.VISIBLE
                        edtModel.visibility = View.VISIBLE
                        txtBrand.visibility = View.VISIBLE
                        edtBrand.visibility = View.VISIBLE
                        txtYear.visibility = View.VISIBLE
                        edtYear.visibility = View.VISIBLE
                        txtPrice.visibility = View.VISIBLE
                        edtPrice.visibility = View.VISIBLE
                        btnSave.visibility = View.VISIBLE
                        btnCancelEdit.visibility = View.VISIBLE
                        if (valueToSearch.compareTo("") == 0) {
                            toast("INGRESE EL MODELO A EDITAR")
                        } else {
                            toast("se encontró pero no se guarda 1" + valueToSearch)
                            var sizeOfList = listToShow.size - 1
                            for (j in 0..sizeOfList) {
                                toast("se encontró pero no se guarda 1" + j)
                                if (valueToSearch.compareTo(listToShow[j].model) == 0) {
                                    toast("se encontró pero no se guarda" + valueToSearch)
                                    edtModel?.setText(listToShow[j].model)
                                   // edtModel.text = "" +listToShow[j].model
                                    edtBrand.text = Editable.Factory.getInstance().newEditable(listToShow[j].brand)
                                    edtYear.text = Editable.Factory.getInstance().newEditable(listToShow[j].year.toString())
                                    edtPrice.text = Editable.Factory.getInstance().newEditable(listToShow[j].price.toString())
                                }
                            }
                        }
                    }

                }

                btnCloseActivity = button("Cerrar") {
                    onClick {
                        val intent = Intent(baseContext, Registro::class.java)
                        intent.putExtra("mobileList", listToShow)
                        startActivity(intent)
                        finish()
                    }
                }



                txtModel = textView("Modelo a modificar :") { visibility = View.GONE }
                edtModel = editText {
                    hint = "Ingrese el nuevo modelo"
                    visibility = View.GONE
                }

                txtBrand = textView("Marca a modificar :") { visibility = View.GONE }
                edtBrand = editText {
                    hint = "Ingrese la nueva marca"
                    visibility = View.GONE
                }

                txtPrice = textView("Precio a modificar :") { visibility = View.GONE }
                edtPrice = editText {
                    hint = "Ingrese el nuevo precio"
                    visibility = View.GONE
                }
                txtYear = textView("Año a modificar :") { visibility = View.GONE }
                edtYear = editText {
                    hint = "Ingrese el nuevo año"
                    visibility = View.GONE
                }


                btnSave = button("Guardar") {
                    visibility = View.GONE
                    onClick {
                        var valueToEdit = edtToSearch.text.toString()
                        var model = edtModel.text.toString()
                        var brand = edtBrand.text.toString()
                        var year = edtYear.text.toString()
                        var price = edtPrice.text.toString()
                        var sizeOfList = listToShow.size - 1
                        for (j in 0..sizeOfList) {
                            if (valueToEdit.compareTo(listToShow[j].model) == 0) {
                                var mobile = mobileDevice(model, brand, year.toInt(), price.toDouble())
                                listToShow[j] = mobile

                            }
                        }
                        txtModel.visibility = View.GONE
                        edtModel.visibility = View.GONE
                        txtBrand.visibility = View.GONE
                        edtBrand.visibility = View.GONE
                        txtYear.visibility = View.GONE
                        edtYear.visibility = View.GONE
                        txtPrice.visibility = View.GONE
                        edtPrice.visibility = View.GONE
                        btnSave.visibility = View.GONE
                        btnCancelEdit.visibility = View.GONE
                        txtSearchResult.visibility = View.VISIBLE
                        txtSearchResult.setText("")

                        var sizeOfList1 = listToShow.size - 1
                        for (j in 0..sizeOfList1) {
                            txtSearchResult.append("Dispositivo N°" + (j + 1) + "\n" +
                                    "Modelo :" + listToShow[j].model + "\n" +
                                    "Marca:" + listToShow[j].brand + "\n" +
                                    "Año:" + listToShow[j].year.toString() + "\n" +
                                    "Precio:" + listToShow[j].price.toString() + "\n")
                        }

                    }
                }

                btnCancelEdit = button("Cancelar") {
                    visibility = View.GONE
                    onClick {
                        txtModel.visibility = View.GONE
                        edtModel.visibility = View.GONE
                        txtBrand.visibility = View.GONE
                        edtBrand.visibility = View.GONE
                        txtYear.visibility = View.GONE
                        edtYear.visibility = View.GONE
                        txtPrice.visibility = View.GONE
                        edtPrice.visibility = View.GONE
                        btnSave.visibility = View.GONE
                        btnCancelEdit.visibility = View.GONE
                        txtSearchResult.visibility = View.VISIBLE
                        txtSearchResult.setText("")

                        var sizeOfList = listToShow.size - 1
                        for (j in 0..sizeOfList) {
                            txtSearchResult.append("Dispositivo N°" + (j + 1) + "\n" +
                                    "Modelo :" + listToShow[j].model + "\n" +
                                    "Marca:" + listToShow[j].brand + "\n" +
                                    "Año:" + listToShow[j].year.toString() + "\n" +
                                    "Precio:" + listToShow[j].price.toString() + "\n")
                        }
                    }
                }

                txtSearchResult = textView {
                    var sizeOfList = listToShow.size - 1
                    for (j in 0..sizeOfList) {
                        append("Dispositivo N°" + (j + 1) + "\n" +
                                "Modelo :" + listToShow[j].model + "\n" +
                                "Marca:" + listToShow[j].brand + "\n" +
                                "Año:" + listToShow[j].year.toString() + "\n" +
                                "Precio:" + listToShow[j].price.toString() + "\n")
                    }

                }
            }
        }
    }
}
