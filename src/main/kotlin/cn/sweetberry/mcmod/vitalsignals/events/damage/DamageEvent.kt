package cn.sweetberry.mcmod.vitalsignals.events.damage

import cn.sweetberry.mcmod.vitalsignals.events.damage.context.DamageContext
import cn.sweetberry.mcmod.vitalsignals.events.damage.context.DamagePhase

object DamageEvent {
    private val listeners = mutableListOf<(DamageContext) -> Unit>()

    fun register(listener: (DamageContext) -> Unit) {
        listeners += listener
    }

    fun post(context: DamageContext) {
        check(context.phase == DamagePhase.ENDED)
        listeners.forEach { it(context) }
    }
}