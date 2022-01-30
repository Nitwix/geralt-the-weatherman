package com.github.nitwix.geralttheweatherman.geolocation

import android.content.Context
import android.location.Location
import kotlin.native.concurrent.Future // <-- THIS DOESN'T WORK

/**
 * LocationService is a simplified interface for getting the location of the device.
 */
interface LocationService {
    /**
     * Returns the last known location. If there is none, attempts to get the current location.
     * This way, most of the time, the access is fast and consumes little power. It may not be
     * accurate, but that is not very important considering this is a joke weather app.
     */
    fun getLastKnownLocation(appCtx: Context): Future<Location?>
}