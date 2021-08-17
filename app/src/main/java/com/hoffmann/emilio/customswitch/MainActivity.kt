package com.hoffmann.emilio.customswitch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hoffmann.emilio.custom_switch.CustomSwitch
import com.hoffmann.emilio.customswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainSwitch.setSwitchChangedListener {
            if (it == CustomSwitch.SwitchSelected.FIRST) {
                binding.mainViewFlipper.displayedChild = 0
            } else {
                binding.mainViewFlipper.displayedChild = 1
            }
        }
    }
}
