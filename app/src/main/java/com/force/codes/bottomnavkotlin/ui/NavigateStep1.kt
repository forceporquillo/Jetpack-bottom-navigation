package com.force.codes.bottomnavkotlin.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.force.codes.bottomnavkotlin.R
import java.util.*

private const val ARGS = "title_param"

class NavigateStep1 : Fragment(), View.OnClickListener {
    private lateinit var viewModel: NavigateToStep1ViewModel
    private var PARAM_TITLE: String? = null

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[NavigateToStep1ViewModel::class.java]
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.fragment_navigate_step1,
            container, false
        )

        viewModel.text.observe(viewLifecycleOwner, Observer { PARAM_TITLE = it })
        Log.e(null, "Title $PARAM_TITLE")
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = PARAM_TITLE

        return view
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.button2)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            Navigation.findNavController(it)
                .navigate(R.id.action_navigateStep1_to_navigateStep2)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String) = NavigateStep1().apply {
            arguments = Bundle().apply {
                putString(ARGS, title)
            }
        }
    }
}