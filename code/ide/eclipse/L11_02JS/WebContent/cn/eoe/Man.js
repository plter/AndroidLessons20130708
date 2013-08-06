//if (!window.cn) {
//	window.cn = {};
//}
//if (!window.cn.eoe) {
//	window.cn.eoe = {};
//}

//var cn = {};
//cn.eoe = {};

/**
 * @param {String} name
 */
cn.eoe.Man = function(name){
	cn.eoe.People.call(this,name);
};
cn.eoe.Man.prototype = new cn.eoe.People();