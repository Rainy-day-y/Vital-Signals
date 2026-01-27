package cn.sweetberry.mcmod.vitalsignals.damage.netdata

import cn.sweetberry.mcmod.vitalsignals.damage.context.DamageContext

data class DamageData (val context: DamageContext) {
    val id = ""
    val damageAmount: Float = context.finalDamage
}