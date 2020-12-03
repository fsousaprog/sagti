<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sagti</title>

<!-- Bootstrap -->
<link href="/resource/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="/resource/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="/resource/nprogress/nprogress.css" rel="stylesheet">
<!-- Animate.css -->
<link href="/resource/animate.css/animate.min.css" rel="stylesheet">
<!-- Estilo de tema personalizado -->
<link href="/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<c:if test="${param.error != null}">
					<label class="col-lg-12 alert-error">Usuário ou senha
						incorretos!</label>
				</c:if>
				<c:if test="${param.logout != null}">
					<label class="col-lg-12 alert-warning">Você foi
						desconectado</label>
				</c:if>
				<section class="login_content">
					<form name="form-signin" action="/login" method='POST'>
						<h1>Login</h1>
						<div>
							<input type="text" class="form-control"
								placeholder="Nome Usuário" required="required" name="username" />
						</div>
						<div>
							<input type="password" class="form-control" placeholder="Senha"
								required="required" name="password" />
						</div>
						<div>
							<button class="btn btn-default.focus btn-primary" type="submit" >Entrar</button>
						</div>

						<div class="clearfix"></div>
						<div class="separator">
							<div class="clearfix"></div>
							<br />
							<div>
								<h1>
									<i class="fa fa-gears"></i> SAGTI
								</h1>
								<p>
									©2017 Todos os direitos reservados. <br>Sistema de Apoio à
									Governança de TI
								</p>
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>

