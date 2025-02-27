package com.furkan.kmpmaps

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import cocoapods.Google_Maps_iOS_Utils.GMSCameraPosition
import cocoapods.Google_Maps_iOS_Utils.GMSCameraUpdate
import cocoapods.Google_Maps_iOS_Utils.GMSMapView
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun MapsComponent() {
    val mapView = remember { GMSMapView() }

    val cameraPosition = GMSCameraPosition.cameraWithLatitude(
        1.3588227,
        103.8742114,
        6.0F
    )
    val cameraUpdate = GMSCameraUpdate.setCamera(cameraPosition)
    mapView.moveCamera(cameraUpdate)

    UIKitView(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Blue),
        factory = { mapView }
    )
}
