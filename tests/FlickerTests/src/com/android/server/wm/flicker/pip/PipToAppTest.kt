/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.server.wm.flicker.pip

import android.view.Surface
import androidx.test.filters.FlakyTest
import androidx.test.filters.LargeTest
import com.android.server.wm.flicker.dsl.flicker
import com.android.server.wm.flicker.focusChanges
import com.android.server.wm.flicker.helpers.closePipWindow
import com.android.server.wm.flicker.helpers.expandPipWindow
import com.android.server.wm.flicker.helpers.hasPipWindow
import com.android.server.wm.flicker.helpers.wakeUpAndGoToHomeScreen
import com.android.server.wm.flicker.navBarLayerIsAlwaysVisible
import com.android.server.wm.flicker.navBarLayerRotatesAndScales
import com.android.server.wm.flicker.navBarWindowIsAlwaysVisible
import com.android.server.wm.flicker.noUncoveredRegions
import com.android.server.wm.flicker.statusBarLayerIsAlwaysVisible
import com.android.server.wm.flicker.statusBarLayerRotatesScales
import com.android.server.wm.flicker.statusBarWindowIsAlwaysVisible
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.junit.runners.Parameterized

/**
 * Test Pip launch.
 * To run this test: `atest FlickerTests:PipToAppTest`
 */
@LargeTest
@RunWith(Parameterized::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@FlakyTest(bugId = 152738416)
class PipToAppTest(
    rotationName: String,
    rotation: Int
) : PipTestBase(rotationName, rotation) {
    @Test
    fun test() {
        flicker(instrumentation) {
            withTag { buildTestTag("exitPipModeToApp", testApp, rotation) }
            repeat { 1 }
            setup {
                test {
                    device.wakeUpAndGoToHomeScreen()
                    device.pressHome()
                    testApp.open()
                }
                eachRun {
                    this.setRotation(rotation)
                    testApp.clickEnterPipButton(device)
                    device.hasPipWindow()
                }
            }
            teardown {
                eachRun {
                    this.setRotation(Surface.ROTATION_0)
                }
                test {
                    if (device.hasPipWindow()) {
                        device.closePipWindow()
                    }
                    testApp.exit()
                }
            }
            transitions {
                device.expandPipWindow()
                device.waitForIdle()
            }
            assertions {
                windowManagerTrace {
                    navBarWindowIsAlwaysVisible()
                    statusBarWindowIsAlwaysVisible()

                    all("appReplacesPipWindow") {
                        this.showsAppWindow(sPipWindowTitle)
                                .then()
                                .showsAppWindowOnTop(testApp.launcherName)
                    }
                }

                layersTrace {
                    navBarLayerIsAlwaysVisible()
                    statusBarLayerIsAlwaysVisible()
                    noUncoveredRegions(rotation)
                    navBarLayerRotatesAndScales(rotation)
                    statusBarLayerRotatesScales(rotation)

                    all("appReplacesPipLayer") {
                        this.showsLayer(sPipWindowTitle)
                                .then()
                                .showsLayer(testApp.launcherName)
                    }
                }

                eventLog {
                    focusChanges(
                            "NexusLauncherActivity", testApp.launcherName, "NexusLauncherActivity",
                            bugId = 151179149)
                }
            }
        }
    }
}
