package com.example.miguel.animationfinalapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    //Fragment de GANAR, donde agregamos un gif y su texto en el LAYOUT que saldrá al perder
    //que aparecerá en la Main2Activity

    var ganar: String = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_blank, container, false)

    }

    companion object {
        fun newInstance():Main2Activity{
            var a = Main2Activity()
            return a
        }
    }

    override fun onResume() {
        super.onResume()
        ganar = arguments.getString("1","ERROR NO SE CARGO EL FRAGMENT GANAR")
    }


}
