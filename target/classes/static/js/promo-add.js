//Função para capturar as meta tags

// linkPromocao é o id presente no promo-add
$("#linkPromocao").on('change', function(){
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
				$("site").text("");
				$("#linkImagem").attr("src","/images/promo-dark.png");
			},
			//caso dê certo
			suceess: function(data){
				//Mostra as informações obtidas no console 
				console.log(data);
				//Mostra as informações no input 
				$("#titulo").val(data.title);
				$("#site").text(data.site);
				$("linkImagem").attr("src", data.image);
			},
			//Caso dê algum erro
			statusCode: {
				404: function(){
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa url")
				}
			},
			error: function(){
				$("#alert").addClass("alert alert-danger").text("Algo deu errado, tente mais tarde!")
			}
		})
	}
})