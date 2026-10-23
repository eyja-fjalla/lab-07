package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driverName by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("driversBackButton")
        ) {
            Text("Back")
        }

        Text("FormulaZero Drivers", fontSize = 30.sp)

        TextField(
            value = driverName,
            onValueChange = { driverName = it },
            label = { Text("Driver Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().testTag("driverInput")
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers.add(driverName.trim())
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add Driver")
            }

            Button(
                onClick = { drivers.clear() },
                modifier = Modifier.testTag("clearDriversButton")
            ) {
                Text("Clear All")
            }
        }

        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth().testTag("driversList"),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(drivers) { driver ->
                Text(
                    text = driver,
                    fontSize = 24.sp,
                    modifier = Modifier.testTag("driverItem")
                )
            }
        }
    }
}
