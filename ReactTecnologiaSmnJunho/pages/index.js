import React from 'react'

import {
  Pagina,
  Posts
} from '../components'

import {
  Post as service
} from '../services'

export default class Index extends React.Component {

  static async getInitialProps() {
    const posts = await service.listaTodos()
    return { posts }
  }

  render() {
    const { posts = [] } = this.props
    return (
      <Pagina>
        <Posts posts={posts}
          titulo="Início"
        />
      </Pagina>
    )
  }
}
