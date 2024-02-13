package src

import kotlin.random.Random

class Bazooka(municion:Int,tipoDeMunicion:String):ArmaDeFuego(municion,tipoDeMunicion)  {
    override val danio: Int = Random.nextInt(10,30)
    override val nombre: String = "Bazooka"
    override val municionArestar: Int = 1
    override val radio: TipoRadio = decidirRadio()
    init {
        require(danio in 10..30) {"El daño debe estar entre 10 y 30"}
        require(radio == TipoRadio.INTERMEDIO|| radio == TipoRadio.ENORME) {"El radio ha de ser Inermedio o Enorme"}
    }


    override fun decidirRadio():TipoRadio{
        val random = Random.nextInt(1,2)
        if (random == 1){
            return TipoRadio.INTERMEDIO
        }
        else{
            return TipoRadio.ENORME
        }
    }


}