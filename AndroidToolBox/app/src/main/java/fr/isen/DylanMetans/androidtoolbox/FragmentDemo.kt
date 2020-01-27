package fr.isen.dylanmetans.androidtoolbox

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentDemo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                                 container: ViewGroup?,
                                 savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment_demo, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("Frag1 life cycle:", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Frag1 life cycle:", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Frag1 life cycle:", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Frag1 life cycle:", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("Frag1 life cycle:", "onResume called")
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
        Log.i("Frag1 life cycle:", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("Frag1 life cycle:", "onDetach called")
    }
}