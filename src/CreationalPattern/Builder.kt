package CreationalPattern


class MilkTea private constructor(){
    private lateinit var type:String
    private lateinit var size:String
    private var ice = false
    private var pearl = false

    companion object{
        fun Builder() :Helper{
            return Helper()
        }
    }

    fun show(){
        println("一杯 $size $type ${if (ice)"加冰" else "不加冰"} ${if (pearl)"加珍珠" else "不加珍珠"} 奶茶")
    }

    class Helper{
        private val milkTea = MilkTea()

        fun setType(type:String):Helper{
            milkTea.type = type
            return this
        }

        fun setSize(size:String):Helper{
            milkTea.size = size
            return this
        }

        fun isIce(ice:Boolean):Helper{
            milkTea.ice = ice
            return this
        }

        fun isPearl(pearl:Boolean):Helper{
            milkTea.pearl = pearl
            return this
        }

        fun build():MilkTea{
            return milkTea
        }

    }
}


fun main() {
    val strawberry = MilkTea.Builder()
            .setType("草莓")
            .setSize("大杯")
            .isIce(true)
            .isPearl(true)
            .build()
    val pear = MilkTea.Builder()
            .setType("梨子")
            .setSize("中杯")
            .isIce(false)
            .isPearl(false)
            .build()
    strawberry.show()
    pear.show()
}