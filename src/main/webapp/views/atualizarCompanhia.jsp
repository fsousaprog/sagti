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
						<h3>Atualizar Companhia</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<!-- Barra informativa no topo da página -->
					<c:if test="${retorno != null}">
						<label class="col-lg-12 alert-info">${retorno}</label>
					</c:if>
					<div class="x_panel">
						<div class="x_content">
							<form class="form-horizontal form-label-left"
								action="/atualizarCompanhia" method="post">

								<div class="item form-group">
									<label class="control-label col-md-3 col-sm3 col-xs-12">ID</label>
									<div class="col-xs-2">
										<input id="id" name="id" required="required" readonly
											class="form-control col-md-7 col-xs-12"
											value="${companhia.id}">
									</div>
								</div>

								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="nome">Nome <span class="required">*</span>
									</label>
									<div class="col-xs-3">
										<input id="nome" class="form-control col-md-7 col-xs-12"
											name="nome" required="required" type="text"
											value="${companhia.nome}">
									</div>
								</div>

								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="name">Nome Fantasia </label>
									<div class="col-xs-3">
										<input id="nomeFantasia"
											class="form-control col-md-7 col-xs-12" name="nomeFantasia"
											type="text" value="${companhia.nomeFantasia}">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-3">Início
										Parceria</label>
									<div class="col-xs-5 date">
										<div class="col-xs-4">
											<input type="text" class="form-control" name="inicioParceria"
												data-inputmask="'mask': '99/99/9999'"
												value="${companhia.inicioParceria}" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Serviços
										(IDs)</label>
									<div class="col-xs-3">
										<input type="text" name="servicos" class="form-control"
											placeholder="123456, 654321, 123654">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Ramo</label>
									<div class="col-xs-3">
										<input name="ramo" class="form-control col-md-7 col-xs-12"
											type="text" value="${companhia.ramo}">
									</div>
								</div>

								<div class="ln_solid"></div>
								<div class="form-group">
									<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
										<button type="submit" class="btn btn-success">Salvar</button>
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

