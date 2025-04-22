package com.example.connexx.extension

import io.hammerhead.karooext.internal.Emitter
import io.hammerhead.karooext.models.Device
import io.hammerhead.karooext.models.DeviceEvent

internal sealed interface DataSource {
    val source: Device
    fun connect(emitter: Emitter<DeviceEvent>)
}