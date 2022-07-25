package com.d.g.africanhairstyles.ui.home

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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.d.g.africanhairstyles.MainActivity
import com.d.g.africanhairstyles.R
import com.d.g.africanhairstyles.SplashActivity

class HomeFragment : Fragment() {

    /*private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}*/



    private lateinit var viewModel: HomeViewModel
    var mWeb: WebView? = null
    var progressBar: ProgressBar? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


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
            mWeb!!.loadUrl("https://www.darlingafrica.com/")
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

    private fun checkInternetConnectionAgain(){
        val connectivityManager = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected){
            startActivity(Intent(activity, (activity)!!::class.java))
            requireActivity().finish()
        } else{
            //showNoInternetDialog()
            val intent = Intent(requireContext(), SplashActivity::class.java)
            startActivity(intent)

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
}