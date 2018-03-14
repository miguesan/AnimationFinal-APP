package com.example.miguel.animationfinalapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment2.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    //Fragment de PERDER, donde agregamos un gif y su texto en el LAYOUT que saldrá al perder
    //que aparecerá en la Main2Activity

    var perder: String = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_blank_fragment2, container, false)
    }

    companion object {
        fun newInstance():Main2Activity{
            var b = Main2Activity()
            return b
        }
    }

    override fun onResume() {
        super.onResume()
        perder = arguments.getString("2","ERROR NO SE CARGO EL FRAGMENT PERDER")
    }
}