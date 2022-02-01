package com.github.nitwix.geralttheweatherman.geolocation

import android.content.Context
import android.location.Location


/**
 * LocationService is a simplified interface for getting the location of the device.
 */
interface LocationService {
    /**
     * Returns the current location according to the particular policy.
     * This method works on a best effort basis, meaning that it will do what's in its power to get the location.
     *@param appCtx Application context, allows to access location related APIs.
     */
    suspend fun getLocationAccordingToPolicy(appCtx: Context): Result<Location>
}