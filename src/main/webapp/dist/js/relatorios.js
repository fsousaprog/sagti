/**
 * Javascript dos relatórios
 */

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 16;
var chartOptions = {
	legend : {
		display : true,
		position : 'top',
		labels : {
			boxWidth : 80,
			fontColor : 'black'
		}
	}
};

// STATUS
var canvasStatus = document.getElementById("status");
var statusLabel = document.getElementById("statusLabel").innerText;
var statusData = document.getElementById("statusData").innerText;

function statusColor() {
	var rgbaR = 10;
	var rgbaG = 20;
	var rgbaB = 30;
	var rgbaA = 0.2;
	var color = [];
	for ( var i in statusData.split(", ")) {
		color.push("rgba(" + rgbaR + "," + rgbaG + "," + rgbaB + ", " + rgbaA
				+ ")");
		rgbaR += Math.floor((Math.random() * 60) + 20);
		rgbaG += Math.floor((Math.random() * 60) + 20);
		rgbaB += Math.floor((Math.random() * 60) + 20);
		rgbaA += Math.floor((Math.random() * 10));
	}
	return color;
}
var dataStatus = {
	label : 'Quantidade',
	data : JSON.parse(statusData),
	backgroundColor : statusColor()
};
var pieChart = new Chart(canvasStatus, {
	type : 'pie',
	data : {
		labels : JSON.parse(statusLabel),
		datasets : [ dataStatus ],
		options : chartOptions
	}
});

// CATEGORIAS
var canvasCategorias = document.getElementById("categorias");
var categoriasLabel = document.getElementById("categoriasLabel").innerText;
var categoriasData = document.getElementById("categoriasData").innerText;

function categoriasColor() {
	var rgbaR = 10;
	var rgbaG = 20;
	var rgbaB = 30;
	var rgbaA = 0.2;
	var color = [];
	for ( var i in categoriasData.split(", ")) {
		color.push("rgba(" + rgbaR + "," + rgbaG + "," + rgbaB + ", " + rgbaA
				+ ")");
		rgbaR += Math.floor((Math.random() * 40) + 20);
		rgbaG += Math.floor((Math.random() * 40) + 20);
		rgbaB += Math.floor((Math.random() * 40) + 20);
		rgbaA += Math.floor((Math.random() * 10));
	}
	return color;
}
var dataCategorias = {
	label : 'Quantidade',
	data : JSON.parse(categoriasData),
	backgroundColor : categoriasColor()
};
var barChart = new Chart(canvasCategorias, {
	type : 'bar',
	data : {
		labels : JSON.parse(categoriasLabel),
		datasets : [ dataCategorias ],
		options : chartOptions
	}
});

// COMPANHIAS
var canvasCompanhias = document.getElementById("companhias");
var companhiasLabel = document.getElementById("companhiasLabel").innerText;
var companhiasData = document.getElementById("companhiasData").innerText;

function companhiasColor() {
	var rgbaR = 10;
	var rgbaG = 20;
	var rgbaB = 30;
	var rgbaA = 0.2;
	var color = [];
	for ( var i in companhiasData.split(", ")) {
		color.push("rgba(" + rgbaR + "," + rgbaG + "," + rgbaB + ", " + rgbaA
				+ ")");
		rgbaR += Math.floor((Math.random() * 10) + 10);
		rgbaG += Math.floor((Math.random() * 10) + 10);
		rgbaB += Math.floor((Math.random() * 10) + 10);
		rgbaA += Math.floor((Math.random() * 10));
	}
	return color;
}
var dataCompanhias = {
	label : 'Quantidade',
	data : JSON.parse(companhiasData),
	backgroundColor : companhiasColor()
};
var barChart = new Chart(canvasCompanhias, {
	type : 'bar',
	data : {
		labels : JSON.parse(companhiasLabel),
		datasets : [ dataCompanhias ],
		options : chartOptions
	}
});

// SERVICOS
var canvasServicos = document.getElementById("servicos");
var servicosLabel = document.getElementById("servicosLabel").innerText;
var servicosData = document.getElementById("servicosData").innerText;

function servicosColor() {
	var rgbaR = 10;
	var rgbaG = 20;
	var rgbaB = 30;
	var rgbaA = 0.2;
	var color = [];
	for ( var i in servicosData.split(", ")) {
		color.push("rgba(" + rgbaR + "," + rgbaG + "," + rgbaB + ", " + rgbaA
				+ ")");
		rgbaR += Math.floor((Math.random() * 30) + 10);
		rgbaG += Math.floor((Math.random() * 30) + 10);
		rgbaB += Math.floor((Math.random() * 30) + 10);
		rgbaA += Math.floor((Math.random() * 10));
	}
	return color;
}
var dataServicos = {
	label : 'Quantidade',
	data : JSON.parse(servicosData),
	backgroundColor : servicosColor()
};
var barChart = new Chart(canvasServicos, {
	type : 'bar',
	data : {
		labels : JSON.parse(servicosLabel),
		datasets : [ dataServicos ],
		options : chartOptions
	}
});
