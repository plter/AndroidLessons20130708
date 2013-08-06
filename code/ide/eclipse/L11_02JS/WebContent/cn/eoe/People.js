//if (!window.cn) {
//window.cn = {};
//}
//if (!window.cn.eoe) {
//window.cn.eoe = {};
//}

//window.cn = window.cn||{};
//cn.eoe = {};

(function(){

	/**
	 * @param {String} name
	 */
	cn.eoe.People = function(name){

		this._name = name;

		this.sayHello = function(){
			console.log("Hello "+this._name);
		};
	};
}());