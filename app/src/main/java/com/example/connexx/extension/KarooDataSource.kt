package com.example.connexx.extension

import android.bluetooth.BluetoothDevice
import io.hammerhead.karooext.models.DataType
import io.hammerhead.karooext.models.Device

/** A Karoo data source
 *
 * @param extension id of the extension that supports this data source
 * @param id a unique identifier for this Karoo data source
 * @property bluetoothDevice the underlying Bluetooth device
 * */
class KarooDataSource(
    extension: String,
    id: Int,
    val bluetoothDevice: BluetoothDevice) {
    companion object {
        const val PREFIX = "karoo"
    }
    val deviceInfo: Device = Device(extension,
        "$PREFIX-$id",
        listOf(DataType.Type.HEART_RATE, DataType.Type.POWER),
        "Karoo $id")
}