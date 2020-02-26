package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		// Recebe salário bruto e aplica descontos de INSS e IRPF, retornando o salário
		// líquido
		// Para salários abaixo de 1039.00, retornar 0.0
		double salarioDescontoINSS = 0;
		double salarioLiquido = 0;
		
		//Verifica se o salário base é menor que o mínimo de 1039.00
		//Se for, retorna 0 para a função
		//Se não for, calcula os descontos
		if (salarioBase < 1039.00) {
			salarioLiquido = 0.00;
		} else {
			// Aplica desconto INSS
			salarioDescontoINSS = calcularDescontoInss(salarioBase);
	
			// Aplica desconto IRPF
			salarioLiquido = calcularDescontoIrpf(salarioDescontoINSS);
		}

		return Math.round(salarioLiquido);
	}
	 
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	public static double calcularDescontoInss(double salarioBase) {
		// Recebe o valor bruto e aplica o desconto do INSS, seguindo a tabela:
		// Até 1.500,00 --> 8% de desconto
		// De 1.500,01 a 4.000,00 --> 9% de desconto
		// Acima de 4.000,00 --> 11% de desconto
		double aliquota = 0;
		if (salarioBase <= 1500.00) {
			aliquota = 8;
		} else if ((salarioBase > 1500.00) && (salarioBase <= 4000.00)) {
			aliquota = 9;
		} else {
			aliquota = 11;
		}
		return (salarioBase * (1 - (aliquota / 100)));

	}

	public static double calcularDescontoIrpf(double salarioInss) {
		// Recebe o valor com desconto do INSS e aplica o desconto do IRPF, seguindo a
		// tabela:
		// Até 3.000,00 --> ISENTO
		// De 3.000,01 a 6.000,00 --> 7.5% de desconto
		// Acima de 6.000,00 --> 15% de desconto
		double aliquota = 0;
		if (salarioInss <= 3000.00) {
			aliquota = 0;
		} else if ((salarioInss > 3000.00) && (salarioInss <= 6000.00)) {
			aliquota = 7.5;
		} else {
			aliquota = 15;
		}
		return (salarioInss * (1 - (aliquota / 100)));
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/
