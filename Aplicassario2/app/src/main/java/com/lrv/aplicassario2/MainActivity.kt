package com.lrv.aplicassario2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    private val dao by lazy { AppDatabase.getDatabase(applicationContext).birthdayDao() }

    private val viewModel: BirthdayViewModel by viewModels {
        BirthdayViewModelFactory(dao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = "list") {
                composable("list") {
                    BirthdayListScreen(
                        viewModel,
                        onAddClick = { navController.navigate("form") },
                        onGroupClick = { navController.navigate("groups") }
                    )
                }
                composable("groups") {
                    BirthdayGroupScreen(viewModel, onBack = { navController.popBackStack() })
                }
                composable("form") {
                    BirthdayFormScreen(viewModel, onSave = { navController.popBackStack() })
                }
            }
        }
    }
}
