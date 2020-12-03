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
<!-- Datatables -->
<link
	href="../resource/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resource/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resource/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resource/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resource/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Estilo de tema personalizado -->
<link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;"></div>

					<!-- Menu da Barra Lateral -->
					<jsp:include page="/views/modules/menuLateral.jsp" />

					<!-- /Menu da Barra Lateral -->
				</div>
			</div>

			<!-- Conteúdo da Página -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Lista de Serviços</h3>
						</div>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<table id="datatable-buttons"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>Companhia</th>
									<th>Tipo</th>
									<th>Editar</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${lista}" var="item">
									<tr>
										<td>${item.id}</td>
										<td>${item.nome}</td>
										<td>${item.companhia.nome}</td>
										<td>${item.tipo}</td>
										<td><a href="/paginaAtualizarServico?id=${item.id}">Editar</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- Conteúdo da Página -->

			<!-- Conteúdo do Rodapé -->
			<footer>
				<div class="pull-right">
					<a> Sistema de Apoio à Governança de TI - Desenvolvido por
						Grupo 2 - PUCSP</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /Conteúdo do Rodapé -->
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
	<!-- iCheck -->
	<script src="../resource/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script src="../resource/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="../resource/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="../resource/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="../resource/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script
		src="../resource/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script
		src="../resource/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script
		src="../resource/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="../resource/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="../resource/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="../resource/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="../resource/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="../resource/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	<script src="../resource/jszip/dist/jszip.min.js"></script>
	<script src="../resource/pdfmake/build/pdfmake.min.js"></script>
	<script src="../resource/pdfmake/build/vfs_fonts.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>

</body>
</html>