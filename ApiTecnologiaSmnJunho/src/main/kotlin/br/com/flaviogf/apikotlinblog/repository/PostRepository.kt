package br.com.flaviogf.apikotlinblog.repository

import br.com.flaviogf.apikotlinblog.modelo.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Long> {

    fun findAll(pageable: Pageable): Page<Post>
}
