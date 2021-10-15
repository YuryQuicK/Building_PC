const http = require("http");
var fs = require('fs');
var mustache = require('mustache');
 
http.createServer(function(request, response){
	//let newData='';
	if(request.url == '/index2') {
		//newData='';
		var view = {
			className: ''//newData
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
			console.log(data);
			//if (newData == '') newData = data.substr(10, 6);
			newData = data.substr(10, 6)
			console.log(newData);
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
	} /*else if (request.url == '/index.html') {
		if (newData=='') {
			response.statusCode=301;
			response.setHeader("Location", "/index2");
		} else {
			response.statusCode=301;
			response.setHeader("Location", "/index1");
		}
		response.end();
	} */else {
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
