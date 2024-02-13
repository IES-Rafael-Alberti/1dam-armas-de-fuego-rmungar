package src

import kotlin.random.Random

class Rifle(municion:Int, tipoDeMunicion:String):ArmaDeFuego(municion,tipoDeMunicion) {
    override val danio: Int = Random.nextInt(5,10)
    override val nombre: String = "Rifle"
    override val municionArestar: Int = 1

    override val radio: TipoRadio = decidirRadio()
    init {
        require(danio in 5..10) {"El daño debe estar entre 5 y 10"}
        require(radio == TipoRadio.CORTO || radio == TipoRadio.INTERMEDIO) {"El radio ha de ser Corto o Intermedio"}
    }

    override fun decidirRadio():TipoRadio{
        val random = Random.nextInt(1,2)
        if (random == 1){
            return TipoRadio.CORTO
        }
        else{
            return TipoRadio.INTERMEDIO
        }
    }


}