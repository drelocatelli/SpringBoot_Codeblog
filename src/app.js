const express = require('express');
const database = require ('../dbConnection');

const app = express();
const port = 3000;

app.get('/', (req, res) => {
    res.send('Hello world!')
});

// ================ routes
const postsRoute = require('./routes/postsRoute');

app.use('/api/posts', postsRoute);



app.listen(port, () => {
    console.log('Runing server on port '+ port);
});