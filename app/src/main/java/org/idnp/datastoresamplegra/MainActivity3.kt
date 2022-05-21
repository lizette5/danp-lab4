package org.idnp.datastoresamplegra

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity3 : AppCompatActivity() {

    lateinit var text1: AppCompatTextView
    lateinit var text2: AppCompatTextView
    lateinit var text3: AppCompatTextView
    lateinit var text4: AppCompatTextView
    lateinit var text5: AppCompatTextView
    lateinit var text6: AppCompatTextView

    lateinit var textInput1: AppCompatEditText
    lateinit var textInput2: AppCompatEditText
    lateinit var textInput3: AppCompatEditText
    lateinit var textInput4: AppCompatEditText
    lateinit var textInput5: AppCompatEditText
    lateinit var textInput6: AppCompatEditText

    lateinit var botonSave: Button
    lateinit var botonTheme: ImageButton
    lateinit var botonChange: ImageButton
    lateinit var botonChangeMas: ImageButton
    lateinit var botonChangeMen: ImageButton


    lateinit var counterManager: CounterDataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main3)



        text1 =findViewById(R.id.textView2)
        text2 =findViewById(R.id.textView3)
        text3 =findViewById(R.id.textView4)
        text4 =findViewById(R.id.textView5)
        text5 =findViewById(R.id.textView6)
        text6 =findViewById(R.id.textView7)


        textInput1 = findViewById(R.id.editTextTextPersonName)
        textInput2 = findViewById(R.id.editTextTextPersonName2)
        textInput3 = findViewById(R.id.editTextNumber2)
        textInput4 = findViewById(R.id.editTextTextPersonName3)
        textInput5 = findViewById(R.id.editTextTextPersonName4)
        textInput6 = findViewById(R.id.editTextTextPersonName5)

        botonSave = findViewById(R.id.button)
        botonTheme = findViewById(R.id.imageButton2)
        botonChange = findViewById(R.id.imageButton3)
        botonChangeMas = findViewById(R.id.imageButton4)
        botonChangeMen = findViewById(R.id.imageButton5)

        counterManager = CounterDataStoreManager(this)

        // Collect the counter value and set the text everytime the value changes
        lifecycleScope.launch {
            counterManager.dato1.collect { dato ->
                textInput1.setText(dato)
            }
        }
        lifecycleScope.launch {
            counterManager.dato2.collect { dato ->
                textInput2.setText(dato)
            }
        }
        lifecycleScope.launch {
            counterManager.dato3.collect { dato ->
                textInput3.setText(dato)
            }
        }
        lifecycleScope.launch {
            counterManager.dato4.collect { dato ->
                textInput4.setText(dato)
            }
        }
        lifecycleScope.launch {
            counterManager.dato5.collect { dato ->
                textInput5.setText(dato)
            }
        }
        lifecycleScope.launch {
            counterManager.dato6.collect { dato ->
                textInput6.setText(dato)
            }
        }
        lifecycleScope.launch {
            counterManager.currentTheme.collect { dato ->
            }
        }

        // Set the current value of the counter
        botonSave.setOnClickListener {
            lifecycleScope.launch {
                counterManager.setDatos(textInput1.text.toString(),textInput2.text.toString(),textInput3.text.toString(),
                    textInput4.text.toString(),textInput5.text.toString(),textInput6.text.toString())
            }
        }
        botonTheme.setOnClickListener{
            lifecycleScope.launch {
                if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }
        botonChange.setOnClickListener {

            text1.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            text2.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            text3.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            text4.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            text5.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            text6.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            textInput1.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            textInput2.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            textInput3.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            textInput4.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            textInput5.typeface = ResourcesCompat.getFont(this, R.font.nuevo)
            textInput6.typeface = ResourcesCompat.getFont(this, R.font.nuevo)


        }
        botonChangeMas.setOnClickListener {

            text1.setTextSize(1,15f)
            text2.setTextSize(1,15f)
            text3.setTextSize(1,15f)
            text4.setTextSize(1,15f)
            text5.setTextSize(1,15f)
            text6.setTextSize(1,15f)
            textInput1.setTextSize(1,15f)
            textInput2.setTextSize(1,15f)
            textInput3.setTextSize(1,15f)
            textInput4.setTextSize(1,15f)
            textInput5.setTextSize(1,15f)
            textInput6.setTextSize(1,15f)


        }
        botonChangeMen.setOnClickListener {

            text1.setTextSize(1,6f)
            text2.setTextSize(1,6f)
            text3.setTextSize(1,6f)
            text4.setTextSize(1,6f)
            text5.setTextSize(1,6f)
            text6.setTextSize(1,6f)
            textInput1.setTextSize(1,6f)
            textInput2.setTextSize(1,6f)
            textInput3.setTextSize(1,6f)
            textInput4.setTextSize(1,6f)
            textInput5.setTextSize(1,6f)
            textInput6.setTextSize(1,6f)


        }


    }

    enum class AppThemes {
        MODE_AUTO,
        MODE_LIGHT,
        MODE_DARK,
    }

}