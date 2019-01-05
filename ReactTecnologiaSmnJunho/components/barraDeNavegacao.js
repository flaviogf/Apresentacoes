import React from 'react'

import Link from 'next/link'

export const BarraDeNavegacao = () => (
  <nav className="navbar is-light">
    <div className="navbar-brand">
      <Link prefetch
        href="/"
      >
        <a className="navbar-item">
          Blog
        </a>
      </Link>
    </div>
    <div className="navbar-menu navbar-start">
      <Link prefetch
        href="/ultimos"
      >
        <a className="navbar-item">
          Últimos
        </a>
      </Link>
      <Link prefetch
        href="/destaque"
      >
        <a className="navbar-item">
          Destaque
        </a>
      </Link>
    </div>
  </nav>
)
