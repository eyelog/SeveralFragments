package ru.eyelog.severalfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels

class SecondFragment : Fragment() {

    private val viewModel: AwesomeViewModel by viewModels {
        AwesomeViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

        viewModel.titleLiveData.observe(viewLifecycleOwner) {
            tvTitle.text = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}