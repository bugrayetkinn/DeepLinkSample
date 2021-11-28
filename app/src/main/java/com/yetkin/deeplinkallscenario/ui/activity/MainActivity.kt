package com.yetkin.deeplinkallscenario.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yetkin.deeplinkallscenario.R
import com.yetkin.deeplinkallscenario.databinding.ActivityMainBinding
import com.yetkin.deeplinkallscenario.utils.Constants

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var navController: NavController

    /**
     * todo
     * when the app is open
     */
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController.handleDeepLink(intent)
        handleDeepLink()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        handleDeepLink()
    }

    private fun handleDeepLink() {
        val intentData = intent.data

        /**
         * todo
         * takes the parameter value of the link
         */
        val idParameter = intentData?.getQueryParameter(Constants.DEEP_LINK_QUERY_ID)
        Log.e("url id parameter", idParameter ?: "")
        val isOpenedUrl = intentData?.toString() ?: "Not Open Url (Activity)"
        binding.openUrl = isOpenedUrl
    }
}