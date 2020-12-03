<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8">
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
<!-- bootstrap-wysiwyg -->
<link href="../resource/google-code-prettify/bin/prettify.min.css"
	rel="stylesheet">
<!-- Select2 -->
<link href="../resource/select2/dist/css/select2.min.css"
	rel="stylesheet">
<!-- Switchery -->
<link href="../resource/switchery/dist/switchery.min.css"
	rel="stylesheet">
<!-- starrr -->
<link href="../resource/starrr/dist/starrr.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="../resource/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Estilo de tema personalizado -->
<link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<!-- Menu da Barra Lateral -->
			<jsp:include page="/views/modules/menuLateral.jsp" />

			<div class="right_col" role="main">
				<div class="page-title">
					<div class="title_left">
						<h3>Log do Sistema</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<h2>${log}</h2>
				</div>

			</div>

		</div>
	</div>
	<!-- Conteudo do Rodape -->

	<footer>
		<div class="pull-right">Sistema de Apoio à Governança de TI -
			Desenvolvido por Grupo 2 - PUCSP</div>
		<div class="clearfix"></div>
	</footer>
	<!-- /Conteudo do Rodape -->

	<!-- jQuery -->
	<script src="../resource/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../resource/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="../resource/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="../resource/nprogress/nprogress.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="../resource/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="../resource/iCheck/icheck.min.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="../resource/moment/min/moment.min.js"></script>
	<script src="../resource/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap-wysiwyg -->
	<script src="../resource/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
	<script src="../resource/jquery.hotkeys/jquery.hotkeys.js"></script>
	<script src="../resource/google-code-prettify/src/prettify.js"></script>
	<!-- jQuery Tags Input -->
	<script src="../resource/jquery.tagsinput/src/jquery.tagsinput.js"></script>
	<!-- jquery.inputmask -->
	<script
		src="../resource/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
	<!-- Switchery -->
	<script src="../resource/switchery/dist/switchery.min.js"></script>
	<!-- Select2 -->
	<script src="../resource/select2/dist/js/select2.full.min.js"></script>
	<!-- Parsley -->
	<script src="../resource/parsleyjs/dist/parsley.min.js"></script>
	<!-- Autosize -->
	<script src="../resource/autosize/dist/autosize.min.js"></script>
	<!-- jQuery autocomplete -->
	<script
		src="../resource/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
	<!-- starrr -->
	<script src="../resource/starrr/dist/starrr.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>
</body>
</html>