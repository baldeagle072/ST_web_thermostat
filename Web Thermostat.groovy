/**
 *  Web Thermostat
 *
 *  Copyright 2015 Eric Roberts
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Web Thermostat",
    namespace: "",
    author: "Eric Roberts",
    description: "Access your thermostat from a browser",
    category: "Green Living",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	section("Thermostat to control from a browser") {
		input "thermostat", "capability.thermostat", title: "Thermostat", required: true
	}
}

mappings {
    path("/ui") {
		action: [
			GET: "html",
		]
	}
    path("/command") {
    	action: [
			GET: "command",
		]
    }
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	getURL()
}

def getURL() {

}

def html() {
	render contentType: "text/html", data: "<!DOCTYPE html><html><head>${head()}${customCSS()}</head><body style='background-color:black'><body>${body()}</body></html>"
}

def head() {
"""
<meta charset="UTF-8" />
<title>${app.label ?: location.name}</title>
"""
}

def body() {

}

def customCSS() {

}