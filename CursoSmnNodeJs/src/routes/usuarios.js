module.exports = (app) => {
    const usuarios = app.mock.usuarios
    
    app.get('/usuario', (req, res) => {
        res.json(usuarios)
    })

    app.post('/usuario', (req, res) => {
        const { body } = req
        usuarios.push(body)
        res.json(usuarios)
    })
}