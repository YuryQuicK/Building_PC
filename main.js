const http = require("http");
var fs = require('fs');
var mustache = require('mustache');
 
http.createServer(function(request, response){
	if(request.url == '/index2') {
		var view = {
			className: ''
		}
		var data = fs.readFileSync(__dirname + '\\index.html', 'utf8');
		response.writeHead(200);
		response.end(mustache.render(data, view));
	} else if(request.url == '/index1') {
		let data = '';
		let newData = '';
		request.on('data', chunk => {
			data += chunk;
		})
		request.on('end', () => {
			newData = data.substr(10, 6)
			fs.readFile(__dirname + '\\index.html', function (err,data) {
				if (err) {
					response.writeHead(404);
					response.end(JSON.stringify(err));
					return;
				}
				var view = {
					className: newData
				}
				var data = fs.readFileSync(__dirname + '\\index.html', 'utf8');
				response.writeHead(200);
				response.end(mustache.render(data, view));
			});
		})
	} else if (request.url == '/data') {
		var object = {
			'FirstValue': 0,
			'SecondValue': 1000
		};
		response.writeHead(200);
		response.end(JSON.stringify(object));
	} else {
		fs.readFile(__dirname + request.url, function (err,data) {
			if (err) {
				response.writeHead(404);
				response.end(JSON.stringify(err));
				return;
			}
			response.writeHead(200);
			response.end(data);
		});
	}
}).listen(3000);
