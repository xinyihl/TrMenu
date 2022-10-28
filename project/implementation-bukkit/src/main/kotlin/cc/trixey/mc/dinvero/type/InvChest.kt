package cc.trixey.mc.dinvero.type

import cc.trixey.mc.dinvero.InveroPool
import cc.trixey.mc.dinvero.nms.WindowProperty

/**
 * @author Arasple
 * @since 2022/10/21
 */
internal class InvChest(pool: InveroPool, rows: Int, title: String) : InvInstance(
    pool = pool,
    property = when (rows) {
        1 -> WindowProperty.GENERIC_9X1
        2 -> WindowProperty.GENERIC_9X2
        3 -> WindowProperty.GENERIC_9X3
        4 -> WindowProperty.GENERIC_9X4
        5 -> WindowProperty.GENERIC_9X5
        else -> WindowProperty.GENERIC_9X6
    },
    title = title
) {

    override fun tick() {
        view.forViewers {
//            it.sendActionBar("$${System.currentTimeMillis()} ~ Just a tick")
        }
    }

}