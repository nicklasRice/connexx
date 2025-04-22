package com.example.connexx.extension

import com.example.connexx.service.BluetoothService
import dagger.hilt.android.AndroidEntryPoint
import io.hammerhead.karooext.KarooSystemService
import io.hammerhead.karooext.extension.KarooExtension
import io.hammerhead.karooext.internal.Emitter
import io.hammerhead.karooext.models.Device
import io.hammerhead.karooext.models.DeviceEvent
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

    // TODO custom Connexx data types
//    override val types by lazy {
//
//    }

    private val karooDevices = ConcurrentHashMap<String, KarooDataSource>()

    override fun startScan(emitter: Emitter<Device>) {
        val job = CoroutineScope(Dispatchers.IO).launch {
            var id = 0
            //TODO determine Bluetooth class of Karoo
            bluetoothService.scan(null).collect { bluetoothDevice ->
                id++
                val karooDataSource = KarooDataSource(EXTENSION_ID, id, bluetoothDevice)
                karooDevices.putIfAbsent(karooDataSource.deviceInfo.uid, karooDataSource)
                emitter.onNext(karooDataSource.deviceInfo)
            }
        }
        emitter.setCancellable {
            job.cancel()
        }
    }

    override fun connectDevice(uid: String, emitter: Emitter<DeviceEvent>) {
        //TODO connect Karoo devices and start sending and receiving data
    }
}