import fetch from 'isomorphic-unfetch'

import {
  Env
} from '../config'

import {
  log,
  json
} from '../utils'

export class Post {

  @json
  @log
  static listaTodos() {
    return fetch(`${Env.URL_API}/post`)
  }

  @json
  @log
  static listaUltimos() {
    return fetch(`${Env.URL_API}/post/ultimos`)
  }

  @json
  @log
  static buscaPorId(id) {
    return fetch(`${Env.URL_API}/post/${id}`)
  }

  @json
  @log
  static buscaDestaque() {
    return fetch(`${Env.URL_API}/post/destaque`)
  }
}
