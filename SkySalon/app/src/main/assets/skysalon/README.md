# ####################
# SETUP DEV ENVIRONMENT
# ####################
# skysalon
# setup dev env
#   install vscode, git, git extension in vscode, node.js
#   clone the repo from vscode ctrl+shift+p git clone
#   authorize github access so cloning is possible

# How to start the project on developer machine
#   ensure you are in the right folder, like, PS C:\Users\novice\OneDrive - Lake Washington Institute of Technology\github\repo\skysalon>
#   npm install command should be run, to get the dependencies used in this node application like express
#   npm start command will run the node app
# open browser with https://localhost:8080 to check if the site is accessible

# #######################
# How to deploy the project on Azure?
# #######################
# https://docs.microsoft.com/en-us/azure/developer/javascript/tutorial-vscode-azure-app-service-node-01?tabs=bash
#       Other deploy methods: https://code.visualstudio.com/docs/azure/deployment

# Get Started 
#   Step 1: https://code.visualstudio.com/docs/nodejs/nodejs-tutorial
#       How to start up your vscode and the project basic infra
#   https://www.tutorialspoint.com/nodejs/nodejs_first_application.htm
#       Minimalistic code for app.js/main.js
#   https://stackoverflow.com/questions/35995273/how-to-run-html-file-using-node-js
#       Basic skeleton code to redirect to html file
#           Additional references, not used though
#               https://teamtreehouse.com/community/how-to-redirect-in-nodejs-without-express-in-callback
#               Node Docs: https://nodejs.org/api/
#               Express Docs: http://expressjs.com/en/api.html
#   https://dcc.godaddy.com/manage/skysalon.in/dns
#       Configure GoDaddy to point to Azure

# Setup Application Insights: https://docs.microsoft.com/en-us/azure/azure-monitor/app/nodejs

# #################
# REFERENCES
# #################
# Basic VSCODe extention to setup git account for checkin to githug was using MS account, had to switch vscode workspace to inner/repo folder and setup in .git/config file or using extension https://marketplace.visualstudio.com/items?itemName=shyykoserhiy.git-autoconfig
# Kudu debugging the site: https://skysalon.scm.azurewebsites.net/
#       App Service Online Editor: https://skysalon.scm.azurewebsites.net/dev/wwwroot/package.json
# Custom DomainName: https://docs.microsoft.com/en-us/azure/app-service/manage-custom-dns-buy-domain
# Securing the site, handling certificates
#   Add Certificate: https://docs.microsoft.com/en-us/azure/app-service/configure-ssl-certificate#create-a-free-certificate-preview
#   Secure CustomName/TLS binding: https://docs.microsoft.com/en-us/azure/app-service/configure-ssl-bindings#create-binding
#   Free Resource List: https://azure.microsoft.com/en-us/free/#12-months-free


# Deployment History: https://portal.azure.com/#@6ac90cf0-4613-4fa5-a2b5-89248502d821/resource/subscriptions/f51ff3bd-cac4-4316-ac74-a113fe48fb03/resourcegroups/SkySalonRG/providers/Microsoft.Web/sites/skysalon/vstscd
# Staging: https://skysalon-stage.azurewebsites.net/

# Learnings
# use Launch Chrome to debug client side
# use Launch Node to debug server side
# use debugger or breakpoint to pause the code
# link to dev instance of appinsights: https://portal.azure.com/#@6ac90cf0-4613-4fa5-a2b5-89248502d821/resource/subscriptions/f51ff3bd-cac4-4316-ac74-a113fe48fb03/resourcegroups/SkySalonRG/providers/microsoft.insights/components/skysalondev/logs





# adding mysql support
# npm install mysqljs/mysql