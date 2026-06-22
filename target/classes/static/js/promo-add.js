//submit do formulario para o controller
// #form-add-promo é o id do formulario
$("#form-add-promo").submit(function(evt){
	//bloquer o comportamento padrão do submit
	evt.preventDefault();
	
	//Pegando as infos escritas nos inputs do formulario
	var promo = {};
	//Recuperando o valor do link da promoção
	promo.link_promocao = $("#link_promocao").val();
	//Recuperando o valor da descrição
	promo.descricao = $("#descricao").val();
	//Recuperando o valor do preço
	promo.preco = $("#preco").val();
	//Recuperando o valor do titulo
	promo.titulo = $("#titulo").val();
	promo.categoria = $("#categoria").val();
	//Queremos somente recuperar o valor da url e não setar
	promo.link_imagem = $("#link_imagem").attr("src");
	//Recuperando o texto do site
	promo.site_promocao = $("#site_promocao").text();
	
	// o objeto será informado no terminal para testes
	console.log('promo >', promo);
	
	$.ajax({
		// com o ajax, vamos informar que as informações coletadas serão postadas
		method: "POST",
		//Metodo do controller
		url: "/promocao/save",
		//o obejto com os dados 
		data: promo,
		beforeSend: function(){
			//removendo as mensagens de erro
			$("span").closest('.error-span').remove();
			
			//remover as bordas vermelhas
			$("#categoria").removeClass("is-invalid");
			$("#preco").removeClass("is-invalid");
			$("#link_promocao").removeClass("is-invalid");
			$("#titulo").removeClass("is-invalid");
			
			//habilita o loading
			$("#form-add-promo").hide();
			$("#loader-form").addClass("loader").show();
		},
		//caso dê certo, essa classe será adicionada ao css
		success: function(){
			//vai resetar todos os campos depois de salvar um objeto
			$("#form-add-promo").each(function(){
				this.reset();
			});
			$("#link_imagem").attr("src", "/images/promo-dark.png");
			$("#site").text("");
			
			//remove o alerta de erro se tiver e adiciona o alerta de confirmado
			$("#alert").removeClass("alert alert-danger").addClass("alert alert-success").text("OK! Promoção cadastrada com sucesso");
			
		},
		//Aqui esta o ultimo passo da verificação, mostrar o erro na view
		statusCode:{
			422: function(xhr){
				// mostrar o erro no terminal para o dev
				console.log('status error:', xhr.status);
				//colocando o erro em uma variavel
				var errors = $.parseJSON(xhr.responseText);
				//verifica a chave e o valor do erro
				$.each(errors, function(key, val){
					$("#" + key).addClass("is-invalid");
					//mostra o erro de baixo do campo 
					$("#error-"+key).addClass("invalid-feedback").append("<span class='error-span'>" + val + "</span>")
				});
			}
		},
		//caso dê errado, essa classe será adicionada ao css
		error: function(xhr){
			console.log("> error:", xhr.responseText);
			$("#alert").addClass("alert alert danger").text("Não foi possível salvar esta promoção")
		},
		complete: function(){
			$("#loader-form").fadeOut(800, function(){
				$("#form-add-promo").fadeIn(250);
				$("#loader-form").removeClass("loader");
			});
		}
	});
});

//Função para capturar as meta tags
// linkPromocao é o id presente no promo-add
$("#link_promocao").on('change', function(){
	// valor presente no input da url
	var url = $(this).val();
	//url deve ter no minimo 7 letras
	if(url.length > 7){
		//ajax
		$.ajax({
			//metodo usado
			method:"POST",
			//Request/Post/url inserida no input
			url:"/meta/info?url=" + url,
			cache: false,
			//antes de capturar as informações, ele limpa a pesquisa antiga
			beforeSend: function(){
				$("#alert").removeClass("alert alert-danger").text("");
				$("#titulo").val("");
				$("#site_promocao").text("");
				//A imagem esta vazia para que o loading possa aparecer
				$("#link_imagem").attr("src","");
				//imagem de carregamento
				$("#loader-img").addClass("loader");
			},
			//caso dê certo
			success: function(data){
				//Mostra as informações obtidas no console 
				console.log(data);
				//Mostra as informações no input 
				$("#titulo").val(data.title);
				$("#site_promocao").text(data.site);
				$("#link_imagem").attr("src", data.image);
			},
			//Caso dê algum erro
			statusCode: {
				404: function(){
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa url")
					//imagem padrão caso tenha erro
					$("#link_imagem").attr("src","/images/promo-dark.png");
				}
			},
			error: function(){
				$("#alert").addClass("alert alert-danger").text("Algo deu errado, tente mais tarde!")
				$("#link_imagem").attr("src","/images/promo-dark.png");
			},
			complete: function(){
				$("#loader-img").removeClass("loader");
			}
		});
	}
});