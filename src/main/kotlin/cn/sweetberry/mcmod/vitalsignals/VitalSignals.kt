package cn.sweetberry.mcmod.vitalsignals

import cn.sweetberry.mcmod.vitalsignals.events.damage.DamageEvent
import cn.sweetberry.mcmod.vitalsignals.network.damage.DamageS2CPayload
import cn.sweetberry.mcmod.vitalsignals.network.damage.DamageSender
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory


object VitalSignals : ModInitializer {
    const val MOD_ID = "vital-signals"
    val logger: Logger = LoggerFactory.getLogger("vital-signals")

    override fun onInitialize() {
        // 注册网络负载类型
        val payloadTypeRegistry = PayloadTypeRegistry.playS2C()
        payloadTypeRegistry.register(
            DamageS2CPayload.PAYLOAD_ID,
            DamageS2CPayload.CODEC
        )
        // 注册伤害事件监听器
        DamageEvent.register (DamageSender::sendContextToClient)

        logger.info("Vital Signals mod initialized.")
    }
}