require('babel-register')({
	presets: ['react']
});
var express = require('express');
var app = express();
var path = require("path");
var proxy = require('http-proxy-middleware');
var port = 3000;
/*
var ejs = require("ejs");
var decoder = new StringDecoder('utf8');
var http = require('http');
var request = require('request');
var StringDecoder = require('string_decoder').StringDecoder;
*/

app.use(express.static('public'));
app.use(require('./routes/index.jsx'));


var options = {
	target: 'http://localhost:8080', // 目标主机
	changeOrigin: true         // 需要虚拟主机站点
};


var exampleProxy = proxy(options);  //开启代理功能，并加载配置
app.use('/api', exampleProxy);//对地址为’/api‘的请求全部转发


// app.set('views', path.join(__dirname, 'pages/'));
// app.set('view engine', 'ejs');


// app.get('/index', function(req, res, next) {
// 	var d;

// 	var formData = {
// 		username: 'kevin',
// 		password: '1234567'
// 	};

// 	request.post({url:'http://localhost:8080/api/user/login', formData: formData}, function optionalCallback(err, httpResponse, body) {
// 		if (err) {
// 			console.log(err);
// 		} else if (body) {
// 			d = JSON.parse(body);
// 			console.log(d["msg"]);
// 			render(JSON.parse(body));
// 		}
// 	});

// 	function render(data) {
// 		// res.send(data);
// 		res.render('index', { title: 'Kevin page', message: data['msg'] });
// 	}
// });


app.listen(port, () => {
	console.log("Listening on port " + port);
});
