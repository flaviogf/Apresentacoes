const jwt = require('jwt-simple')
const usuarios = require('../mock/usuarios')

module.exports = (app) => {
    app.use((req, res, next) => {
        const token = req.header('Authorization')
        if (token) {
            try {
                const usuario = jwt.decode(token, process.env.SECRETA)
                const filtro = (item) => usuario.nome == item.nome && usuario.senha == item.senha
                const usuarioCadastro = usuarios.filter(filtro)[0]
                if (usuarioCadastro)
                    next()
            } catch (e) {
                return res.json('Token invalido')
            }
        }
        res.json('Não autenticado')
    })
}