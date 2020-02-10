package fr.isen.dylanmetans.androidtoolbox

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_demo.*


class FragmentDemo : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater,
                                 container: ViewGroup?,
                                 savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment_demo, container, false)
    }

// Fragment listener
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {

            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
        Log.i("Frag1 life cycle:", "onAttach called")
    }

// FRAGMENT LIFECYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Frag1 life cycle:", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Frag1 life cycle:", "onActivityCreated called")
    }
    override fun onStart() {
        buttonFragments.setOnClickListener {
            listener?.swipeFragment()
        }
        super.onStart()
        Log.i("Frag1 life cycle:", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        textViewLifeCycleFrag.text = ("@string/onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Frag1 life cycle:", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("Frag1 life cycle:", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(
            this.context,
            "FRAGMENT DESTROYED",
            Toast.LENGTH_LONG
        ).show()
    }
    override fun onDetach() {
        super.onDetach()
        listener = null

        Log.i("Frag1 life cycle:", "onDetach called")
    }
}