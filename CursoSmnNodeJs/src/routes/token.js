const jwt = require('jwt-simple')

module.exports = (app) => {
    const usuarios = app.mock.usuarios
    app.post('/token', (req, res) => {
        const { body } = req
        const filtro = (usuario) => usuario.nome == body.nome && usuario.senha == body.senha
        const usuario = usuarios.filter(filtro)[0]
        if (usuario) {
            const token = jwt.encode(usuario, process.env.SECRETA)
            res.json(token)
        } else {
            res.json('falha')
        }
    })
}