package src

fun main() {
    try {
        val listaArmas = mutableListOf<ArmaDeFuego>()
        val pistola1 = Pistola( 6, "9mm")
        listaArmas.add(pistola1)
        val rifle1 = Rifle(8, "7.62mm")
        listaArmas.add(rifle1)
        val bazooka1 = Bazooka(3, "RPG")
        listaArmas.add(bazooka1)
        val disparos = (1..12).map { listaArmas.random() to (1..3).random() }
        var cont = 1
        println("Munición Extra = ${ArmaDeFuego.cajaMunicionExtra} ... para todas las armas de fuego.")
        println()
        for (disparo in disparos) {
            println("*** Disparo: $cont")
            for (i in 1..disparo.second) {
                disparo.first.disparar()
                println(disparo.first.toString())
            }
            cont++
        }
    }
    catch (e:Exception){
        println(e.message)
    }
}