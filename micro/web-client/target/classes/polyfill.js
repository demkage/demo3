var global = {};
var document = {};
var window = {};
var console = {};

document.getElementById = function () {
}

this.window = window;
this.document = document;

global.windopw = window;
global.document = document;

console.debug = print;
console.warn = print;
console.log = print;
console.error = print;