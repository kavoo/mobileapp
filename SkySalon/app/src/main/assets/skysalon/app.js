/*
 Kavita Shokeen 
*/
var express = require('express') 
var app = express()
var path = require('path'); 

// Objective #1: Use Azure App Insights to track the usage of the website
// https://docs.microsoft.com/en-us/azure/azure-monitor/app/nodejs
// DEV: https://portal.azure.com/#@lwtech.onmicrosoft.com/resource/subscriptions/f51ff3bd-cac4-4316-ac74-a113fe48fb03/resourcegroups/SkySalonRG/providers/microsoft.insights/components/skysalondev/overview
//      InstrumentationKey=6e875c5a-3182-4b4e-bcbf-2716caafe6fe;IngestionEndpoint=https://westus2-0.in.applicationinsights.azure.com/
// PROD: 
//      InstrumentationKey=a3021fe0-9d6e-474d-9e5e-1821334b5dfd;IngestionEndpoint=https://centralindia-0.in.applicationinsights.azure.com/
let appikey = 'InstrumentationKey=6e875c5a-3182-4b4e-bcbf-2716caafe6fe;IngestionEndpoint=https://westus2-0.in.applicationinsights.azure.com/';

let appInsights = require('applicationinsights');
appInsights.setup(appikey)
  .setAutoDependencyCorrelation(true)
  .setAutoCollectRequests(true)
  .setAutoCollectPerformance(true, true)
  .setAutoCollectExceptions(true)
  .setAutoCollectDependencies(true)
  .setAutoCollectConsole(true)
  .setUseDiskRetryCaching(true)
  .setSendLiveMetrics(true)
  .setDistributedTracingMode(appInsights.DistributedTracingModes.AI)  
  .start();
// debugger;
//response.end('Hello World\n');
app.use( express.static(path.join(__dirname )) );
console.log(__dirname);

// app.get('/', function(req, res) {
//   // Prepare the context
//   res.redirect('/SkySalon');
// });

var port = normalizePort(process.env.PORT || '8080');
app.set('port' , port);
app.listen(port);
console.log('Starting on port:' + port);
app.on('error', onError);
app.on('listening', onListening);

// https://www.npmjs.com/package/applicationinsights
// https://docs.microsoft.com/en-us/azure/azure-monitor/app/nodejs#live-metrics
// let client = appInsights.defaultClient;
// client.trackEvent({name: "my custom event", properties: {customProperty: "custom property value"}});
// client.trackException({exception: new Error("handled exceptions can be logged with this method")});
// client.trackMetric({name: "custom metric", value: 3});
// client.trackTrace({message: "trace message"});
// client.trackDependency({target:"http://dbname", name:"select customers proc", data:"SELECT * FROM Customers", duration:231, resultCode:0, success: true, dependencyTypeName: "ZSQL"});
// client.trackRequest({name:"GET /customers", url:"http://myserver/customers", duration:309, resultCode:200, success:true});


/**
 * Normalize a port into a number, string, or false.
 */

function normalizePort(val) {
    var port = parseInt(val, 10);
  
    if (isNaN(port)) {
      // named pipe
      return val;
    }
  
    if (port >= 0) {
      // port number
      return port;
    }
  
    return false;
  }
  
  /**
   * Event listener for HTTP server "error" event.
   */
  
  function onError(error) {
    if (error.syscall !== 'listen') {
      throw error;
    }
  
    var bind = typeof port === 'string'
      ? 'Pipe ' + port
      : 'Port ' + port;
  
    // handle specific listen errors with friendly messages
    switch (error.code) {
      case 'EACCES':
        console.error(bind + ' requires elevated privileges');
        process.exit(1);
        break;
      case 'EADDRINUSE':
        console.error(bind + ' is already in use');
        process.exit(1);
        break;
      default:
        throw error;
    }
  }
  
  /**
   * Event listener for HTTP server "listening" event.
   */
  
  function onListening() {
    var addr = server.address();
    var bind = typeof addr === 'string'
      ? 'pipe ' + addr
      : 'port ' + addr.port;
    debug('Listening on ' + bind);
  }
  