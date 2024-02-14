package src

/**
 * La enum class TipoRadio contiene los diferentes tipos de radios de impacto de las armas.
 */
enum class TipoRadio(val desc: String) {
    REDUCIDO("REDUCIDO"), CORTO("CORTO"), INTERMEDIO("INTERMEDIO"), AMPLIO("AMPLIO"), ENORME("ENORME")
}