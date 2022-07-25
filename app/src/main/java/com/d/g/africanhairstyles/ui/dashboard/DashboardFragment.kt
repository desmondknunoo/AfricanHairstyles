package com.d.g.africanhairstyles.ui.dashboard

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.d.g.africanhairstyles.R
import com.d.g.africanhairstyles.SplashActivity
import com.d.g.africanhairstyles.ui.home.HomeViewModel

class DashboardFragment : Fragment() {

/*
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}*/



    private lateinit var viewModel: DashboardViewModel
    var mWeb: WebView? = null
    var progressBar: ProgressBar? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)


        progressBar = root.findViewById(R.id.pg_ring)
        mWeb = root.findViewById(R.id.main_web_view)
        mWeb!!.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {

                super.onPageFinished(view, url)
                progressBar!!.visibility = View.GONE
            }
        }
        mWeb!!.settings.javaScriptEnabled = true

        var isConnected = checkInternetConnection()
        if (isConnected) {
            mWeb!!.loadUrl("https://afrocks.com/blog/")
            //showNoInternetDialog()
        } else {
            val intent = Intent(requireContext(), SplashActivity::class.java)
            startActivity(intent)
        }


        return root
    }

    private fun checkInternetConnection(): Boolean {
        val connectivityManager = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        return isConnected
    }

    private fun checkInternetConnectionAgain() {
        val connectivityManager =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected) {
            startActivity(Intent(activity, (activity)!!::class.java))
            requireActivity().finish()
        } else {
            //showNoInternetDialog()
            val intent = Intent(requireContext(), SplashActivity::class.java)
            startActivity(intent)

        }
    }
}

/* private fun showNoInternetDialog(){
     val dialog = MaterialDialog.Builder(requireActivity()).title("Ooops! No internet connection")
         .customView(R.layout.activity_offline, true)
         .positiveText("OK")
         .negativeText("RELOAD")
         .onPositive { dialog, _ -> dialog.dismiss() }
         .onNegative { _, _ -> checkInternetConnectionAgain() }.build()

     dialog.show()
     progressBar!!.visibility = View.GONE
 }*/
