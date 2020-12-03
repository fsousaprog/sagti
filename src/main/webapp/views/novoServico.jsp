<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

			<!-- Conteudo da Pagina -->
			<div class="right_col" role="main">
				<div class="page-title">
					<div class="title_left">
						<h3>Novo Servi�o</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<!-- Barra informativa no topo da p�gina -->
					<c:if test="${retorno != null}">
						<label class="col-lg-12 alert-info">${retorno}</label>
					</c:if>
					<div class="x_panel">
						<div class="x_content">
							<form class="form-horizontal form-label-left"
								action="/inserirServico" method="post">

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="nome">Nome *</label>
									<div class="col-xs-3">
										<input type="text" id="nome" name="nome" required="required"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

								<div class="form-group">
									<label for="companhia"
										class="control-label col-md-3 col-sm-3 col-xs-12">Companhia
										ID</label>
									<div class="col-xs-3">
										<input type="text" class="textfield form-control"
											id="companhiaID" name="companhiaID"
											onkeypress="return isNumber(event)" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Descri��o</label>
									<div class="col-xs-6">
										<textarea class="resizable_textarea form-control"
											placeholder="" name="descricao"></textarea>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="tipo">Tipo </label>
									<div class="col-xs-3">
										<input type="text" id="tipo" name="tipo"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="categoria">Categoria </label>
									<div class="col-xs-3">
										<input type="text" id="categoria" name="categoria"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="area">Area</label>
									<div class="col-xs-3">
										<input type="text" id="area" name="area"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

								<div class="ln_solid"></div>
								<div class="form-group">
									<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
										<button class="btn btn-primary" type="reset">Limpar</button>
										<button type="submit" class="btn btn-success">Criar</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Conteudo da Pagina -->

	<!-- Conteudo do Rodape -->

	<footer>
		<div class="pull-right">Sistema de Apoio � Governan�a de TI -
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

	<script>
		function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		        return false;
		    }
		    return true;
		}
	</script>

</body>
</html>

