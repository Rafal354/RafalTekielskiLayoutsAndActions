package com.example.rafaltekielskilayoutsandactions

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.rafaltekielskilayoutsandactions.databinding.ActivityActionsBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActionsBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityActionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = ViewModelProvider(this)[User::class.java]
        user.firstName = MutableLiveData("Alexander")
        user.lastName = MutableLiveData("TheGreat")

        binding.user = user
        binding.lifecycleOwner = this

        setWriteToLogCatButtonListener()
        serShowToastButtonListener()
        setWriteToTextViewButtonListener()
        setUpdateUserFirstNameButtonListener()
        setUpdateUserLastNameButtonListener()
    }

    private fun setUpdateUserLastNameButtonListener() {
        binding.btnUpdateUserLastName.setOnClickListener {
            val updatedLastName = binding.updateUserLastName.text.toString()
            user.lastName = MutableLiveData(updatedLastName)
            binding.user = user
        }
    }

    private fun setUpdateUserFirstNameButtonListener() {
        binding.btnUpdateUserFirstName.setOnClickListener {
            val updatedFirstName = binding.updateUserFirstName.text.toString()
            user.firstName = MutableLiveData(updatedFirstName)
            binding.user = user
        }
    }

    private fun setWriteToTextViewButtonListener() {
        binding.btnWriteToTextview.setOnClickListener {
            binding.tvWriteSomething.text = getString(R.string.i_love_this_game)
        }
    }

    private fun serShowToastButtonListener() {
        binding.btnShowToast.setOnClickListener {
            Toast.makeText(
                this,
                "Message From My App",
                Toast.LENGTH_LONG
            ).show()
        }
    }


    private fun setWriteToLogCatButtonListener() {
        binding.btnWriteToLogcat.setOnClickListener {
            Log.i("MyAppList", "Message From the BindListener")
        }
    }

    fun writeToLogCut(view: View) {
        Log.i("MyApp", "Message from my App")
    }
}