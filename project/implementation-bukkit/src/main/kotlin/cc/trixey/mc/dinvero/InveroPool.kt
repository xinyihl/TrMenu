package cc.trixey.mc.dinvero

import cc.trixey.mc.dinvero.InveroManager.poolIndex
import cc.trixey.mc.dinvero.nms.WindowProperty
import cc.trixey.mc.dinvero.type.InvChest
import cc.trixey.mc.dinvero.type.InvHopper
import java.util.concurrent.CopyOnWriteArrayList

/**
 * @author Arasple
 * @since 2022/10/21
 */
class InveroPool(
    val name: String,
    private val inveros: CopyOnWriteArrayList<Invero> = CopyOnWriteArrayList(),
    val index: Int = poolIndex
) {

    fun createInvero(
        type: WindowProperty,
        title: String = "Untitled",
        constructor: Invero.() -> Unit = {}
    ): Invero {
        return createInvero(this, type, title).also {
            inveros.add(it)
            constructor(it)
        }
    }

    fun findInvero(filter: (Invero) -> Boolean): Invero? {
        return inveros.find(filter)
    }

    fun forInveros(run: (Invero) -> Unit) {
        inveros.forEach(run)
    }

    fun removeInvero(invero: Invero) {
        inveros.remove(invero)
    }

    companion object {

        private fun createInvero(pool: InveroPool, type: WindowProperty, title: String): Invero {
            if (type.isOrdinaryChest) {
                return InvChest(pool, type.rows, title)
            } else return when (type) {
                WindowProperty.GENERIC_3X3 -> TODO()
                WindowProperty.ANVIL -> TODO()
                WindowProperty.BEACON -> TODO()
                WindowProperty.BLAST_FURNACE -> TODO()
                WindowProperty.BREWING_STAND -> TODO()
                WindowProperty.CRAFTING -> TODO()
                WindowProperty.ENCHANTMENT -> TODO()
                WindowProperty.FURNACE -> TODO()
                WindowProperty.GRINDSTONE -> TODO()
                WindowProperty.HOPPER -> InvHopper(pool, title)
                WindowProperty.LOOM -> TODO()
                WindowProperty.MERCHANT -> TODO()
                WindowProperty.SHULKER_BOX -> TODO()
                WindowProperty.SMOKER -> TODO()
                WindowProperty.CARTOGRAPHY_TABLE -> TODO()
                WindowProperty.STONECUTTER -> TODO()
                else -> throw UnsupportedOperationException("")
            }
        }

    }

}