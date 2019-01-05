import React from 'react'

import PropTypes from 'prop-types'

import {
  ItemPost
} from './itemPost'

export const Posts = ({ posts, titulo }) => (
  <>
    <h1 className="title is-1">
      {titulo}
    </h1>
    {posts.map(post => <ItemPost key={post.id} post={post} />)}
  </>
)

Posts.propTypes = {
  titulo: PropTypes.string.isRequired,
  posts: PropTypes.array.isRequired
}
