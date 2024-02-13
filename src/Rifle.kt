package src

import kotlin.random.Random
/**
 * La clase Rifle hereda de la clase abstracta ArmaDeFuego y cuenta con sus propiedades propias:
 * @property municion -> Entero que representa la munción máxima que puede llevar el arma.
 * @property tipoDeMunicion -> Cadena que indica el tipo de calibre de las balas de arma.
 * Y las propiedades heredadas de ArmaDeFuego:
 * @property nombre -> Cadena que representa el nombre del arma. (RIFLE)
 * @property municionArestar -> Entero que indica la munición que se gasta al disparar. (2)
 * @property danio -> Entero aleatorio que representa el daño del arma.
 * @property radio -> Representa el radio de impacto de las balas del arma.
 */
class Rifle(municion:Int, tipoDeMunicion:String):ArmaDeFuego(municion,tipoDeMunicion) {
    override val danio: Int = Random.nextInt(5,10)
    override val nombre: String = "Rifle"
    override val municionArestar: Int = 1
    override val radio: TipoRadio = decidirRadio()

    init {
        require(danio in 5..10) {"El daño debe estar entre 5 y 10"}
        require(radio == TipoRadio.CORTO || radio == TipoRadio.INTERMEDIO) {"El radio ha de ser Corto o Intermedio"}
    }

    /**
     * La funcion decidirRadio() ha sido modificada para que el radio se ajuste al arma
     * @return El valor del radio
     */
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