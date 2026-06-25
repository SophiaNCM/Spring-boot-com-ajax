//O numero da pagina começa no zero porque a pagina inicial é 0
var pageNumber = 0;

//Ao abrir a pagina vamos esconder o load e o texto ao final da 
$(document).ready(function(){
	$("#loader-img").hide();
	$("#fim-btn").hide();
});

//efeito infinite scroll
$(window).scroll(function(){
	var scrollTop = $(this).scrollTop();
	var conteudo = $(document).height() - $(window).height();
	console.log('scrollTop:', scrollTop, ' | ', 'conteudo', conteudo);
	//Quando o scroll chegar no final da pagina, o pageNumber vai para o proximo numero
	if(scrollTop>= conteudo){
		pageNumber++;
		//Função de tempo
		setTimeout(function(){
			loadByScrollBar(pageNumber);
		}, 200);
	}
});
//Fução para mudar de pagina
function loadByScrollBar(pageNumber){
	//função ajax
	$.ajax({
		//Metodo GET, pois quando o usuario chegar ao final da promo-list, ele será redirecionado para a url promocao/list/ajax/pageNumber 
		method: "GET",
		url: "/promocao/list/ajax",
		data: {
			page: pageNumber
		},
		//Antes de adicionar os proximos 8 card a imagem de load sera mostrada
		beforeSend: function(){
			$("loader-img").show();
		},
		//mensagem de sucesso no console
		//esse response é a lista de promocao
		sucess: function(response){
			
			//Se o tamanho for maior que 150(se ainda existir card para mostrar), ele mostrara os cards
			if(response.length > 150){
			
				//a div com class row (a primeira div do promo-card) vai receber uma função de adicionar 8 cards 
				$(".row").fadeIn(250, function(){
					$(this).append(response);
				});
			} 
			//caso não tenha, o botão de fim sera mostrado
			else{
				$("#fim-btn").show();
				//a imagem de load esta sendo removida porque não existe card para carregar
				$("loader-img").remove();
			}
		},
		//caso aconteça um erro
		error:function(xhr){
			alert("Ops, ocorreu um erro: " + xhr.status + " - " + xhr.statusText);
		},
		//Ao carregar os 8 cards a imagem de load ser escondida de novo
		complete: function(){
			$("loader-img").hide();
		}
	})
}