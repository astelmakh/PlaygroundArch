package com.playground.corenavigationimpl

import android.content.Context
import com.playground.corenavigation.GlobalFeature
import com.playground.corenavigation.GlobalNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class GlobalNavigatorImpl @Inject constructor(private val context: Context) : GlobalNavigator {

    override fun applyCommands(commands: Array<out Command>?) {
        commands?.forEach { applyCommand(it) }
    }

    private fun applyCommand(command: Command) {
        (command as? Forward)?.let { processForwardCommand(it) }
            ?: throw RuntimeException("Unexpected command passed to Global navigator: $command")
    }

    private fun processForwardCommand(forwardCommand: Forward) {
        when (forwardCommand.screen) {
            is GlobalFeature.ShowCase -> {
            }
            is GlobalFeature.Purchase -> {
                FeatureInitializer.getPurchaseFeature().purchaseStarter().start(context)
            }
            is GlobalFeature.Account -> {
            }
            else -> throw RuntimeException("Command with unsupported feature passed to Global navigator: $forwardCommand")
        }
    }
}
