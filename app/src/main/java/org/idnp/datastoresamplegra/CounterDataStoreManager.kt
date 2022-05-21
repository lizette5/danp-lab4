package org.idnp.datastoresamplegra

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CounterDataStoreManager(private val context: Context) {
    suspend fun incrementCounter() {
        context.counterDataStore.edit { preferences ->
            // Read the current value from preferences
            val currentCounterValue = preferences[COUNTER_KEY] ?: 0
            // Write the current value + 1 into the preferences
            preferences[COUNTER_KEY] = currentCounterValue + 1
        }
    }

    suspend fun decrementCounter() {
        context.counterDataStore.edit { preferences ->
            // Read the current value from preferences
            val currentCounterValue = preferences[COUNTER_KEY] ?: 0
            // Write the current value - 1 into the preferences
            preferences[COUNTER_KEY] = currentCounterValue - 1
        }
    }
    suspend fun setTheme(id: Int) {
        context.counterDataStore.edit { settings ->
            settings[themeValue] = id
        }
    }
    suspend fun setCounter(counterValue: Int) {
        context.counterDataStore.edit { preferences ->
            preferences[COUNTER_KEY] = counterValue
        }
    }
    suspend fun setDatos(valor1: String,valor2: String,valor3: String,valor4: String,valor5: String,valor6: String) {
        context.counterDataStore.edit { preferences ->
            preferences[KEY_VALOR1] = valor1
            preferences[KEY_VALOR2] = valor2
            preferences[KEY_VALOR3] = valor3
            preferences[KEY_VALOR4] = valor4
            preferences[KEY_VALOR5] = valor5
            preferences[KEY_VALOR6] = valor6
        }
    }

    // A getter for the counter value flow
    val counter: Flow<Int>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[COUNTER_KEY] ?: 0
        }

    val currentTheme = context.counterDataStore.data.map { preferences ->
        preferences[themeValue]
    }
    val dato1: Flow<String>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[KEY_VALOR1] ?: ""
        }
    val dato2: Flow<String>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[KEY_VALOR2] ?: ""

        }
    val dato3: Flow<String>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[KEY_VALOR3] ?: ""


        }
    val dato4: Flow<String>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[KEY_VALOR4] ?: ""


        }
    val dato5: Flow<String>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[KEY_VALOR5] ?: ""


        }
    val dato6: Flow<String>
        get() = context.counterDataStore.data.map { preferences ->
            preferences[KEY_VALOR6] ?: ""


        }

    companion object {
        private const val DATASTORE_NAME = "counter_preferences"

        private val COUNTER_KEY = intPreferencesKey("counter_key");
        private val KEY_VALOR1 = stringPreferencesKey("key_valor1")
        private val KEY_VALOR2 = stringPreferencesKey("key_valor2")
        private val KEY_VALOR3 = stringPreferencesKey("key_valor3")
        private val KEY_VALOR4 = stringPreferencesKey("key_valor4")
        private val KEY_VALOR5 = stringPreferencesKey("key_valor5")
        private val KEY_VALOR6 = stringPreferencesKey("key_valor6")
        private val themeValue = intPreferencesKey("theme")


        private val Context.counterDataStore by preferencesDataStore(
            name = DATASTORE_NAME
        )
    }
}
