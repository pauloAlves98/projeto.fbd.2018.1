package br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;

public class TratadorDeMascara {
	public static Date coletorDeData(String nas) throws ValidacaoException{
		String []data = nas.split("/");
		Calendar c = Calendar.getInstance();
		try {
			int dia = Integer.parseInt(data[0]);
			int mes = Integer.parseInt(data[1]);
			int ano = Integer.parseInt(data[2]);
			c.set(Calendar.DAY_OF_MONTH,dia);
			c.set(Calendar.MONTH,mes-1);
			c.set(Calendar.YEAR,ano);
			System.out.println("Data:"+c.getTime());
			return c.getTime();
		}catch(NumberFormatException e) {
			//lan�ar valida��o exception
			throw new ValidacaoException("Erro ao validar data!!!");
		}
		catch(InputMismatchException e) {
			//lan�ar valida��o exception
			throw new ValidacaoException("Erro ao validar data!!!");
		}
	}
	/**
	 * @param:CPF sem a mascara*/
	public static boolean isCPF(String CPF) throws ValidacaoException {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
		        CPF.equals("22222222222") || CPF.equals("33333333333") ||
		        CPF.equals("44444444444") || CPF.equals("55555555555") ||
		        CPF.equals("66666666666") || CPF.equals("77777777777") ||
		        CPF.equals("88888888888") || CPF.equals("99999999999") ||
		       (CPF.length() != 11)) {
		    	throw new ValidacaoException("CPF Inv�lido");
		    }
		 
		    char dig10, dig11;
		    int sm, i, r, num, peso;
		 
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		    try {
		// Calculo do 1o. Digito Verificador
		      sm = 0;
		      peso = 10;
		      for (i=0; i<9; i++) {              
		// converte o i-esimo caractere do CPF em um numero:
		// por exemplo, transforma o caractere '0' no inteiro 0         
		// (48 eh a posicao de '0' na tabela ASCII)         
		        num = CPF.charAt(i) - 48; 
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		 
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig10 = '0';
		      else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
		 
		// Calculo do 2o. Digito Verificador
		      sm = 0;
		      peso = 11;
		      for(i=0; i<10; i++) {
		        num = CPF.charAt(i) - 48;
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		 
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig11 = '0';
		      else dig11 = (char)(r + 48);
		 
		// Verifica se os digitos calculados conferem com os digitos informados.
		      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		         return(true);
		      else throw new ValidacaoException("CPF Inv�lido");
		    } catch (InputMismatchException erro) {
		    	throw new ValidacaoException("CPF Inv�lido");
		    }
		  }
	public static void validaRg(String rg) throws ValidacaoException {
		if(rg.length() !=9)
			throw new ValidacaoException("RG Inv�lido");
	}
//	 public static Boolean ValidaCep(string cep)
//     {
//         if (cep.Length == 8)
//         {
//             cep = cep.Substring(0, 5) + "-" + cep.Substring(5, 3);
//             //txt.Text = cep;
//         }
//         return System.Text.RegularExpressions.Regex.IsMatch(cep, ("[0-9]{5}-[0-9]{3}"));
//     }
}
