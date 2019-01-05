export const log = (alvo, nome, descritor) => {
  const { value: funcao } = descritor
  descritor.value = async function (...args) {
    const inicio = Date.now()
    console.log('Log:', inicio)
    const resultado = await funcao.apply(this, args)
    const fim = Date.now()
    console.log(`Servico: ${alvo.name} - Metodo: ${nome} - Tempo ${fim - inicio} ms`)
    return resultado
  }
  return descritor
}
