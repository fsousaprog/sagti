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

			<!-- Conteúdo da Página -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Novo Usuário</h3>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row">
						<!-- Barra informativa no topo da página -->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<c:if test="${retorno != null}">
								<label class="col-lg-12 alert-info">${retorno}</label>
							</c:if>
							<div class="x_panel">
								<div class="x_title">

									<form class="form-horizontal form-label-left"
										action="/inserirUsuario" method="post">

										<!-- Login -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm3 col-xs-12"
												for="name">Login <span class="required">*</span>
											</label>
											<div class="col-xs-2">
												<input id="login" name="login" required="required"
													class="form-control col-md-7 col-xs-12">
											</div>
										</div>

										<!-- Senha -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm3 col-xs-12"
												for="name">Senha <span class="required">*</span>
											</label>
											<div class="col-xs-2">
												<input id="senha" name="senha" type="password"
													required="required" class="form-control col-md-7 col-xs-12">
											</div>
										</div>

										<!-- Nome -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Nome <span class="required">*</span>
											</label>
											<div class="col-xs-3">
												<input id="nome" class="form-control col-md-7 col-xs-12"
													name="nome" required="required" type="text">
											</div>
										</div>

										<!-- Nivel de Acesso -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Nível de Acesso <span class="required">*</span>
											</label>
											<div class="col-xs-1">
												<input type="text" name="nivelAcesso" required="required"
													class="form-control col-md-7 col-xs-12" data-inputmask="99">
											</div>
										</div>

										<!-- Cargo -->
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="occupation">Cargo <span class="required">*</span>
											</label>
											<div class="col-xs-2">
												<input id="cargo" type="text" name="cargo"
													required="required"
													class="optional form-control col-md-7 col-xs-12">
											</div>
										</div>

										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button class="btn btn-primary" type="reset">Limpar</button>
												<button type="submit" class="btn btn-success">Cadastrar</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Conteúdo da Página -->

			<!-- Conteúdo do Rodapé -->
			<footer>
				<div class="pull-right">Sistema de Apoio à Governança de TI -
					Desenvolvido por Grupo 2 - PUCSP</div>
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

	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>

</body>
</html>