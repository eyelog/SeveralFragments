package ru.eyelog.severalfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import ru.eyelog.severalfragments.di.DaggerVMComponent
import javax.inject.Inject

class ThirdFragment : Fragment() {

    @Inject
    lateinit var viewModel: AwesomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).injectFragment(this)


        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val button = view.findViewById<Button>(R.id.tapFragmentButton)

        button.setOnClickListener {
            viewModel.buttonClicked()
        }

        viewModel.titleLiveData.observe(viewLifecycleOwner) {
            tvTitle.text = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThirdFragment()
    }
}