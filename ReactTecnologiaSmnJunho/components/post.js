import React from 'react'

import PropTypes from 'prop-types'

export const Post = ({ post, titulo }) => (
  <>
    <h1 className="title is-1">
      {titulo}
    </h1>
    <h3 className="title is-3">
      {post.titulo}
    </h3>
    <p>
      Descrição: {post.descricao}
    </p>
  </>
)

Post.propTypes = {
  titulo: PropTypes.string.isRequired,
  post: PropTypes.object.isRequired
}
