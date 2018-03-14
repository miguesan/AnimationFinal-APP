package com.example.miguel.animationfinalapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    //Cadena de salida
    internal var cadena = "¿Estas seguro de que quieres dejar de obtener los portales?"

    //cadena del botón del mensaje
    internal var instru = "The Rick´s Portal Gun:\n \n" +
            "¡Mierda Morty! Me robarón mi pistola de portales y ahora ese payaso se dedica a crear portales\n " +
            " a dimensiones peligrosas con criaturas mas feas que pegar a un padre.\n" +
            "¡Ve al espacio y camputa el portal correcto Morty!" +
            "Solo tienes un intento, asique decide con cabeza, si fallas moriras\n \n" +
            "Cuando veas uno tocalo y campuralo, si tienes tienes suerte puede que llegues a cenar," +
            "si no ya me busco a otro Morty en otra dimensión\n"

    val INTERVALO = 2000 //2 segundos para salir
    var tiempoPrimerClick: Long = 0

    //para la musica
    private var musicafondo: MediaPlayer? = null
    internal var MAX_VOLUME = 100
    internal var soundVolume = 90
    internal var volume = (1 - Math.log((MAX_VOLUME - soundVolume).toDouble()) / Math.log(MAX_VOLUME.toDouble())).toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.bstart) as Button
        btn.setOnClickListener { v ->
            val intent = Intent(v.context, Main2Activity::class.java)
            musicafondo!!.stop() //para la musica de fondo
            startActivityForResult(intent, 0)
            this.finish()
        }

        //musica de fondo para la app
        musicafondo = MediaPlayer.create(this, R.raw.musica)
        musicafondo!!.isLooping = true
        musicafondo!!.setVolume(volume, volume)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                musicafondo!!.start()
            }
        }, 1000)
    }

    fun instrucciones(view: View) {
        //para salir de la aplicacion con un dialogo de confirmacion

        //se prepara la alerta creando nueva instancia
        val alertbox = AlertDialog.Builder(this)
        //seleccionamos la cadena a mostrar
        alertbox.setMessage(instru)
        //elegimos un positivo Ok y creamos un Listener
        alertbox.setPositiveButton("Ok") { dialogInterface, i ->
            val okey = Intent(Intent.ACTION_MAIN) //Llamando a la activity principal
            closeContextMenu()
        }
        //mostramos el alertbox
        alertbox.show()

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
                val salida = Intent(Intent.ACTION_MAIN) //Llamando a la activity principal
                musicafondo!!.stop() //para la musica de fondo
                finishAndRemoveTask()
            }

            //elegimos un positivo NO y creamos un Listener
            alertbox.setNegativeButton("No") { dialogInterface, i -> }
        }
        //mostramos el alertbox
        alertbox.show()
    }
}