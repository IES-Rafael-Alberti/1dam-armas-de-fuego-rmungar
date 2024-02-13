package src

import kotlin.random.Random
/**
 * La clase Bazooka hereda de la clase abstracta ArmaDeFuego y cuenta con sus propiedades propias:
 * @property municion -> Entero que representa la munción máxima que puede llevar el arma.
 * @property tipoDeMunicion -> Cadena que indica el tipo de calibre de las balas de arma.
 * Y las propiedades heredadas de ArmaDeFuego:
 * @property nombre -> Cadena que representa el nombre del arma. (BAZOOKA)
 * @property municionArestar -> Entero que indica la munición que se gasta al disparar. (3)
 * @property danio -> Entero aleatorio que representa el daño del arma.
 * @property radio -> Representa el radio de impacto de las balas del arma.
 */
class Bazooka(municion:Int,tipoDeMunicion:String):ArmaDeFuego(municion,tipoDeMunicion)  {
    override val danio: Int = Random.nextInt(10,30)
    override val nombre: String = "Bazooka"
    override val municionArestar: Int = 1
    override val radio: TipoRadio = decidirRadio()

    init {
        require(danio in 10..30) {"El daño debe estar entre 10 y 30"}
        require(radio == TipoRadio.INTERMEDIO|| radio == TipoRadio.ENORME) {"El radio ha de ser Inermedio o Enorme"}
    }

    /**
     * La funcion decidirRadio() ha sido modificada para que el radio se ajuste al arma
     * @return El valor del radio
     */
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