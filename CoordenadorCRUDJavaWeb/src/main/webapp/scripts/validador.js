/**
 * @author Leonardo Britto
 */

 function validar(){
	 let nome = frmCoord.nome.value;
	 
	 if(nome == ""){
		 alert('Prencha o campo nome');
		 console.log('Prencha o campo nome');
		 frmCoord.nome.focus();
		 return false;
	 }else {
		 alert('Sucesso');
		 console.log('Sucesso');
	 }
	 
}