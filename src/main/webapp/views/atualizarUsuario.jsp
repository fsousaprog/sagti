<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="charset=UTF-8">
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

<!-- Estilo de tema personalizado -->
<link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<!-- Menu da Barra Lateral -->
			<jsp:include page="/views/modules/menuLateral.jsp" />

			<!-- Conte�do da P�gina -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Atualizar Usu�rio</h3>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<!-- Barra informativa no topo da p�gina -->
							<c:if test="${retorno != null}">
								<label class="col-lg-12 alert-info">${retorno}</label>
							</c:if>
							<div class="x_panel">
								<div class="x_title">

									<form class="form-horizontal form-label-left"
										action="/atualizarUsuario" method="post">

										<div class="item form-group">
											<label class="control-label col-md-3 col-sm3 col-xs-12">ID</label>
											<div class="col-xs-2">
												<input id="id" name="id" required="required" readonly
													class="form-control col-md-7 col-xs-12"
													value="${usuario.id}">
											</div>
										</div>

										<div class="item form-group">
											<label class="control-label col-md-3 col-sm3 col-xs-12">Login
												<span class="required">*</span>
											</label>
											<div class="col-xs-2">
												<input id="login" name="login" required="required"
													value="${usuario.login}"
													class="form-control col-md-7 col-xs-12" readonly>
											</div>
										</div>

										<div class="item form-group">
											<label class="control-label col-md-3 col-sm3 col-xs-12">Senha
												<span class="required">*</span>
											</label>
											<div class="col-xs-2">
												<input id="senha" name="senha" type="password"
													required="required" class="form-control col-md-7 col-xs-12">
											</div>
										</div>

										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Nome
												<span class="required">*</span>
											</label>
											<div class="col-xs-3">
												<input id="nome" class="form-control col-md-7 col-xs-12"
													name="nome" required="required" type="text"
													value="${usuario.nome}">
											</div>
										</div>

										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">N�vel
												de Acesso <span class="required">*</span>
											</label>
											<div class="col-xs-1">
												<input type="text" name="nivelAcesso" required="required"
													value="${usuario.nivelAcesso}"
													class="form-control col-md-7 col-xs-12" data-inputmask="99">
											</div>
										</div>

										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Cargo
												<span class="required">*</span>
											</label>
											<div class="col-xs-2">
												<input id="cargo" type="text" name="cargo"
													required="required" value="${usuario.cargo}"
													class="optional form-control col-md-7 col-xs-12">
											</div>
										</div>

										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">${teste}
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
			<!-- Conte�do da P�gina -->

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

	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>

</body>
</html>