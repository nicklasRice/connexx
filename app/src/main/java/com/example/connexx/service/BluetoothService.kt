package com.example.connexx.service

import android.app.Service
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import com.example.connexx.utils.parcelable
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


/**
 * A foreground service for Bluetooth communication between two devices
 */
class BluetoothService @Inject constructor(
    private val bluetoothAdapter: BluetoothAdapter,
    @ApplicationContext private val context: Context
) : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        // not a bound service
        return null
    }

    fun queryPairedDevices() : List<BluetoothDevice> = TODO("check permissions and get paired devices")

    /**
     * Scans for Bluetooth devices
     */
    fun scan() : Flow<BluetoothDevice> = callbackFlow {
        // receives discovered Bluetooth devices
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                when (intent.action) {
                    BluetoothDevice.ACTION_FOUND -> {
                        trySend(intent.parcelable<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)!!)
                    }
                }
            }
        }
        registerReceiver(receiver, IntentFilter(BluetoothDevice.ACTION_FOUND))
        // TODO check permissions and start discovery
        awaitClose {
            unregisterReceiver(receiver)
        }
    }

    fun connect(bluetoothDevice: BluetoothDevice) : Flow<Byte> = TODO("connect to the given device")
}
