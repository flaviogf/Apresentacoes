export const json = (alvo, nome, descritor) => {
  const { value: funcao } = descritor
  descritor.value = async function (...args) {
    console.log('Json:', Date.now())
    try {
      const resposta = await funcao.apply(this, args)
      const data = await resposta.json()
      if (data.error) throw data.error
      return data
    } catch (e) {
      console.log('Erro requisição:', e)
    }
  }
  return descritor
}
