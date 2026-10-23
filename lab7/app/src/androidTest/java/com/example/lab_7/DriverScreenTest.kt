package com.example.lab_7

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigateToDrivers_addDrivers_clearDrivers_returnHome() {
        composeTestRule.onNodeWithText("FormulaZero Home").assertIsDisplayed()
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertIsDisplayed()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Lewis Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertIsDisplayed()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Max Verstappen")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Max Verstappen").assertIsDisplayed()
        composeTestRule.onAllNodesWithTag("driverItem").assertCountEquals(2)

        composeTestRule.onNodeWithTag("clearDriversButton").performClick()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertDoesNotExist()
        composeTestRule.onNodeWithText("Max Verstappen").assertDoesNotExist()
        composeTestRule.onAllNodesWithTag("driverItem").assertCountEquals(0)

        composeTestRule.onNodeWithTag("driversBackButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertIsDisplayed()
        composeTestRule.onNodeWithTag("driversButton").assertIsDisplayed()
    }
}
