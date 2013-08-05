
/**
 * 
 * @param {Number} age
 * @param {String} name
 * @returns
 */
function People(age,name){
	
	this.init = function(age,name){
		this._age = age;
		this._name = name;
	};
		
	this.setAge = function(age){
		this._age = age;
	};
	
	this.getAge = function(){
		return this._age;
	};
	
	this.getName = function(){
		return this._name;
	};
	
	/**
	 * @param {String} name
	 */
	this.sayHello=function(){
		console.log("Hello "+this.getName());
	};
	
	this.init(age,name);
}


var a = new People(18,"ZhangDao");
a.sayHello();


function Man(age,name){
	this.init(age,name);
}
var p= Man.prototype = new People();
p.People_init = p.init;

p.init = function(age,name){
	this.People_init(age,name);
};


var m = new Man(20,"LiShaoqing");
m.sayHello();


function Woman(age,name){
	People.call(this,age,name);
}
Woman.prototype = new People();

var w = new Woman(18, "Xiaoli");
w.sayHello();



