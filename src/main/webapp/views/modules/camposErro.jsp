<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Status -->
<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">Status<span
		class="required">*</span>
	</label>
	<div class="col-xs-3">
		<input type="text" id="status" name="status" required="required"
			class="form-control col-md-7 col-xs-12" value="${erro.status}">
	</div>
</div>

<!-- CompanhiaID -->
<div class="form-group">
	<label for="companhia"
		class="control-label col-md-3 col-sm-3 col-xs-12">Companhia ID</label>
	<div class="col-xs-3">
		<input type="text" class="textfield form-control" id="companhiaID"
			name="companhiaID" value="${erro.companhiaID}"
			onkeypress="return isNumber(event)" />
	</div>
</div>

<!-- Categoria -->
<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">Categoria
	</label>
	<div class="col-xs-3">
		<input type="text" id="status" name="categoria"
			class="form-control col-md-7 col-xs-12" value="${erro.categoria}">
	</div>
</div>

<!-- Impacto -->
<div class="form-group">
	<label for="impacto" class="col-xs-3 control-label">Impacto<span
		class="required">*</span></label>
	<div class="col-xs-3 selectContainer">
		<c:if test="${erro.impacto == 'Alto'}">
			<c:set var="alto" value="selected" />
			<c:set var="medio" value="" />
			<c:set var="baixo" value="" />
		</c:if>
		<c:if test="${erro.impacto == 'Médio'}">
			<c:set var="alto" value="" />
			<c:set var="medio" value="selected" />
			<c:set var="baixo" value="" />
		</c:if>
		<c:if test="${erro.impacto == 'Baixo'}">
			<c:set var="alto" value="" />
			<c:set var="medio" value="" />
			<c:set var="baixo" value="selected" />
		</c:if>
		<select id="impacto" class="form-control" name="impacto">
			<option value="Alto" selected="${alto}">Alto</option>
			<option value="Médio" selected="${medio}">Médio</option>
			<option value="Baixo" selected="${baixo}">Baixo</option>
		</select>
	</div>
</div>

<!-- Urgência -->
<div class="form-group">
	<label for="urgencia" class="col-xs-3 control-label">Urgência<span
		class="required">*</span></label>
	<div class="col-xs-3 selectContainer">
		<c:if test="${erro.urgencia == 'Altissima'}">
			<c:set var="altissima" value="selected" />
			<c:set var="alta" value="" />
			<c:set var="media" value="" />
			<c:set var="baixa" value="" />
			<c:set var="baixissima" value="" />
		</c:if>
		<c:if test="${erro.urgencia == 'Alta'}">
			<c:set var="altissima" value="" />
			<c:set var="alta" value="selected" />
			<c:set var="media" value="" />
			<c:set var="baixa" value="" />
			<c:set var="baixissima" value="" />
		</c:if>
		<c:if test="${erro.urgencia == 'Média'}">
			<c:set var="altissima" value="" />
			<c:set var="alta" value="" />
			<c:set var="media" value="selected" />
			<c:set var="baixa" value="" />
			<c:set var="baixissima" value="" />
		</c:if>
		<c:if test="${erro.urgencia == 'Baixa'}">
			<c:set var="altissima" value="" />
			<c:set var="alta" value="" />
			<c:set var="media" value="" />
			<c:set var="baixa" value="selected" />
			<c:set var="baixissima" value="" />
		</c:if>
		<c:if test="${erro.urgencia == 'Baixissima'}">
			<c:set var="altissima" value="" />
			<c:set var="alta" value="" />
			<c:set var="media" value="" />
			<c:set var="baixa" value="" />
			<c:set var="baixissima" value="selected" />
		</c:if>
		<select id="urgencia" class="form-control" name="urgencia">
			<option value="Altissima" selected="${altissima}">Altissima</option>
			<option value="Alta" selected="${alta}">Alta</option>
			<option value="Média" selected="${media}">Média</option>
			<option value="Baixa" selected="${baixa}">Baixa</option>
			<option value="Baixissima" selected="${baixissima}">Baixissima</option>
		</select>
	</div>
</div>

<!-- Prioridade -->
<div class="form-group">
	<label for="prioridade" class="col-xs-3 control-label">Prioridade<span
		class="required">*</span></label>
	<div class="col-xs-3 selectContainer">
		<c:if test="${erro.prioridade == 'Alta'}">
			<c:set var="alta" value="selected" />
			<c:set var="media" value="" />
			<c:set var="baixa" value="" />
		</c:if>
		<c:if test="${erro.prioridade == 'Média'}">
			<c:set var="alta" value="" />
			<c:set var="media" value="selected" />
			<c:set var="baixa" value="" />
		</c:if>
		<c:if test="${erro.prioridade == 'Baixa'}">
			<c:set var="alta" value="" />
			<c:set var="media" value="" />
			<c:set var="baixa" value="selected" />
		</c:if>
		<select id="prioridade" class="form-control" name="prioridade">
			<option value="Alta" selected="${alta}">Alta</option>
			<option value="Média" selected="${media}">Média</option>
			<option value="Baixa" selected="${baixa}">Baixa</option>
		</select>
	</div>
</div>

<!-- Título -->
<div class="form-group">
	<label for="titulo" class="control-label col-md-3 col-sm-3 col-xs-12">Título<span
		class="required">*</span>
	</label>
	<div class="col-xs-4">
		<input id="titulo" class="form-control col-md-7 col-xs-12" type="text"
			name="titulo" required="required" value="${erro.titulo}">
	</div>
</div>

<!-- Descrição -->
<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12">Descrição</label>
	<div class="col-xs-6">
		<textarea class="resizable_textarea form-control" placeholder=""
			name="descricao">${erro.descricao}</textarea>
	</div>
</div>

<!-- Solução -->
<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12">Solução</label>
	<div class="col-xs-6">
		<textarea class="resizable_textarea form-control" placeholder=""
			name="solucao">${erro.solucao}</textarea>
	</div>
</div>

<!-- DataSolução -->
<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-3">Data
		Solução</label>
	<div class="col-xs-5 date">
		<div class="col-xs-4">
			<input type="text" class="form-control" name="dataSolucao"
				data-inputmask="'mask': '99/99/9999'" value="${erro.dataSolucao}" />
		</div>
	</div>
</div>
