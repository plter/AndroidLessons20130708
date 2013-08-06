(function (lib, img, cjs) {

var p; // shortcut to reference prototypes

// stage content:
(lib.MyLib = function() {
	this.initialize();

	// Layer 1
	this.instance = new lib.Anim();
	this.instance.setTransform(181.6,165.1,1,1,0,0,0,38.5,38);

	this.addChild(this.instance);
}).prototype = p = new cjs.Container();
p.nominalBounds = new cjs.Rectangle(143.1,127.1,78,78);


// symbols:
(lib.Anim = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{Start:0});

	// Layer 1
	this.shape = new cjs.Shape();
	this.shape.graphics.f("#0000FF").s().p("AmEGFIAAsJIMJAAIAAMJg");
	this.shape.setTransform(39,39);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#0000FF").s().p("AmAAJQgEi+AAjCQC8gFDAgEQC+gEDCAAQAFC8AEDAQAEC+AADCIAAAAQi8AFjAAEQi+AEjCAAQgFi8gEjAg");
	this.shape_1.setTransform(38.9,38.9);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f("#0000FF").s().p("Al8ASQgIi7AAjAQC1gMC+gHQC7gIDAAAQAMC1AHC9QAIC8AADAIAAAAQi1AMi9AHQi8AIjAAAQgMi1gHi+g");
	this.shape_2.setTransform(38.9,38.8);

	this.shape_3 = new cjs.Shape();
	this.shape_3.graphics.f("#0000FF").s().p("Al4AcQgMi4AAjAQCvgRC6gLQC5gMC/AAQARCvALC6QAMC4AADAIAAAAQiuARi7ALQi4AMjAAAQgRivgLi6g");
	this.shape_3.setTransform(38.9,38.8);

	this.shape_4 = new cjs.Shape();
	this.shape_4.graphics.f("#0000FF").s().p("Al1AlQgPi1AAi+QCogXC4gQQC2gPC9AAQAXCoAPC3QAQC2AAC+IAAAAQinAXi4APQi2AQi+AAQgXiogQi4g");
	this.shape_4.setTransform(38.8,38.7);

	this.shape_5 = new cjs.Shape();
	this.shape_5.graphics.f("#0000FF").s().p("AlxAvQgTizAAi9QChgcC1gUQCzgTC9AAQAcChAUC1QATCzAAC9IAAAAQihAci1AUQizATi9AAQgcihgUi1g");
	this.shape_5.setTransform(38.8,38.6);

	this.shape_6 = new cjs.Shape();
	this.shape_6.graphics.f("#0000FF").s().p("AltA4QgXiwAAi8QCaghCzgYQCwgXC8AAQAhCaAYCyQAXCxAAC7IAAABQiaAhiyAYQixAXi8AAQghiagYizg");
	this.shape_6.setTransform(38.8,38.6);

	this.shape_7 = new cjs.Shape();
	this.shape_7.graphics.f("#0000FF").s().p("AlpBCQgbitAAi7QCUgnCvgcQCugbC6AAQAnCUAcCvQAbCtAAC7IAAAAQiTAniwAcQitAbi7AAQgniUgcivg");
	this.shape_7.setTransform(38.7,38.5);

	this.shape_8 = new cjs.Shape();
	this.shape_8.graphics.f("#0000FF").s().p("AllBLQgfiqAAi6QCNgsCtggQCqgfC6AAQAsCNAgCsQAfCrAAC5IAAABQiNAsisAgQirAfi6AAQgsiNggitg");
	this.shape_8.setTransform(38.7,38.4);

	this.shape_9 = new cjs.Shape();
	this.shape_9.graphics.f("#0000FF").s().p("AlhBVQgjioAAi4QCGgyCqgkQCogjC4AAQAyCGAkCqQAjCoAAC4IAAAAQiGAyiqAkQioAji4AAQgyiGgkiqg");
	this.shape_9.setTransform(38.7,38.3);

	this.shape_10 = new cjs.Shape();
	this.shape_10.graphics.f("#0000FF").s().p("AldBeQgnikAAi4QB/g4CngnQCmgnC3AAQA4B/AnCnQAnClAAC4IAAAAQh/A4inAnQilAni4AAQg4h/gniog");
	this.shape_10.setTransform(38.6,38.3);

	this.shape_11 = new cjs.Shape();
	this.shape_11.graphics.f("#0000FF").s().p("AlZBoQgriiAAi2QB5g+CkgrQCigrC2AAQA+B5ArCkQArCiAAC2IAAAAQh4A+ilArQiiAri2AAQg+h5grikg");
	this.shape_11.setTransform(38.6,38.2);

	this.shape_12 = new cjs.Shape();
	this.shape_12.graphics.f("#0000FF").s().p("AlVBxQgvifAAi1QByhDChgvQCggvC1AAQBDByAvChQAvCgAAC1IAAAAQhyBDihAvQigAvi1AAQhDhygviig");
	this.shape_12.setTransform(38.6,38.1);

	this.shape_13 = new cjs.Shape();
	this.shape_13.graphics.f("#0000FF").s().p("AlRB7QgzidAAi0QBrhICfgzQCdgzC0AAQBIBrAzCfQAzCdAACzIAAABQhrBIifAzQidAzi0AAQhIhrgzifg");
	this.shape_13.setTransform(38.5,38.1);

	this.shape_14 = new cjs.Shape();
	this.shape_14.graphics.f("#0000FF").s().p("AlNCEQg3iZAAizQBkhOCcg3QCbg3CyAAQBOBkA3CcQA3CaAACzIAAAAQhkBOicA3QiaA3izAAQhOhkg3idg");
	this.shape_14.setTransform(38.5,38);

	this.shape_15 = new cjs.Shape();
	this.shape_15.graphics.f("#0000FF").s().p("AlJCOQg7iXAAiyQBehTCZg7QCXg7CyAAQBTBeA7CZQA7CXAACxIAAABQheBTiZA7QiXA7iyAAQhTheg7iZg");
	this.shape_15.setTransform(38.5,37.9);

	this.shape_16 = new cjs.Shape();
	this.shape_16.graphics.f("#0000FF").s().p("AlFCXQg/iWAAiuQBXhZCWg/QCXg/CuAAQBZBXA/CWQA/CXAACuIAAAAQhXBZiWA/QiXA/iuAAQhZhXg/iXg");
	this.shape_16.setTransform(38.4,37.9);

	this.shape_17 = new cjs.Shape();
	this.shape_17.graphics.f("#0000FF").s().p("AlCChQhCiTAAiuQBQheCUhEQCUhCCtAAQBeBQBDCUQBDCTAACtIAAABQhQBeiUBDQiTBDiuAAQhehQhEiUg");
	this.shape_17.setTransform(38.4,37.8);

	this.shape_18 = new cjs.Shape();
	this.shape_18.graphics.f("#0000FF").s().p("Ak+CqQhGiQAAisQBKhlCQhHQCRhGCsAAQBlBKBGCQQBHCRAACsIAAAAQhJBliRBGQiRBHisAAQhlhKhHiRg");
	this.shape_18.setTransform(38.4,37.7);

	this.shape_19 = new cjs.Shape();
	this.shape_19.graphics.f("#0000FF").s().p("Ak6C0QhKiOAAirQBDhqCOhLQCOhKCrAAQBqBDBKCOQBLCOAACqIAAABQhDBqiOBKQiOBLirAAQhqhDhLiOg");
	this.shape_19.setTransform(38.3,37.6);

	this.shape_20 = new cjs.Shape();
	this.shape_20.graphics.f("#0000FF").s().p("Ak2C9QhOiLAAipQA8hwCLhPQCMhOCpAAQBwA8BOCLQBPCMAACpIAAAAQg8BwiLBOQiMBPipAAQhwg8hPiMg");
	this.shape_20.setTransform(38.3,37.6);

	this.shape_21 = new cjs.Shape();
	this.shape_21.graphics.f("#0000FF").s().p("AkyDHQhSiIAAipQA1h1CJhTQCIhSCpAAQB1A1BTCJQBSCIAACoIAAABQg1B1iJBTQiIBSipAAQh1g1hTiJg");
	this.shape_21.setTransform(38.3,37.5);

	this.shape_22 = new cjs.Shape();
	this.shape_22.graphics.f("#0000FF").s().p("AkuDQQhWiFAAioQAvh6CFhXQCGhWCoAAQB6AvBXCFQBWCGAACnIAAABQgvB6iFBXQiGBWioAAQh6gvhXiGg");
	this.shape_22.setTransform(38.2,37.4);

	this.shape_23 = new cjs.Shape();
	this.shape_23.graphics.f("#0000FF").s().p("AkqDaQhaiDAAimQAoiACDhbQCDhaCmAAQCAAoBbCDQBaCDAAClIAAABQgoCAiDBbQiDBaimAAQiAgohbiDg");
	this.shape_23.setTransform(38.2,37.4);

	this.shape_24 = new cjs.Shape();
	this.shape_24.graphics.f("#0000FF").s().p("AkmDjQheh/AAimQAhiFCAhfQCBheClAAQCFAhBfCAQBeCAAAClIAAABQghCFiABfQiABeimAAQiFghhfiBg");
	this.shape_24.setTransform(38.2,37.3);

	this.shape_25 = new cjs.Shape();
	this.shape_25.graphics.f("#0000FF").s().p("AkiDtQhih9AAikQAaiLB+hjQB9hiCkAAQCLAaBjB+QBiB9AACjIAAABQgaCLh+BjQh9BiikAAQiLgahjh+g");
	this.shape_25.setTransform(38.1,37.2);

	this.shape_26 = new cjs.Shape();
	this.shape_26.graphics.f("#0000FF").s().p("AkeD2Qhmh6AAijQAUiRB6hmQB7hmCjAAQCRAUBmB6QBmB7AACiIAAABQgUCRh6BmQh7BmijAAQiRgUhmh7g");
	this.shape_26.setTransform(38.1,37.2);

	this.shape_27 = new cjs.Shape();
	this.shape_27.graphics.f("#0000FF").s().p("AkaEAQhqh4AAihQANiXB4hqQB4hqChAAQCXANBqB4QBqB4AACgIAAABQgNCXh4BqQh4BqihAAQiXgNhqh4g");
	this.shape_27.setTransform(38.1,37.1);

	this.shape_28 = new cjs.Shape();
	this.shape_28.graphics.f("#0000FF").s().p("AkWEJQhuh0AAihQAGicB1huQB1huChAAQCcAGBuB1QBuB1AACgIAAABQgGCch1BuQh1BuihAAQicgGhuh2g");
	this.shape_28.setTransform(38,37);

	this.shape_29 = new cjs.Shape();
	this.shape_29.graphics.f("#0000FF").s().p("AkSETQhzhyABihQgBigBzhyQByhzCgAAQChAAByBzQBzByAACgQAAChhzByQhyByihABQiggBhyhyg");
	this.shape_29.setTransform(38,37);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape}]}).to({state:[{t:this.shape_1}]},1).to({state:[{t:this.shape_2}]},1).to({state:[{t:this.shape_3}]},1).to({state:[{t:this.shape_4}]},1).to({state:[{t:this.shape_5}]},1).to({state:[{t:this.shape_6}]},1).to({state:[{t:this.shape_7}]},1).to({state:[{t:this.shape_8}]},1).to({state:[{t:this.shape_9}]},1).to({state:[{t:this.shape_10}]},1).to({state:[{t:this.shape_11}]},1).to({state:[{t:this.shape_12}]},1).to({state:[{t:this.shape_13}]},1).to({state:[{t:this.shape_14}]},1).to({state:[{t:this.shape_15}]},1).to({state:[{t:this.shape_16}]},1).to({state:[{t:this.shape_17}]},1).to({state:[{t:this.shape_18}]},1).to({state:[{t:this.shape_19}]},1).to({state:[{t:this.shape_20}]},1).to({state:[{t:this.shape_21}]},1).to({state:[{t:this.shape_22}]},1).to({state:[{t:this.shape_23}]},1).to({state:[{t:this.shape_24}]},1).to({state:[{t:this.shape_25}]},1).to({state:[{t:this.shape_26}]},1).to({state:[{t:this.shape_27}]},1).to({state:[{t:this.shape_28}]},1).to({state:[{t:this.shape_29}]},1).wait(1));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(-0.9,-1.9,78.9,80);

})(lib = lib||{}, images = images||{}, createjs = createjs||{});
var lib, images, createjs;