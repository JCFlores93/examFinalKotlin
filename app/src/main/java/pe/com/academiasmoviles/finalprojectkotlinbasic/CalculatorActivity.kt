package pe.com.academiasmoviles.finalprojectkotlinbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick


class CalculatorActivity : AppCompatActivity() {

    var lstOfDigits = ArrayList<String>()
    var lstOfDigitsF = ArrayList<String>()
    var resultLstOfDigits = ArrayList<String>()
    var operation :String =""
    var stringToShow :String = ""
    lateinit var lstToOperateToReturn: ArrayList<String>
    var tamañoActualDelArray = 0
    var posicionActual: Int = 0
    var resultado: Double = 0.toDouble()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        verticalLayout {
            var edt =editText {
                gravity = R.string.gravity
                textDirection = R.string.textDirection



            }
            linearLayout{
              button("+"){
                onClick {

                    lstOfDigits.add("+")
                    for (p : String in lstOfDigits){
                        stringToShow += p
                    }

                    edt.setText(stringToShow)
                    stringToShow =""
                }
              }
              button("7"){
                  onClick {
                      lstOfDigits.add("7")
                      for (p : String in lstOfDigits){
                          stringToShow += p
                      }
                      edt.setText(stringToShow)
                      stringToShow =""
                  }
                }
              button("8"){
                  onClick {

                      lstOfDigits.add("8")
                      for (p : String in lstOfDigits){
                          stringToShow += p
                      }
                      edt.setText(stringToShow)
                      stringToShow =""
                  }
                }
              button("9"){
                  onClick {
                      lstOfDigits.add("9")
                      for (p : String in lstOfDigits){
                          stringToShow += p
                      }
                      edt.setText(stringToShow)
                      stringToShow =""
                  }
                }

              imageButton{
                 imageResource = R.drawable.eraser_icon_25
                  onClick {
                      var lstSize = lstOfDigits.size
                      lstOfDigits.removeAt(lstSize-1)
                      for (p : String in lstOfDigits){
                          stringToShow += p
                      }
                      edt.setText(stringToShow)
                      stringToShow =""
                  }
              }.lparams(width = dip(50) , height  = dip(50))

            }
            linearLayout{
                button("-"){
                    onClick {
                        lstOfDigits.add("-")
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("4"){
                    onClick {
                        lstOfDigits.add("4")
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("5"){
                    onClick {
                        lstOfDigits.add("5")
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("6"){
                    onClick {
                        lstOfDigits.add("6")

                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("C"){
                    onClick {
                        lstOfDigits.clear()
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }

            }

            linearLayout{
                button("*"){
                    onClick {
                        lstOfDigits.add("*")
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("1"){
                    onClick {
                        lstOfDigits.add("1")
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("2"){
                    onClick {
                        lstOfDigits.add("2")

                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("3"){
                    onClick {
                        lstOfDigits.add("3")

                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }

            }

            linearLayout{
                button("/"){
                    onClick {
                        lstOfDigits.add("/")

                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("0"){
                    onClick {
                        lstOfDigits.add("0")
                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("."){
                    onClick {
                        lstOfDigits.add(".")

                        for (p : String in lstOfDigits){
                            stringToShow += p
                        }
                        edt.setText(stringToShow)
                        stringToShow =""
                    }
                }
                button("="){
                    onClick {
                        var totalOfDigits = lstOfDigits.size - 1
                        for (j in 0..totalOfDigits){

                            System.out.println(" el array a evaluar" + lstOfDigits[j])
                        }
                        var amountOfDigits = lstOfDigits.size-1
                         var numberToResolve = ""
                        for(j in 0..amountOfDigits){
                            System.out.println("j  " + j)

                            if (lstOfDigits[j].compareTo("+") != 0
                                    && lstOfDigits[j].compareTo("-") != 0
                                    && lstOfDigits[j].compareTo("*") != 0
                                    && lstOfDigits[j].compareTo("/") != 0 ){
                                numberToResolve += lstOfDigits[j]


                            }else {
                                System.out.println("numero a agregar " + numberToResolve)
                                lstOfDigitsF.add(numberToResolve)
                                System.out.println("signo a agregar " + lstOfDigits[j])
                                lstOfDigitsF.add(lstOfDigits[j])
                                if (j==amountOfDigits){

                                }else {
                                    numberToResolve = ""
                                }
                            }
                        }
                        lstOfDigitsF.add(numberToResolve)
                        var AmountOfDigits = lstOfDigitsF.size-1
                        for (j in 0..AmountOfDigits){

                          System.out.println(" el array final " + lstOfDigitsF[j])
                        }
                        while (lstOfDigitsF.size > 1){
                            resultLstOfDigits = sumar(restar(multiplicar(dividir(lstOfDigitsF))))

                        }
                        edt.setText(resultLstOfDigits[0])

//                        var i:Int
//
//                        lstOfDigits.add("=")
//                        for (p : String in lstOfDigits){
//                            stringToShow += p
//                        }
//                        edt.setText(stringToShow)
//                        stringToShow =""
                    }
                }

            }

        }





    }

    fun showResult(lstOfDigits:ArrayList<String>){
        for ( i :Int in 0..lstOfDigits.size)
        {
           if (lstOfDigits.get(i).compareTo("/") == 0){
                var selected = i
               lstOfDigits.get(i-1).toDouble() / lstOfDigits.get(i+1).toDouble()
               if (lstOfDigits.get(i-2).compareTo("+") == 0){

               }else{

               }

           }
        }
    }


     fun dividir(lstToOperate: ArrayList<String>): ArrayList<String> {
         var total = lstToOperate.size-1
        for ( j in 0..total ) {
            tamañoActualDelArray = lstToOperate.size
            if (lstToOperate[j].compareTo("/") === 0) {
                posicionActual = j
                println(j)
                resultado = lstToOperate[j - 1].toDouble() / lstToOperate[j+ 1].toDouble()
                lstToOperate.set(posicionActual - 1, resultado.toString())
                lstToOperate.removeAt(posicionActual)
                lstToOperate.removeAt(posicionActual)

                    break

            }
        }

        if (tamañoActualDelArray === lstToOperate.size) {
            lstToOperateToReturn = lstToOperate
        } else {
            dividir(lstToOperate)
        }

        return lstToOperateToReturn
    }

     fun multiplicar(lstToOperate: ArrayList<String>): ArrayList<String> {
         var total = lstToOperate.size-1
        for (j in 0..total) {
            tamañoActualDelArray = lstToOperate.size

            if (lstToOperate[j].compareTo("*") === 0) {
                posicionActual = j
                println(j)
                resultado = lstToOperate[j - 1].toDouble() * lstToOperate[j+ 1].toDouble()
                lstToOperate.set(posicionActual - 1, resultado.toString())
                lstToOperate.removeAt(posicionActual)
                lstToOperate.removeAt(posicionActual)

                    break

            }
        }
        if (tamañoActualDelArray === lstToOperate.size) {
            lstToOperateToReturn = lstToOperate
        } else {
            multiplicar(lstToOperate)
        }
        return lstToOperateToReturn    }

     fun restar(lstToOperate: ArrayList<String>): ArrayList<String> {
         var total = lstToOperate.size-1
        for (j in 0..total) {
            tamañoActualDelArray = lstToOperate.size
            if (lstToOperate[j].compareTo("-") === 0) {
                posicionActual = j
                println(j)
                resultado = lstToOperate[j - 1].toDouble() - lstToOperate[j+ 1].toDouble()
                lstToOperate.set(posicionActual - 1, resultado.toString())
                lstToOperate.removeAt(posicionActual)
                lstToOperate.removeAt(posicionActual)

                    break


            }
        }
        if (tamañoActualDelArray === lstToOperate.size) {
            lstToOperateToReturn = lstToOperate
        } else {
            if (lstToOperate.size > 1) {
                restar(lstToOperate)
            }

        }
        return lstToOperateToReturn    }

     fun sumar(lstToOperate: ArrayList<String>): ArrayList<String> {
         var total = lstToOperate.size-1
        for (j in 0..total) {
            tamañoActualDelArray = lstToOperate.size
            if (lstToOperate[j].compareTo("+") === 0) {
                posicionActual = j
                println(j)
                resultado =lstToOperate[j - 1].toDouble() + lstToOperate[j+ 1].toDouble()
                lstToOperate.set(posicionActual - 1, resultado.toString())
                lstToOperate.removeAt(posicionActual)
                lstToOperate.removeAt(posicionActual)

                    break

            }
        }
        if (tamañoActualDelArray === lstToOperate.size) {
            lstToOperateToReturn = lstToOperate
        } else {
            sumar(lstToOperate)
        }
        return lstToOperateToReturn    }

}
