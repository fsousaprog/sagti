<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sagti</title>

<!-- Bootstrap -->
<link href="../resource/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../resource/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../resource/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="../resource/iCheck/skins/flat/green.css" rel="stylesheet">

<!-- Estilo de tema personalizado -->
<link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- Menu da Barra Lateral -->
			<jsp:include page="/views/modules/menuLateral.jsp" />
			<!-- /Menu da Barra Lateral -->

			<!-- Conte�do da P�gina -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Relat�rio de Problemas</h3>
						</div>
					</div>
					<div class="clearfix"></div>

					<!-- Hiddens com os JSONs -->
					<div id="statusLabel" style="display: none;">${statusLabel}</div>
					<div id="statusData" style="display: none;">${statusData}</div>
					<div id="categoriasLabel" style="display: none;">${categoriasLabel}</div>
					<div id="categoriasData" style="display: none;">${categoriasData}</div>
					<div id="companhiasLabel" style="display: none;">${companhiasLabel}</div>
					<div id="companhiasData" style="display: none;">${companhiasData}</div>
					<div id="servicosLabel" style="display: none;">${servicosLabel}</div>
					<div id="servicosData" style="display: none;">${servicosData}</div>

					<div class="col-md-12 col-sm-12 col-xs-12">

						<!-- Gr�fico de Pizza de status -->
						<div class="x_panel">
							<div class="x_title" style="font-size: 18px; font-weight: bold;">
								Status
								<div class="clearfix"></div>
							</div>
							<div class="x_content row-fluid">
								<div class="col-lg-6">
									<canvas id="status" width="800" height="400"></canvas>
								</div>
								<!-- Dados gerais para an�lise -->
								<div class="col-lg-6"
									style="font-family: sans-serif; font-size: 16px;">
									<br>
									<br> Total de Problemas: ${problemasQnt} <br> Total
									de Usu�rios: ${usuariosQnt} <br> Total de Companhias:
									${companhiasQnt} <br> <br> Usu�rios por Problemas:
									${usuariosProblemas} <br> <br>
									<div style="font-family: cursive; font-style: italic;">
										<c:if test="${usuariosProblemas <= 0.3}">
											Sua empresa n�o comporta usu�rios suficientes para dar conta da quantidade de problemas ocorrentes.
										</c:if>
										<c:if
											test="${usuariosProblemas > 0.3 && usuariosProblemas <= 0.6}">
											� recomend�vel a adi��o de novos usu�rios para a resolu��o dos problemas ocorrentes � empresa.
										</c:if>
										<c:if
											test="${usuariosProblemas > 0.6 && usuariosProblemas <= 1.5}">
											A quantidade de usu�rios para a solu��o de problemas � o suficiente e adequada.
										</c:if>
										<c:if test="${usuariosProblemas > 1.5}">
											Existem muitos usu�rios para resolu��o de problemas. � recomend�vel apenas um por problema, 
											deixando assim os outros dispon�veis para incidentes que � onde precisa mais.
										</c:if>
									</div>
								</div>
							</div>
							<br> <br>
						</div>

						<!-- Gr�fico de Barras de categorias -->
						<div class="x_panel">
							<div class="x_title" style="font-size: 18px; font-weight: bold;">
								Categorias
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<canvas id="categorias" width="800" height="300"></canvas>
							</div>
							<br> <br>
						</div>

						<!-- Gr�fico de Barras de Companhias -->
						<div class="x_panel">
							<div class="x_title" style="font-size: 18px; font-weight: bold;">
								Companhias
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<canvas id="companhias" width="800" height="300"></canvas>
							</div>
							<br> <br>
						</div>

					</div>
				</div>
			</div>
			<!-- /Conte�do da P�gina -->

			<!-- Conte�do do Rodap� -->
			<footer>
				<div class="pull-right">Sistema de Apoio � Governan�a de TI -
					Desenvolvido por Grupo 2 - PUCSP</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /Conte�do do Rodap� -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="../resource/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../resource/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="../resource/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="../resource/nprogress/nprogress.js"></script>
	<!-- morris.js -->
	<script src="../resource/raphael/raphael.min.js"></script>
	<script src="../resource/morris.js/morris.min.js"></script>
	<!-- ECharts -->
	<script src="../resource/echarts/dist/echarts.min.js"></script>
	<script src="../resource/echarts/map/js/world.js"></script>
	<!-- Chart.js -->
	<script src="../resource/Chart.js/dist/Chart.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>

	<script src="../dist/js/relatorios.js"></script>

</body>
</html>