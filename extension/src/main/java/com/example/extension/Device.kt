package com.example.extension

import io.hammerhead.karooext.internal.Emitter
import io.hammerhead.karooext.models.Device
import io.hammerhead.karooext.models.DeviceEvent

internal sealed interface Device {
    val source: Device
    fun connect(emitter: Emitter<DeviceEvent>)
}