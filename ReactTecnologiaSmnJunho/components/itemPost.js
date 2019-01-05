import React from 'react'

import Link from 'next/link'

export const ItemPost = ({ post }) => (
  <article key={post.id}
    className="card"
    style={{ margin: 25 }}
  >
    <header className="card-header">
      <h3 className="card-header-title">
        {post.titulo}
      </h3>
      <Link as={`post/${post.id}`}
        href={{ query: { id: post.id }, pathname: '/post' }}
      >
        <a className="card-header-icon">
          Ler
        </a>
      </Link>
    </header>
    <div className="card-content">
      <div className="content">
        <p>{post.descricao}</p>
      </div>
    </div>
  </article>
)
