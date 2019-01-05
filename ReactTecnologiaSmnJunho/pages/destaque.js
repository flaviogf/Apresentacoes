import React from 'react'

import {
  Pagina,
  Post
} from '../components'

import {
  Post as servico
} from '../services'

export default class Destaque extends React.Component {

  static async getInitialProps() {
    const destaque = await servico.buscaDestaque()
    return { destaque }
  }

  render() {
    const { destaque = {} } = this.props
    return (
      <Pagina>
        <Post post={destaque}
          titulo="Destaque"
        />
      </Pagina>
    )
  }
}
