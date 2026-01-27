package cn.sweetberry.mcmod.vitalsignals

import cn.sweetberry.mcmod.vitalsignals.events.damage.DamageEvent
import cn.sweetberry.mcmod.vitalsignals.network.TestMessageS2CPayload
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import org.slf4j.LoggerFactory


object VitalSignals : ModInitializer {
    const val MOD_ID = "vital-signals"
    private val logger = LoggerFactory.getLogger("vital-signals")

    override fun onInitialize() {
        val payloadTypeRegistry = PayloadTypeRegistry.playS2C()
        payloadTypeRegistry.register(
            TestMessageS2CPayload.ID,
            TestMessageS2CPayload.CODEC
        )

        DamageEvent.register(TDamageLogger::logDamage)
//        DamageEvent.register { run {
//            ServerPlayNetworking.send(
//                it.target!!,
//                TestMessageS2CPayload("You took ${it.finalDamage} damage from ${it.source?.name ?: "an unknown source"}"),
//            )
//        } }
        logger.info("Vital Signals mod initialized.")
    }
}