package src
import kotlin.random.Random
import kotlin.random.nextInt
class Pistola(municion:Int,tipoDeMunicion:String):ArmaDeFuego(municion,tipoDeMunicion) {
    override val nombre:String = "Pistola"
    override val danio: Int = Random.nextInt(1,5)
    override val municionArestar: Int = 1
    override val radio: TipoRadio = decidirRadio()
    init {
        require(danio in 1..5) {"El daño debe estar entre 1 y 5"}
        require(radio == TipoRadio.CORTO || radio == TipoRadio.REDUCIDO) {"El radio ha de ser Reducido o Corto"}
    }

    override fun decidirRadio():TipoRadio{
        val random = Random.nextInt(1,2)
        if (random == 1){
            return TipoRadio.REDUCIDO
        }
        else{
            return TipoRadio.CORTO
        }
    }

}