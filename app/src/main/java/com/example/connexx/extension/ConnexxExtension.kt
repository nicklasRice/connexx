package com.example.connexx.extension

import android.bluetooth.BluetoothDevice
import com.example.connexx.service.BluetoothService
import dagger.hilt.android.AndroidEntryPoint
import io.hammerhead.karooext.KarooSystemService
import io.hammerhead.karooext.extension.KarooExtension
import io.hammerhead.karooext.internal.Emitter
import io.hammerhead.karooext.models.Device
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

@AndroidEntryPoint
class ConnexxExtension : KarooExtension(EXTENSION_ID, VERSION_ID) {
    companion object {
        const val EXTENSION_ID = "connexx"
        const val VERSION_ID = "1"
    }

    @Inject lateinit var bluetoothService: BluetoothService
    @Inject lateinit var karooSystemService: KarooSystemService

    // TODO custom types
//    override val types by lazy {
//
//    }

    private val devices = ConcurrentHashMap<String, BluetoothDevice>()

    override fun startScan(emitter: Emitter<Device>) {
        val job = CoroutineScope(Dispatchers.IO).launch {
            bluetoothService.scan().collect {
//                devices.put()
//                emitter.onNext()
            }
        }
    }
}