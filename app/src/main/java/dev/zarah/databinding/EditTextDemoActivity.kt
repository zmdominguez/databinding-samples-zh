package dev.zarah.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityEdittextDemoBinding

class EditTextDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityEdittextDemoBinding>(this, R.layout.activity_edittext_demo)
        binding.viewModel = EditTextDemoViewModel()
        binding.lifecycleOwner = this

        /*
        With data binding, no need to implement the TextWatcher yourself, as the BindingAdapters are
        already implemented. See: https://bit.ly/db-textwatcher

        binding.edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("EditText Demo", "EditText input has changed to $s")
            }
        })
        */
    }


    class EditTextDemoViewModel {
        fun onTextChanged(input: CharSequence?) {
            Log.d("EditText Demo", "EditText input has changed to ${input.toString()}")
        }
    }
}