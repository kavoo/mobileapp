/*
Kavita Shokeen
*/
var http = require("http"); // 
let fs = require('fs');
var express = require('express') // create function 
var app = express() //function call


let handleRequest = (request, response) => {
   response.writeHead(200, {
       'Content-Type': 'text/html'
   });
   fs.readFile('./SkySalon/index.html', null, function (error, data) {
       if (error) {
           response.writeHead(404);
           respone.write('Whoops! File not found!');
       } else {
           response.write(data);
       }
       response.end();
   });
};

http.createServer(function (request, response) {
   // Send the HTTP header 
   // HTTP Status: 200 : OK
   // Content Type: text/plain
  // response.writeHead(200, {'Content-Type': 'text/plain'});
   
   // Send the response body as "Hello World"
   //response.end('Hello World\n');
   //response.sendFile(__dirname + '/index.html');
   //response.render('/index.html');
   
   //response.statusCode(301).response.redirect('/index.html')
   response.writeHead(301, {"Location": "https://www.google.com/index.html"})
   response.end();

}).listen(8081);

// Console will print the message
console.log('Server running at http://127.0.0.1:8081/');