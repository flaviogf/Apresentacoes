import React from 'react'

import PropTypes from 'prop-types'

import Head from 'next/head'

import {
  BarraDeNavegacao
} from './barraDeNavegacao'

export const Pagina = ({ children }) => (
  <>
    <Head>
      <meta charSet="utf-8" />
      <meta name="viewport"
        content="width=device-width, initial-scale=1"
      />
      <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css"
      />
    </Head>
    <BarraDeNavegacao />
    <div className="section">
      <div className="container">
        {children}
      </div>
    </div>
  </>
)

Pagina.propTypes = {
  children: PropTypes.node.isRequired
}
