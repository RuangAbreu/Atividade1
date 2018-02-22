import java.util.*;
public class Atividade1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String nome = "";
		System.out.printf("Nome do funcionario : \n");
		nome = input.next();
		float hora;		
		System.out.printf("Nomero de horas trabalhadas :\n");
		nome = input.nextFloat();
		float valor;
		System.out.printf("Valor por hora trabalhada :\n");
		valor = input.nextFloat();
		float result;
		result = horas*valor;
		System.out.printf("\nFuncionario "+nome+" receberá R$"+result+" pelas "+horas+" horas trabalhadas");
	}
}