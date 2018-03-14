package com.example.miguel.animationfinalapp

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext
import android.view.View


class Main2Activity : AppCompatActivity() {


    private val uiContext: CoroutineContext = UI

    internal var cadena = "¿Estas seguro de que quieres dejar de obtener los portales?" //cadena de salida

    val INTERVALO = 2000 //2 segundos para salir
    var tiempoPrimerClick: Long = 0

    var a: Int = 1
    var b: Int = 1

    //Metodos para la generar RANDOM para las animaciones
    fun numMovX(minimo: Int = 200, maximo: Int = 400): Float {
        //movimiento en X
        return Math.floor(Math.random() * (maximo - minimo + 1) + minimo).toFloat()
    } //movimiento desplazamiento X
    fun numMovY(minimo: Int = 200, maximo: Int = 400): Float {
        //movimiento en Y
        return Math.floor(Math.random() * (maximo - minimo + 1) + minimo).toFloat()
    } //movimiento desplazamiento Y
    fun tiempoMovX(minimo: Int = 3000, maximo: Int = 8000): Long {
        //tiempo movimiento en X
        return Math.floor(Math.random() * (maximo - minimo + 1) + minimo).toLong()
    } //tiempo desplazamiento X
    fun tiempoMovY(minimo: Int = 4000, maximo: Int = 9000): Long {
        //tiempo movimiento en Y
        return Math.floor(Math.random() * (maximo - minimo + 1) + minimo).toLong()
    } //tiempo desplazamiento y

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tarea_animacion1() //lamada al metodo para el primer portal
        tarea_animacion2() //lamada al metodo para el segundo portal
        tarea_animacion3() //lamada al metodo para el tercer portal
        tarea_animacion4() //lamada al metodo para el cuarto portal
        tarea_animacion5() //lamada al metodo para el quinto portal
        tarea_animacion6() //lamada al metodo para el sexto portal
        capturado() //lamada para al cliquear en uno de los portales, llame al metodo de
                    // "comprobarPartida" si es correcto y realice la llamada a los FRAGMENT

    }

        fun tarea_animacion1() = launch(uiContext) {

            //movimiento para el primer portal usando los valores de los RANDOM
            val movX = ObjectAnimator.ofFloat(portal, "translationX", numMovX() * a)

            movX.duration = tiempoMovX()
            movX.interpolator
            movX.start()

            val movY = ObjectAnimator.ofFloat(portal, "translationY", numMovY() * b)
            movY.duration = tiempoMovY()
            movY.interpolator
            movY.start()

            //repeticion infinita de la animacion
            //movX.setRepeatCount(ObjectAnimator.INFINITE)
            //movY.setRepeatCount(ObjectAnimator.INFINITE)


        }

        fun tarea_animacion2() = launch(uiContext) {

            //movimiento para el segundo portal usando los valores de los RANDOM
            val movX = ObjectAnimator.ofFloat(portal2, "translationX", numMovX() * a)
            movX.duration = tiempoMovX()
            movX.interpolator
            movX.start()

            val movY = ObjectAnimator.ofFloat(portal2, "translationY", numMovY() * b)
            movY.duration = tiempoMovY()
            movY.interpolator
            movY.start()
            }

        fun tarea_animacion3() = launch(uiContext) {

        //movimiento para el tercer portal usando los valores de los RANDOM
        val movX = ObjectAnimator.ofFloat(portal3, "translationX", numMovX() * a)
        movX.duration = tiempoMovX()
        movX.interpolator
        movX.start()

        val movY = ObjectAnimator.ofFloat(portal3, "translationY", numMovY() * b)
        movY.duration = tiempoMovY()
        movY.interpolator
        movY.start()
        }

        fun tarea_animacion4() = launch(uiContext) {

        //movimiento para el cuarto portal usando los valores de los RANDOM
        val movX = ObjectAnimator.ofFloat(portal4, "translationX", numMovX() * a)
        movX.duration = tiempoMovX()
        movX.interpolator
        movX.start()

        val movY = ObjectAnimator.ofFloat(portal4, "translationY", numMovY() * b)
        movY.duration = tiempoMovY()
        movY.interpolator
        movY.start()
        }

        fun tarea_animacion5() = launch(uiContext) {

        //movimiento para el quinto portal usando los valores de los RANDOM
        val movX = ObjectAnimator.ofFloat(portal3, "translationX", numMovX() * a)
        movX.duration = tiempoMovX()
        movX.interpolator
        movX.start()

        val movY = ObjectAnimator.ofFloat(portal3, "translationY", numMovY() * b)
        movY.duration = tiempoMovY()
        movY.interpolator
        movY.start()
        }

        fun tarea_animacion6() = launch(uiContext) {

        //movimiento para el sexto portal usando los valores de los RANDOM
        val movX = ObjectAnimator.ofFloat(portal3, "translationX", numMovX() * a)
        movX.duration = tiempoMovX()
        movX.interpolator
        movX.start()

        val movY = ObjectAnimator.ofFloat(portal3, "translationY", numMovY() * b)
        movY.duration = tiempoMovY()
        movY.interpolator
        movY.start()
        }
    fun addFragment1(fragment: BlankFragment){
        //agrega el FRAGMENT de GANAR
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .replace(R.id.fPortal, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    fun addFragment2(fragment2: BlankFragment2){
        //agrega el FRAGMENT de PERDER
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .replace(R.id.fPortal, fragment2, fragment2.javaClass.getSimpleName())
                .addToBackStack(fragment2.javaClass.getSimpleName())
                .commit()
    }

    fun comprobarPartida(){

        //metodo comparacion si el portal seleccionado vale para ganar
        //si está oculto el incorrecto o cualquiera del que no sea el correcto
        // perdemos, ya que solo hay un intento


        //si el portal no vale, oculta todos y llama al Fragment de perder
        if (    portal.visibility == View.INVISIBLE
                || portal3.visibility == View.INVISIBLE
                || portal4.visibility == View.INVISIBLE
                || portal5.visibility == View.INVISIBLE
                || portal6.visibility == View.INVISIBLE ) {

            val fragment2 = BlankFragment2()
            val args = Bundle()
            args.putString("2", "Hola Fragment2")
            fragment2.arguments = args
            addFragment2(fragment2)

            portal.visibility = View.INVISIBLE
            portal2.visibility = View.INVISIBLE
            portal3.visibility = View.INVISIBLE
            portal4.visibility = View.INVISIBLE
            portal5.visibility = View.INVISIBLE
            portal6.visibility = View.INVISIBLE
        }

        //si el portal, vale oculta todos y llama al Fragment de ganar
        else {

            val fragment = BlankFragment()
            val args = Bundle()
            args.putString("1", "Hola Fragment")
            fragment.arguments = args
            addFragment1(fragment)

            portal.visibility = View.INVISIBLE
            portal2.visibility = View.INVISIBLE
            portal3.visibility = View.INVISIBLE
            portal4.visibility = View.INVISIBLE
            portal5.visibility = View.INVISIBLE
            portal6.visibility = View.INVISIBLE

        }

    }

   fun capturado(){

       //al hacer click en el portal, lo pondra en invisible y llama al metodo para
       // comparar si es el correcto para ganar, si no, perdemos

        portal.setOnClickListener {
            portal.visibility = View.INVISIBLE
            comprobarPartida()
        }

       portal2.setOnClickListener {
           comprobarPartida()
           portal.visibility = View.INVISIBLE
           portal3.visibility = View.INVISIBLE
           portal4.visibility = View.INVISIBLE
           portal5.visibility = View.INVISIBLE
           portal6.visibility = View.INVISIBLE
       }

       portal3.setOnClickListener {
           portal3.visibility = View.INVISIBLE
           comprobarPartida()
       }

       portal4.setOnClickListener {
           portal4.visibility = View.INVISIBLE
           comprobarPartida()
       }
       portal5.setOnClickListener {
           portal5.visibility = View.INVISIBLE
           comprobarPartida()
       }
       portal6.setOnClickListener {
           portal6.visibility = View.INVISIBLE
           comprobarPartida()
       }



    }

    override fun onBackPressed() {

        //se prepara la alerta creando nueva instancia
        val alertbox = AlertDialog.Builder(this)
        //seleccionamos la cadena a mostrar
        alertbox.setMessage(cadena)

        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            alertbox.setMessage(cadena)
            //elegimos un positivo SI y creamos un Listener
            alertbox.setPositiveButton("Si") { dialogInterface, i ->
                val salida = Intent(Intent.ACTION_MAIN)
                finishAndRemoveTask()
            }

            //elegimos un positivo NO y creamos un Listener
            alertbox.setNegativeButton("No") { dialogInterface, i -> }
        }
        //mostramos el alertbox
        alertbox.show()
    }


}
