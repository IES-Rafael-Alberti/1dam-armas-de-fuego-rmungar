package src

fun main() {
    try {
        val listaArmas = mutableListOf<ArmaDeFuego>()
        val P1 = Pistola( 6, "9mm")
        listaArmas.add(P1)
        val R1 = Rifle(8, "7.62mm")
        listaArmas.add(R1)
        val B1 = Bazooka(3, "RPG")
        listaArmas.add(B1)
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