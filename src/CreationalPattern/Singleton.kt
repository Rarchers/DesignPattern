package CreationalPattern

/**
 * HungryStyle
* */
object SingletonHungry :IPrint{
    override fun print() {
        println("Hungry style Singleton")
    }

}

/**
 * LazyStyle
* */

class SingletonLazy private constructor(): IPrint{
    companion object {
        private var INSTANCE : SingletonLazy? = null
        get() {
            if (field == null){
                field = SingletonLazy()
            }
            return field
        }

        fun get():SingletonLazy{
            return INSTANCE!!
        }
    }
    override fun print() {
        println("Lazy style Singleton")
    }

}

/**
 * Thread safe laze
* */

class SingletonLazeThreadSafe private constructor(): IPrint{

    companion object {
        private var INSTANCE : SingletonLazeThreadSafe? = null
            get() {
                if (field == null){
                    field = SingletonLazeThreadSafe()
                }
                return field
            }
        @Synchronized
        fun get():SingletonLazeThreadSafe{
            return INSTANCE!!
        }
    }

    override fun print() {
        println("Laze with thread safe")
    }

}

/**
 * Thread safe double check
* */



class SingletonDoubleCheck private constructor():IPrint{
    //Lazy是接受一个 lambda 并返回一个 Lazy 实例的函数，返回的实例可以作为实现延迟属性的委托：
    // 第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
    companion object{
        val INSTANCE : SingletonDoubleCheck by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDoubleCheck()
        }
    }
    override fun print() {
        println("Double check laze")
    }

}


/**
 * inner class
* */

class SingletonInnerClass : IPrint{
    companion object{
        val INSTANCE = Inner.holder
    }


    override fun print() {
        println("Inner class")
    }

    private object Inner{
        val holder = SingletonInnerClass()
    }
}


fun main() {
    SingletonHungry.print()
    SingletonLazy.get().print()
    SingletonLazeThreadSafe.get().print()
    SingletonDoubleCheck.INSTANCE.print()
    SingletonInnerClass.INSTANCE.print()
}

interface IPrint{
    fun print()
}