package com.example.connexx.extension

import io.hammerhead.karooext.internal.Emitter
import io.hammerhead.karooext.models.DataType
import io.hammerhead.karooext.models.Device
import io.hammerhead.karooext.models.DeviceEvent

/** A Karoo data source
 *
 * Connect to and stream data from another Karoo device
 * @param extension id of the extension that enables this data source
 * */
class KarooDataSource(extension: String, private val id: Int) :
    DataSource {
    override val source by lazy {
        Device(
            extension,
            "$PREFIX-$id",
            listOf(DataType.Type.HEART_RATE, DataType.Type.POWER),
            "Karoo $id"
        )
    }

    override fun connect(emitter: Emitter<DeviceEvent>) {
        TODO("Not yet implemented")
    }

    companion object {
        const val PREFIX = "karoo"
    }
}