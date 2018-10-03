'use strict';

var util = require('util');
var http = require('http');
var packagejson = require("./../../package");

module.exports = {
  execute: execute
};

function execute(req, res) {
  // variables defined in the Swagger document can be referenced using req.swagger.params.{parameter_name}
  var param1 = req.swagger.params.param1.value || 0;
  var param2 = req.swagger.params.param2.value || 0;
  var operation = req.swagger.params.operation.value || 'NOOP';
  var resultValue = 0;
  switch (operation) {
	case 'add':
	case 'ADD':
		var options = {		
				host: packagejson.configs.addServiceHost,
				//port: packagejson.configs.addServicePort,
				path: packagejson.configs.addServicePath + 'param1='+ parseInt(param1) + '&param2=' + parseInt(param2),
				method: 'GET'
				}
		http.request(options, function(res1) {
			console.log('STATUS:' + res1.statusCode);
			var body = '';
			res1.on('data', function(chunk) {
				body += chunk;
			});
			res1.on('end', function() {
				var parsed = JSON.parse(body);
				resultValue = parsed.result;
				// this sends back a JSON response which is a single string  
				var rVar = {result: parseInt(resultValue)};
				console.log("Response to org Request" + JSON.stringify(rVar));
				res.json(rVar);
			});
		}).end();
		break;
	case 'sub':
	case 'SUB':
		var options = {
				host: packagejson.configs.subServiceHost,
				//port: packagejson.configs.subServicePort,
				path: packagejson.configs.subServicePath + 'param1='+ parseInt(param1) + '&param2=' + parseInt(param2),
				method: 'GET'
				}
		http.request(options, function(res1) {
			console.log('STATUS:' + res1.statusCode);
			var body = '';
			res1.on('data', function(chunk) {
				body += chunk;
			});
			res1.on('end', function() {
				var parsed = JSON.parse(body);
				resultValue = parsed.result;
				// this sends back a JSON response which is a single string  
				var rVar = {result: parseInt(resultValue)};
				console.log("Response to org Request" + JSON.stringify(rVar));
				res.json(rVar);
			});
		}).end();
		break;
  }


}
