package com.github.nitwix.geralttheweatherman.geolocation

import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationManager

/**
 * Low power location service, that uses coarse location, and first attempts to get the last known
 * location.
 */
class LowPowerLocationService : LocationService {
    override suspend fun getLocationAccordingToPolicy(appCtx: Context): Result<Location> {
        val locationMgr: LocationManager =
            appCtx.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        // our only real criteria is that we don't want the app to drain too much power, because
        // we only intend it to be use for amusement purposes (and not as a precise weather app)
        criteria.powerRequirement = Criteria.POWER_LOW
        val provider = locationMgr.getBestProvider(criteria, true)
            ?: return Result.failure(Exception("Failed to get location provider!"))
        // TODO check runtime permission
        val location = locationMgr.getLastKnownLocation(provider)
    }
}