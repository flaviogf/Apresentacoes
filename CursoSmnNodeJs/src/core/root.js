module.exports = (app) => {
    app.listen(process.env.PORTA, () => {
        console.log(`escutando na ${process.env.PORTA}`)
    })
}