package com.ankushgrover.tictactoe.ui.score


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ankushgrover.tictactoe.R
import com.ankushgrover.tictactoe.ui.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_score.*


/**
 * Fragment to display score of O's and X's
 *
 */
class ScoreFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
        }

        initObservers()

    }

    private fun initObservers() {
        mainViewModel.XScoreData.observe(this, Observer {
            tvXScore.text = it.toString()
        })

        mainViewModel.OScoreData.observe(this, Observer {
            tvOScore.text = it.toString()
        })
    }

}
