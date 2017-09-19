//jQuery post请求
//------------------------------------------------------------------
var url = ""; //请求url
var params = { //请求参数 json格式
	"k1": 1,
	...
};
$.post(url, params, function(data){
	//主要处理函数
});
//------------------------------------------------------------------



//在字符串中出现的js函数中传参
//------------------------------------------------------------------
var data = $("#dataDiv"); //获取对象
data.text(""); //清空dataDiv中的内容
data.append("<tr onclick='func(\""+var1+"\", \""+var2+"\")'><td>"+var3+"</td><td>"+var4+"</td><td>"+var5+"</td></tr>");

function func(v1, v2, v3) {
	//函数体
}
//------------------------------------------------------------------


//日期格式化
//------------------------------------------------------------------
Date.prototype.Format = function (fmt) { 
	var o = {
	"M+": this.getMonth() + 1, //月份 
	"d+": this.getDate(), //日 
	"h+": this.getHours(), //小时 
	"m+": this.getMinutes(), //分 
	"s+": this.getSeconds(), //秒 
	"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	"S": this.getMilliseconds() //毫秒 
	};
	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
	if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

var date = new Date().Format("yyyy-MM-dd hh:mm:ss");
//------------------------------------------------------------------


//百度地图清除标注
//------------------------------------------------------------------
var map = BMap.Map("mapDivId"); 
var overlays = map.getOverlays(); //获取覆盖物数组
for(i = 0; i< overlays.length; i++) {
	if(overlays[i] instanceof BMap.Marker) {
		map.removeOverlay(overlays[i]);
	}
}
//------------------------------------------------------------------