package CreationalPattern




/**
 *FactoryPattern
 * include:SampleFactory
 * all example use fruit as items
* */



/**
 * SimpleFactory
* */

class SampleFactory {
    fun create(type:String):Fruit{
       return when(type){
            "Apple" -> Apple()
            "Pear" -> Pear()
            else -> throw IllegalAccessException("unknown fruit")
       }
    }
}

/**
 * FactoryMethod
* */

class AppleFactory{
    fun create():Fruit {
        return Apple("sunning","no water","bad send")
    }
}

class PearFactory{
    fun create():Fruit = Pear()
}


/**
 * AbstractFactory
* */

//Interface
interface IFruitFactory{
    fun create():Fruit
}
//
class AppleIFactory : IFruitFactory{
    override fun create():Fruit {
        return Apple()
    }
}

class PearIFactory : IFruitFactory{
    override fun create():Fruit {
        return Pear()
    }
}




/**
 * Some depend class
* */
abstract class Fruit{
    open fun eat(){}
}

class Apple(val sunshine:String="sunlight",val water:String="water",val send:String="send"): Fruit() {


    override fun eat(){
        println("This is apple with $sunshine, $water, $send")
    }
}

class Pear: Fruit(){
    override fun eat(){
        println("This is pear")
    }
}



/**
 * MainFunction
* */

fun main() {
    //SampleFactory
    println("====SampleFactory====")
    val sampleFactory = SampleFactory()
    val sampleApple = sampleFactory.create("Apple") //use different input to choose different instantiated class
    val samplePear = sampleFactory.create("Pear")
    sampleApple.eat()
    samplePear.eat()
    println()

    //FactoryMethod
    println("====FactoryMethod====")
    val appleFactory = AppleFactory() // if you wanna change Apple construct,just edit Factory.you can keep this line
    val pearFactory = PearFactory()
    val fmApple = appleFactory.create()
    val fmPear = pearFactory.create()
    fmApple.eat()
    fmPear.eat()
    println()

    //AbstractFactory
    println("====AbstractFactory====")
    var iFruit : IFruitFactory = AppleIFactory()
    iFruit.create().eat()
    iFruit = PearIFactory()  //attention: the type of iFruit is still IFruitFactory,that means its easy to change init class
    iFruit.create().eat()
    println()
}