package br.com.flaviogf.apikotlinblog.controller

import br.com.flaviogf.apikotlinblog.modelo.Post
import br.com.flaviogf.apikotlinblog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("post")
@RestController
class PostController @Autowired constructor(private val repositorio: PostRepository) {

    @GetMapping
    fun listaTodos(): Iterable<Post> {
        return repositorio.findAll()
    }

    @GetMapping("ultimos")
    fun listaUltimos(): Iterable<Post> {
        val filtro = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "id"))
        return repositorio.findAll(filtro).content
    }

    @GetMapping("destaque")
    fun buscaDestaque(): Post {
        return repositorio.findAll().last()
    }

    @GetMapping(path = ["{id}"])
    fun buscaPorId(@PathVariable id: Long): Post? {
        return repositorio.findById(id).orElse(null)
    }

    @PostMapping
    fun insere(@RequestBody post: Post): Post {
        return repositorio.save(post)
    }
}
