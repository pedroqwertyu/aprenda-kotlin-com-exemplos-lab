enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)

    val formacao = Formacao("Code Update TQI - Backend com Kotlin e Java", listOf(conteudo1, conteudo2, conteudo3), Nivel.BASICO)

    val usuario1 = Usuario("eu", "eu@gmail.com")
    val usuario2 = Usuario("jorginho", "jorginho@gmail.com")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Inscritos na formação ${formacao.nome}, nivel ${formacao.nivel}:")
    for (usuario in formacao.inscritos) {
        println("Nome: ${usuario.nome}, Email: ${usuario.email}")
    }
    
}
