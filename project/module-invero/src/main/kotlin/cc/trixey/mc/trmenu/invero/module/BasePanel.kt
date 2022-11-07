package cc.trixey.mc.trmenu.invero.module

/**
 * @author Arasple
 * @since 2022/11/6 16:47
 */
abstract class BasePanel(scale: Pair<Int, Int>, pos: Int, weight: PanelWeight) : PanelInstance(scale, pos, weight) {

    private val elementsMap = MappedElements()

    fun setElement(relativeSlot: Int, element: PanelElement) {
        elementsMap[relativeSlot] = element
    }

    fun getElement(relativeSlot: Int): PanelElement? {
        return elementsMap[relativeSlot]
    }

    fun addElementDynamic(element: PanelElementDynamic) {
        elementsMap += element
    }

    fun removeElementDynamic(element: PanelElementDynamic) {
        elementsMap -= element
    }

    fun getElements(): MappedElements {
        return elementsMap
    }

    override fun render(window: Window) {
        elementsMap.forEach { _, panelElement ->
            panelElement.render(window)
        }
    }

}