<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sagti</title>

</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">

				<div class="navbar nav_title" style="border: 0;">
					<a href="/views/home.jsp" class="site_title"><i class="fa fa-gears"></i>
						<span>SAGTI</span></a>

					<div class="clearfix"></div>

					<!-- Menu da Barra Lateral -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<ul class="nav side-menu">
								<li><a href="/views/home.jsp"><i class="fa fa-home"></i>
										Home </a></li>

								<li><a><i class="fa fa-exclamation-circle"></i>
										Incidente <span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/views/novoIncidente.jsp">Novo Incidente</a></li>
										<li><a href="/buscarIncidente">Buscar Incidente</a></li>

									</ul></li>

								<li><a><i class="fa fa-cog"></i> Problema <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/views/novoProblema.jsp">Novo Problema</a></li>
										<li><a href="/buscarProblema">Buscar Problema</a></li>

									</ul></li>

								<li><a><i class="fa fa-user"></i> Usuário <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/views/novoUsuario.jsp">Novo Usuário</a></li>
										<li><a href="/buscarUsuario">Buscar Usuário</a></li>

									</ul></li>

								<li><a><i class="fa fa-wrench"></i> Serviço <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/views/novoServico.jsp">Novo Serviço</a></li>
										<li><a href="/buscarServico">Buscar Serviço</a></li>

									</ul></li>

								<li><a><i class="fa fa-laptop"></i> Companhia <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/views/novaCompanhia.jsp">Nova Companhia</a></li>
										<li><a href="/buscarCompanhia">Buscar Companhia</a></li>

									</ul></li>

								<li><a><i class="fa fa-file-pdf-o"></i> Relatório <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/gerarRelatoriosIncidente"> Incidente </a></li>
										<li><a href="/gerarRelatoriosProblema"> Problema </a></li>
										<li><a href="/gerarLog"> Log do sistema</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /Menu da Barra Lateral -->

	<!-- Botões do rodapé do menu -->
	<div class="sidebar-footer hidden-small">
		<a data-toggle="tooltip" data-placement="top" title="Configurações"
			href="/configuracoes">
			<span class="glyphicon glyphicon-cog" aria-hidden="true"></span> </a> 
		<a data-toggle="tooltip" data-placement="top" title="Perfil" href="/perfil"> 
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span> </a> 
		<a data-toggle="tooltip" data-placement="top" title="Sobre"
			href="/views/sobre.jsp"> <span class="glyphicon glyphicon-info-sign"
			aria-hidden="true"></span> </a> 
		<a data-toggle="tooltip" data-placement="top" title="Sair"
			href="logout"> <span class="glyphicon glyphicon-off"
			aria-hidden="true"></span>
		</a>
	</div>
	<!-- /Botões do rodapé do menu -->

</body>
</html>