import React from 'react'

import {
  Pagina,
  Post as PostComponent
} from '../components'

import {
  Post as service
} from '../services'

export default class Post extends React.Component {

  static async getInitialProps({ query: { id } }) {
    const post = await service.buscaPorId(id)
    return { post }
  }

  render() {
    const { post = {} } = this.props
    return (
      <Pagina>
        <PostComponent post={post}
          titulo="Post"
        />
      </Pagina>
    )
  }
}
