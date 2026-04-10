package org.example;

import java.util.Scanner;

import org.example.enums.*;
import org.example.model.*;
import org.example.service.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PacienteService servicoPaciente = new PacienteService();
        MedicoService servicoMedico = new MedicoService();
        SolicitacoesService servicoSolicitacoes = new SolicitacoesService();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE AVALIAÇÃO =====");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Cadastrar médico");
            System.out.println("4 - Listar médicos");
            System.out.println("5 - Criar solicitação");
            System.out.println("6 - Listar solicitações");
            System.out.println("7 - Atualizar status");
            System.out.println("8 - Painel médico");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Nome:");
                    String nome = sc.nextLine();

                    System.out.println("CPF:");
                    String cpf = sc.nextLine();

                    servicoPaciente.cadastrar(nome, cpf);

                    break;

                case 2:

                    servicoPaciente.listar();

                    break;

                case 3:

                    System.out.println("Nome do médico:");
                    String nomeMed = sc.nextLine();

                    System.out.println("Especialidade:");
                    String esp = sc.nextLine();

                    servicoMedico.cadastrar(nomeMed, esp);

                    break;

                case 4:

                    servicoMedico.listar();

                    break;

                case 5:

                    System.out.println("ID do paciente:");
                    int idP = sc.nextInt();

                    System.out.println("ID do médico:");
                    int idM = sc.nextInt();

                    Paciente p = servicoPaciente.buscar(idP);
                    Medicos m = servicoMedico.buscar(idM);

                    if (p == null || m == null) {

                        System.out.println("Paciente ou médico não encontrado.");
                        break;

                    }

                    System.out.println("Nota (0 a 5):");
                    int nota = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Comentário:");
                    String comentario = sc.nextLine();

                    servicoSolicitacoes.criarSolicitacao(p, m, Categoria.MEDICO, nota, comentario);

                    break;

                case 6:

                    servicoSolicitacoes.listar();

                    break;

                case 7:

                    System.out.println("Protocolo:");
                    int prot = sc.nextInt();

                    servicoSolicitacoes.atualizarStatus(prot, AcompanhamentoDeStatus.FINALIZADO);

                    break;

                case 8:

                    servicoSolicitacoes.painelPorCategoria(Categoria.MEDICO);

                    break;

            }

        } while (opcao != 0);

        sc.close();

    }

}