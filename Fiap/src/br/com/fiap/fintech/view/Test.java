package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        var currentAccountList = new ArrayList<CurrentAccount>();
        var investmentAccountList = new ArrayList<InvestmentAccount>();

        var incomeList = new ArrayList<Income>();
        var outComeList = new ArrayList<OutCome>();

        Scanner sc = new Scanner(System.in);

        int op;
        FintechAccount fintechAccount = new FintechAccount();

        fintechAccount.setUserName("meuUser");
        fintechAccount.setAccountType(2);
        fintechAccount.setName("Guilherme");
        fintechAccount.setLastName("Brenner Bello");
        fintechAccount.setCpf("012.975.450-10");
        fintechAccount.seteMail("guilherme@gbbdesign.com.br");
        fintechAccount.setEndereco(new Address("Rua Odilon Martins de Andrades", 170, "A", "22790-230","Rio de Janeiro","RJ"));

        // Adiciono conta corrente
        currentAccountList.add(new CurrentAccount(217, 32,23401,1000, 30.12));
        currentAccountList.add(new CurrentAccount(117, 22,34401, -40,35.23));
        fintechAccount.setCurrentAccount(currentAccountList);

        // Adiciono conta de investimento
        investmentAccountList.add(new InvestmentAccount(323, 10, 34210, 1200, 1.32, 10.25));
        fintechAccount.setInvestmentAccount(investmentAccountList);

        fintechAccount.calcBalance();
        System.out.println("Olá " + fintechAccount.getName() + "! Sou a aplicação da Fintech. Aqui estão suas informações:"
                +"\nNome de usuário: "+ fintechAccount.getUserName()
                +"\nTipo de conta: "+ fintechAccount.getAccountType()
                +"\nNome do titular: " + fintechAccount.getName() + " " + fintechAccount.getLastName()
                +"\nCPF: "+ fintechAccount.getCpf()
                +"\nE-mail: "+ fintechAccount.geteMail()
                +"\nEndereço: "+ fintechAccount.getAddress().getCompleteAddress()
        );

        System.out.println("\nSuas contas correntes:");
        for (var account: fintechAccount.getCurrentAccount()) {
            System.out.println("\nAgencia: " + account.getAg()
                    + "\nConta Corrent: " + account.getCc()
                    + "\nSaldo: " + account.getBalance()
            );
        };

        System.out.println("\nSuas contas de investimento:");
        for (var account: fintechAccount.getInvestmentAccount()) {
            System.out.println("\nAgencia: " + account.getAg()
                    + "\nConta Corrent: " + account.getCc()
                    + "\nSaldo: " + account.getBalance()
                    + "\nRentabilidade: " +account.getReturnRate()+"%"
            );
        };


        do {
            System.out.println("-----\nO que você quer fazer? \n[1] Adicionar Recebimento \n[2] Adicionar Dispesa \n[3] Saldo Total \n[4] Sair" );
            op= sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Qual o valor:");
                    double value = sc.nextDouble();
                    incomeList.add(new Income(1, value,"09/09/2024","Recebimento via pix", "Pix",1));
                    fintechAccount.setIncomes(incomeList);
                    fintechAccount.calcBalance();
                    break;
                case 2:
                    System.out.println("Qual o valor:");
                    double value2 = sc.nextDouble();
                    outComeList.add(new OutCome(1, value2,"09/09/2024","Recebimento via pix", 1));
                    fintechAccount.setOutComes(outComeList);
                    fintechAccount.calcBalance();
                    break;
                case 3:
                    System.out.println("Seu saldo é:");
                    if (fintechAccount.getCurrentAccount()!=null){
                        for (var curAccount : fintechAccount.getCurrentAccount()) {
                            System.out.println(curAccount.getBalance());
                        };
                    }
                    if (fintechAccount.getInvestmentAccount()!=null){
                        for (var invAccount : fintechAccount.getInvestmentAccount()) {
                            System.out.println(invAccount.getBalance());
                        };
                    }
                    if (fintechAccount.getIncomes()!=null){
                        for (var transaction : fintechAccount.getIncomes()) {
                            System.out.println(transaction.getValue());
                        };
                    }

                    if (fintechAccount.getOutComes()!=null){
                        for (var transaction : fintechAccount.getOutComes()) {
                            System.out.println("-" + transaction.getValue());
                        };
                    }

                    System.out.println("Balanco: "+ fintechAccount.getBalance());

                    break;
                case 4:
                    System.out.println("Finalizando o programa");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }while(op != 4);

        sc.close();

    }
}