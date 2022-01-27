const express = require('express');
const app = express();
const router = express.Router()
const database = require('../../dbConnection');

router.get('/', (req, res) => {

    database.select().table('tb_post').then((response) => {
        res.json(response);
    })

});

router.get('/id/:id', (req, res) => {
    database.select().table('tb_post')
        .where({id: req.params.id})
        .first()
        .then((response) => {
        res.json(response);
    })
});

module.exports = router;